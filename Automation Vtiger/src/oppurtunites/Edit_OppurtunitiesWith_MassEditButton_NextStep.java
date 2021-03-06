package oppurtunites;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.vtiger.genericlib.WebdriverUtils;
import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.FileUtils;

/**
 * 
 * @author zeliya
 *test case name:Edit_OppurtunitiesWith_MassEditButton_NextStep
 *test case id:tc_16_14
 */
public class Edit_OppurtunitiesWith_MassEditButton_NextStep extends BaseClass{

	@Test
	public  void Edit_OppurtunitiesWith_MassEditButton_NextStepTest() throws Throwable 
	{
	/*	FileUtils fLib = new FileUtils();
		Properties pObj = fLib.getPropertyFileObject();
		String URL = pObj.getProperty("URL");
		String USERNAME = pObj.getProperty("USERNAME");
		String PASSWORD = pObj.getProperty("PASSWORD"); */
		String value = fLib.getExcelData("Sheet1", 1, 3);
		String organization =fLib.getExcelData("Sheet1", 1, 9);
		
		
		/* Test Data */
	//	String username = "admin";
	//	String password = "zeli1234";
	//	String value    = "Not Eligible to Provide Quotes";
	//	String[] oppName = {"opp38","opp39"};
		
		Random num = new Random();
		
		String data1=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String data2=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter =fLib.getExcelData("Sheet1", 1, 14)+num.nextInt(200);
		
		String output1= fLib.getExcelData("Sheet1", 7, 0);
		String output2= fLib.getExcelData("Sheet1", 7, 1);
		String output3= fLib.getExcelData("Sheet1", 7, 2);
		String output4= fLib.getExcelData("Sheet1", 7, 3);
		String output5= fLib.getExcelData("Sheet1", 7, 4);
		String output9= fLib.getExcelData("Sheet1", 4, 9);
		String output10= fLib.getExcelData("Sheet1", 4, 10);
		/*String data1="opp"+num.nextInt(200);
		String data2="opp"+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter ="New"+num.nextInt(200);*/
		
		/*1.navigate to application  */
	/*	WebdriverUtils wLib = new WebdriverUtils();
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();   */
		
		/* verify login page  */
		String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
		 if(actlogPage.contains(explogPage))
		 {
			 System.out.println(output9);
		 }
		 else
		 {
			 System.out.println(output10);
		 }
		
		/*2.login to application */
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		wLib.waitForPageLoad(driver);   */
		
		/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		/* verify Oppurtunities List Page  */
		 String expoppPage1 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage1 = driver.getTitle();
		 if(expoppPage1.equals(actoppPage1))
		 {
			 System.out.println("Oppurtunities List Page is verified PASS");
		 }
		 else
		 {
			 System.out.println("Oppurtunities List Page is not verified FAIL");
		 }
		
		 /* create multiple oppurtunities */
		 for(int i=0;i<oppName.length;i++)
			{
			    driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			    wLib.waitForPageLoad(driver);
				driver.findElement(By.name("potentialname")).sendKeys(oppName[i]);
				driver.findElement(By.xpath("//input[@name='related_to_display']/../img[@src='themes/softed/images/select.gif']")).click();
				
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				String parentId = it.next();
				String childId = it.next();
				driver.switchTo().window(childId);
				driver.findElement(By.xpath("//a[text()='"+organization+"']")).click();
				driver.switchTo().window(parentId);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.switchTo().window(parentId);
				wLib.waitForPageLoad(driver);
				
				driver.findElement(By.name("button")).click();
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				wLib.waitForPageLoad(driver);
				driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				wLib.waitForPageLoad(driver);
			}
		 
		 /*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		 
		List<WebElement> lst=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		wLib.waitForPageLoad(driver);
		
		 for(int i=0;i<lst.size();i++)
		 {
			//System.out.println(data.getText()); 
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
				 String x=	"//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[j]+"']/../preceding-sibling::td[2]";
			 	 driver.findElement(By.xpath(x)).click();
			 	wLib.waitForPageLoad(driver);
			 	
			 	}
			}
		 }
		 wLib.waitForPageLoad(driver);
		 driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		 wLib.waitForPageLoad(driver);
		 
		/*5.enter the value in "NextStep" edit box */
		driver.findElement(By.id("nextstep")).sendKeys(value);
		
		 /*6.click on save */
		 driver.findElement(By.name("button")).click();
		 
		 /* verify Oppurtunities List Page  */
		 
		 String expoppPage2 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage2 = driver.getTitle();
		 if(expoppPage2.equals(actoppPage2))
		 {
			 System.out.println("Oppurtunities List Page is verified PASS");
		 }
		 else
		 {
			 System.out.println("Oppurtunities List Page is not verified FAIL");
		 }
		 
		 /* validation */
		 
			/*create filter */
			driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.name("viewName")).sendKeys(filter);
			WebElement wb = driver.findElement(By.name("column6"));
			Select sel4 = new Select(wb);
			sel4.selectByVisibleText("Amount");
			WebElement wb1 = driver.findElement(By.name("column7"));
			Select sel1 = new Select(wb1);
			sel1.selectByVisibleText("Lead Source");
			WebElement wb2 = driver.findElement(By.name("column8"));
			Select sel2 = new Select(wb2);
			sel2.selectByVisibleText("Next Step");
			WebElement wb3 = driver.findElement(By.name("column9"));
			Select sel3 = new Select(wb3);
			sel3.selectByVisibleText("Type");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
			{   
			      String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[7]")).getText();
			      if(value.equals(value1))
			      {
			    	  System.out.println(output1+oppName[i]+output2+value1+output3);
				 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			      }
			      else
			      {
			    	  System.out.println(output4+oppName[i]+output5);  
			      }
			
			  }
			wLib.waitForPageLoad(driver);
			
		/*7. Log Out the application*/
		/*    WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(img).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.close();   */
	}

}

