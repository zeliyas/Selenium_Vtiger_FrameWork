package quotes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOppurtunities {

	public static void main(String[] args) throws InterruptedException
	{
		/* Test Data */
		String username = "admin";
		String password = "zeli1234";
		String[] arr = {"opp11","opp12"};
		
		
		/*1.navigate to application  */
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		/* verify login page  */
		 String explogPage ="vtiger CRM 5 - Commercial Open Source CRM";
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
		 if(explogPage.equals(actlogPage))
		 {
			 System.out.println("Login Page is verified PASS");
		 }
		 else
		 {
			 System.out.println("Login Page is not verified FAIL");
		 }
			 
		/*2.login to application */
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		/* create oppurtunities */
		for(int i=0;i<arr.length;i++)
		{
		    driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			Thread.sleep(5000);
			driver.findElement(By.name("potentialname")).sendKeys(arr[i]);
			Thread.sleep(10000);
			driver.findElement(By.name("button")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
			
		}

	}

	
