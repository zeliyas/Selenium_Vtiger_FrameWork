package quotes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author zeliya
 *test case name:Edit_OppurtunitiesWith_MassEditButton_NextStep
 *test case id:tc_16_14
 */
public class Edit_OppurtunitiesWith_MassEditButton_NextStep {

	public static void main(String[] args) throws InterruptedException 
	{
		/* Test Data */
		String username = "admin";
		String password = "zeli1234";
		String value    = "Not Eligible to Provide Quotes";
		
		/*1.navigate to application  */
		WebDriver driver = new FirefoxDriver();
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
		 String[] oppName = {"opp5","opp6"};
		 
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
				if(d1.equals(oppName[j]))
			 	{
				 String x=	"//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[j]+"']/../preceding-sibling::td[2]";
			 	 driver.findElement(By.xpath(x)).click();
			 	 Thread.sleep(2000);
			 	
			 	}
			}
		 }
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		 Thread.sleep(2000);
		 
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
		 
			List<WebElement> lst1=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
			Thread.sleep(4000);
			int size = lst1.size();
			 for(int i=0;i<size;i++)
			 { 
				 List<WebElement> lst2=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				String d2 = lst2.get(i).getText();
				//System.out.println(d2);
				for(int j=0;j<oppName.length;j++)
				{
					if(d2.equals(oppName[j]))
				 	{
					 String x1=	"//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[j]+"']";
				 	 driver.findElement(By.xpath(x1)).click();
				 	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 	 
				 	 String actvalue = driver.findElement(By.id("dtlview_Next Step")).getText();
				 	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 	// System.out.println(actvalue);
				 	 if(value.equals(actvalue))
				 	 {
				 		 System.out.println("The Assigned to value is changed for the oppurtunities record with Oppurtunity name "+oppName[j]+" to "+actvalue+" --> PASS");
				 		 driver.navigate().back();
				 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 				 		 
				 	 
				 	 }
				 	 else
				 	 {
				 		System.out.println("The Assigned to value is not changed for the oppurtunities record with Oppurtunity name "+oppName[j]+" --> FAIL");
				 	 } 
				 	}
				}
			 }
		
		/*7. Log Out the application*/
		 WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(img).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			Thread.sleep(3000);
	}

}
