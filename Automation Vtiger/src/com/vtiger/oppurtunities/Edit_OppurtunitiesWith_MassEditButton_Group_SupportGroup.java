package com.vtiger.oppurtunities;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vtiger.genericlib.WebdriverUtils;
import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.FileUtils;

/**
 * 
 * @author zeliya
 *test case name:Edit_OppurtunitiesWith_MassEditButton_Group_SupportGroup
 *test case id: tc_16_8
 */
public class Edit_OppurtunitiesWith_MassEditButton_Group_SupportGroup extends BaseClass {

	@Test
	public  void Edit_OppurtunitiesWith_MassEditButton_Group_SupportGroupTest() throws Throwable 
	{
	/*	FileUtils fLib = new FileUtils();
		Properties pObj = fLib.getPropertyFileObject();
		String URL = pObj.getProperty("URL");
		String USERNAME = pObj.getProperty("USERNAME");
		String PASSWORD = pObj.getProperty("PASSWORD");  */
		
		String value = fLib.getExcelData("Sheet1", 1, 1);
		/* Test Data */
	//	String username = "admin";
	//	String password = "zeli1234";
	//	String[] oppName = {"opp33","opp34"};
	//	String value     = "Support Group";
		
		Random num = new Random();
		
		String data1=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String data2=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter =fLib.getExcelData("Sheet1", 1, 14)+num.nextInt(200);
		//String organization =fLib.getExcelData("Sheet1", 1, 9);
		String organization =fLib.getExcelData("Sheet1", 1, 9)+num.nextInt(200);
		String expoppPage1 = fLib.getExcelData("Sheet1", 4, 11);
		
		String output1= fLib.getExcelData("Sheet1", 5, 0);
		String output2= fLib.getExcelData("Sheet1", 5, 1);
		String output3= fLib.getExcelData("Sheet1", 5, 2);
		String output4= fLib.getExcelData("Sheet1", 5, 3);
		String output5= fLib.getExcelData("Sheet1", 5, 4);
		String output9= fLib.getExcelData("Sheet1", 4, 9);
		String output10= fLib.getExcelData("Sheet1", 4, 10);
		String output11= fLib.getExcelData("Sheet1", 4, 12);
		String output12= fLib.getExcelData("Sheet1", 4, 13);
		
		
		/*1.navigate to application  */
	/*	WebdriverUtils wLib = new WebdriverUtils();
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();*/
		
		/* verify login page  */
		 String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
		/* try
		 { Assert.assertTrue(actlogPage.contains(explogPage));
			 System.out.println(output9);
		 }
		 catch (AssertionError e)
		 {
			 System.out.println(output10);
		 } */
		 
		 Assert.assertTrue(actlogPage.contains(explogPage), output10 );
		 System.out.println(output9);
			 
		 
		/*2.login to application */
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		wLib.waitForPageLoad(driver);     */
		 
		 /*3.Create organization */
			
			/* navigate to "organization" List Page by Clicking on "organization" tab*/
			driver.findElement(By.linkText("Organizations")).click();
			wLib.waitForPageLoad(driver);  
			
			/*create */
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			wLib.waitForPageLoad(driver);
			driver.findElement(By.name("accountname")).sendKeys(organization);
			driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
			wLib.waitForPageLoad(driver); 
		
		/*4.navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
			WebElement wb7 = driver.findElement(By.className("dvHeaderText"));
		    wLib.waitForCompleteElementToLoad(wb7);
		   driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		/* verify Oppurtunities List Page  */
		// String expoppPage1 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage1 = driver.getTitle();
	/*	 try
		 { 
			 Assert.assertEquals(expoppPage1, actoppPage1);
			 System.out.println(output11);
		 }
		 catch(AssertionError e)
		 {
			 System.out.println(output12);
		 } */
		    Assert.assertEquals(expoppPage1, actoppPage1, output12); 
			System.out.println(output11);
		
		
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
				driver.findElement(By.name("button")).click();
				wLib.waitForPageLoad(driver);
				driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
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
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/* 5.select "SupportGroup" after clicking the radio button of "Group"  */
		 driver.findElement(By.xpath("//input[@value='T']")).click();
		 WebElement wbd =  driver.findElement(By.name("assigned_group_id"));
		 Select sel = new Select(wbd);
		 sel.selectByVisibleText(value);
		 driver.findElement(By.id("assigned_user_id_mass_edit_check")).click();
		 
		 /* click on save */
		 driver.findElement(By.name("button")).click();
		 
         /* verify Oppurtunities List Page  */
		 
		// String expoppPage2 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage2 = driver.getTitle();
		/* try 
		 {  Assert.assertEquals(expoppPage1, actoppPage2);
			 System.out.println(output11);
		 }
		 catch(AssertionError e)
		 {
			 System.out.println(output12);
		 }  */
		    Assert.assertEquals(expoppPage1, actoppPage2, output12); 
			System.out.println(output11);
		 
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
			wLib.waitForPageLoad(driver);
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
			{   
			      String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[3]")).getText();
			    
			  /*    try
			      {   Assert.assertEquals(value, value1);
			    	  System.out.println(output1+oppName[i]+output2+value1+output3);
				 		wLib.waitForPageLoad(driver);
			      }
			      catch(AssertionError e)
			      {
			    	  System.out.println(output4+oppName[i]+output5);  
			      }  */
			      
			        Assert.assertEquals(value, value1, output4+oppName[i]+output5); //if fails then print this
					System.out.println(output1+oppName[i]+output2+value1+output3);// if pass then print this
			
			  }
			 
		
		/*6 Log Out the application*/
	/*	 WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(img).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			wLib.waitForPageLoad(driver);
			driver.close();  */
		
	}

}

