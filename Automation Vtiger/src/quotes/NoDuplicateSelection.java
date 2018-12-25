package quotes;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import jdk.jfr.SettingDescriptor;
import com.vtiger.genericlib.WebdriverUtils;

/**
 * 
 * @author zeliya
 *test case name:Edit_OppurtunitiesWith_MassEditButton_Amount
 *test case id:tc_16_12
 */

		public class NoDuplicateSelection
		{			
			public static void main(String[] args) throws InterruptedException
			{
			/* Test Data */
			String username  = "admin";
			String password  = "zeli1234";
			String amount    = "5,000";
			
			Random num = new Random();
			
			String data1="opp"+num.nextInt(200);
			String data2="opp"+num.nextInt(200);
			String[] oppName = {data1,data2};
			String filter ="New"+num.nextInt(200);
			
			
			
			/*1.navigate to application  */
			WebdriverUtils wLib = new WebdriverUtils();
			WebDriver driver = new FirefoxDriver();
			wLib.waitForPageLoad(driver);
			driver.get("http://localhost:8888/");
			driver.manage().window().maximize();
			wLib.waitForPageLoad(driver);
			
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
			Thread.sleep(4000);
			
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
					Thread.sleep(5000);
					driver.findElement(By.name("potentialname")).sendKeys(oppName[i]);
					driver.findElement(By.xpath("//input[@name='related_to_display']/../img[@src='themes/softed/images/select.gif']")).click();
					
					Set<String> set = driver.getWindowHandles();
					Iterator<String> it = set.iterator();
					String parentId = it.next();
					String childId = it.next();
					driver.switchTo().window(childId);
					driver.findElement(By.xpath("//a[text()='Home Credit']")).click();
					driver.switchTo().window(parentId);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.switchTo().window(parentId);
					Thread.sleep(5000);
					driver.findElement(By.name("button")).click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
				}
			 
			 
			/*4.select the particular rows of oppurtunites you want to edit by clicking on the
			  corresponding checkboxes and then click on "Mass Edit"  button */
			 
			List<WebElement> lst=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
			Thread.sleep(4000);
			
			 for(int i=0;i<lst.size();i++)
			 {
				//System.out.println(data.getText()); 
				String d1 = lst.get(i).getText();
				System.out.println(d1);
				for(int j=0;j<oppName.length;j++)
				{
				/* String x= "//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[i]+"']";
				 driver.findElement(By.xpath(x)).click();  */
					if(d1.equals(oppName[j]))
				 	{
					 String x=	"//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[j]+"']/../preceding-sibling::td[2]";
				 	  driver.findElement(By.xpath(x)).click();
				 	  Thread.sleep(2000);
				 	  wLib.waitForPageLoad(driver);
				 	 
				 	}
				  }
				
				
			 }
			 Thread.sleep(3000);
			 
			 
		/*	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]")).click();
			driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[1]")).click(); */
			driver.findElement(By.xpath("//input[@value='Mass Edit']")).click(); 
			wLib.waitForPageLoad(driver);
			
			
			/*5.enter the "Amount" value */
			 driver.findElement(By.name("amount")).sendKeys(amount);     
			
			 /*6.click on save */
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			 /* verify Opportunities List Page  */
			 
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
				Select sel = new Select(wb);
				sel.selectByVisibleText("Amount");
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
				      String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[5]")).getText();
				      if(amount.equals(value1))
				      {
				    	  System.out.println("The amount value is changed for the oppurtunities record with Oppurtunity name "+oppName[i]+" to "+value1+" --> PASS");
					 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				      }
				      else
				      {
				    	  System.out.println("The amount value is not changed for the oppurtunities record with Oppurtunity name "+oppName[i]+" --> FAIL");  
				      }
				
				  }
				 
				
			
			/*7. Log Out the application*/
		    	WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(img).perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				wLib.waitForPageLoad(driver);
				driver.close();
			

		}

	}




