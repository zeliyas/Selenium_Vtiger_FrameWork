package com.vtiger.genericlib;
import com.vtiger.objectrepositorylib.*;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	public static WebDriver driver;
	public FileUtils fLib = new FileUtils();
	public WebdriverUtils wLib = new WebdriverUtils();
	@BeforeClass
	public void configBC() throws Throwable
	{
		Reporter.log("Launch Browser", true);
		Properties pObj = fLib.getPropertyFileObject();
		String BROWSER = pObj.getProperty("BROWSER");
		if(BROWSER.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			driver = new ChromeDriver();
					
		}
		else if(BROWSER.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("Ie"))
		{
			System.setProperty("webdriver.ie.driver", "./resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);		
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable
	{
		Reporter.log("Login", true);
		Properties pObj = fLib.getPropertyFileObject();
		String URL = pObj.getProperty("URL");
		String USERNAME = pObj.getProperty("USERNAME");
		String PASSWORD = pObj.getProperty("PASSWORD");
		driver.get(URL);
		
		Login loginPage = PageFactory.initElements(driver, Login.class );
		loginPage.loginToApp(USERNAME, PASSWORD);
		wLib.waitForPageLoad(driver);
		
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();	*/
		wLib.waitForPageLoad(driver);
	}
	
	@AfterMethod
	public void configAM()
	{
		Reporter.log("Logout", true);
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.logoutFromApp();
		wLib.waitForPageLoad(driver);
		
	/*	WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click(); */
		
	}
	
	@AfterClass
	public void configAC()
	{
			Reporter.log("Close Browser", true);
			driver.close();
	}
	
}

