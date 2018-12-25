package quotes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author zeliya
 *test case name:Edit_OppurtunitiesWith_MassEditButton_Amount
 *test case id:tc_16_12
 */
public class Edit_OppurtunitiesWith_MassEditButton_Amount {

	public static void main(String[] args) throws InterruptedException
	{
		/* Test Data */
		String username = "admin";
		String password = "zeli1234";
		String amount   = "5,000";
		String[] oppName = {"opp25","opp26"};
		
		
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
		 String[] optNo = new String[10];
		 for(int i=0;i<oppName.length;i++)
			{
			    driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
				Thread.sleep(5000);
				driver.findElement(By.name("potentialname")).sendKeys(oppName[i]);
				Thread.sleep(10000);
				driver.findElement(By.name("button")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				optNo[i]= driver.findElement(By.xpath("//span[@id='dtlview_Opportunity Name']/../following-sibling::td[@class='dvtCellInfo']")).getText();
				System.out.println(optNo[i]);
				Thread.sleep(3000);
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
			 	
			 	}
			}
		 }
		 Thread.sleep(3000);
		 
		 
	/*	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[1]")).click(); */
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click(); 
		Thread.sleep(4000);
		
		
		/*5.enter the "Amount" value */
		 driver.findElement(By.name("amount")).sendKeys(amount);     
		
		 /*6.click on save */
		 driver.findElement(By.name("button")).click();
		 
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
			driver.findElement(By.name("viewName")).sendKeys("new10");
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
			sel3.selectByVisibleText("Opportunity No");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			/*Select filter */
	/*		WebElement wb4 = driver.findElement(By.name("viewname"));
			Select sel4 = new Select(wb4);
			sel4.selectByVisibleText("new4");
	*/
			
			/* Checking the value has been changed or not */
			////table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='opp8']/../following-sibling::td[5]
			List<WebElement> lst3 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[10]"));
			System.out.println(lst3.size());
			Thread.sleep(3000);
			List<WebElement> lst4 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a"));
					//[text()='opp8']/../following-sibling::td[5]
			System.out.println(lst4.size());
			Thread.sleep(3000);
			for(int i =0;i<lst3.size();i++)
			{      String x1= lst3.get(i).getText();
					System.out.println(x1);
					for(int j=0;j<optNo.length;j++)
					{    Thread.sleep(3000);
						if(optNo[j].equals(x1))
						{
							String d2 = lst4.get(i).getText();
							System.out.println(d2);
							 String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName+"']/../following-sibling::td[5]")).getText();
							 Thread.sleep(3000);
							 if(amount.equals(value1))
						      {
						    	  System.out.println("The amount value is changed for the oppurtunities record with Oppurtunity name "+oppName[i]+" to "+value1+" --> PASS");
							 		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						    	  Thread.sleep(3000);
						      }
						      else
						      {
						    	  System.out.println("The amount value is not changed for the oppurtunities record with Oppurtunity name "+oppName[i]+" --> FAIL");  
						      }
						
						
						}
						else
						{
							System.out.println("NO");
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
		 
		 
		 
		 
		 
		 
	/*	List<WebElement> lst1=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
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
			 	 Thread.sleep(4000);
			 	 String value = driver.findElement(By.id("dtlview_Amount")).getText();
			 	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 	// System.out.println(value);
			 	 if(amount.equals(value))
			 	 {
			 		 System.out.println("The amount value is changed for the oppurtunities record with Oppurtunity name "+oppName[j]+" to "+value+" --> PASS");
			 		 driver.navigate().back();
			 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 		// driver.navigate().refresh();
			 		 
			 	 
			 	 }
			 	 else
			 	 {
			 		System.out.println("The amount value is not changed for the oppurtunities record with Oppurtunity name "+oppName[j]+" --> FAIL");
			 	 }
			 	}
			}
		 }   */
		
		
		

	


