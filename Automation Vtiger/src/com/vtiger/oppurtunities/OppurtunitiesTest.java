package com.vtiger.oppurtunities;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * @author zeliya
 */
import com.vtiger.genericlib.BaseClass;
import com.vtiger.objectrepositorylib.CreatingNewOpportunity;
import com.vtiger.objectrepositorylib.CreatingNewOrganization;
import com.vtiger.objectrepositorylib.Home;
import com.vtiger.objectrepositorylib.Login;
import com.vtiger.objectrepositorylib.MassEditRecordsField;
import com.vtiger.objectrepositorylib.NewCustomView;
import com.vtiger.objectrepositorylib.Oppurtunities;
import com.vtiger.objectrepositorylib.Organizations;
import com.vtiger.objectrepositorylib.OrganizationsWindow;

@Listeners(com.vtiger.genericlib.ListenerImplementationClass.class)
public class OppurtunitiesTest extends BaseClass
{
	@Test(groups= {"regressionTest"})
	public  void edit_OppurtunitiesWith_MassEditButton_AmountTest() throws Throwable
	{
		
		String amount = fLib.getExcelData("Sheet1", 1, 0);
		String output1= fLib.getExcelData("Sheet1", 4, 0);
		String output2= fLib.getExcelData("Sheet1", 4, 1);
		String output3= fLib.getExcelData("Sheet1", 4, 2);
		String output4= fLib.getExcelData("Sheet1", 4, 3);
		String output5= fLib.getExcelData("Sheet1", 4, 4);
		String output9= fLib.getExcelData("Sheet1", 4, 9);
		String output10= fLib.getExcelData("Sheet1", 4, 10);
		String output11= fLib.getExcelData("Sheet1", 4, 12);
		String output12= fLib.getExcelData("Sheet1", 4, 13);
		
		String filter1 =fLib.getExcelData("Sheet1", 0, 0);
		String filter2 =fLib.getExcelData("Sheet1", 0, 2);
		String filter3 =fLib.getExcelData("Sheet1", 0, 3);
		String filter4 =fLib.getExcelData("Sheet1", 0, 4);
		
	
		Random num = new Random();
		
		String data1=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String data2=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter =fLib.getExcelData("Sheet1", 1, 14)+num.nextInt(200);
	
		String organization =fLib.getExcelData("Sheet1", 1, 9)+num.nextInt(200);
	    String expoppPage1 = fLib.getExcelData("Sheet1", 4, 11);
		
			
		/* verify login page  */
		 String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
	
		 Assert.assertTrue(actlogPage.contains(explogPage), output10 );
		 System.out.println(output9);
		 
	    
		 	/*3.Create organization */
			
			/* navigate to "organization" List Page by Clicking on "organization" tab*/
		/*	driver.findElement(By.linkText("Organizations")).click();
			wLib.waitForPageLoad(driver); */ 
		 	
		 Home homePage =PageFactory.initElements(driver, Home.class);
		 homePage.navigateToOrganization();
		
			
			/*create */
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			wLib.waitForPageLoad(driver); */
		 
		 Organizations organizationPage = PageFactory.initElements(driver, Organizations.class);
		 organizationPage.navigateToCreateOrganization();
		 
		 CreatingNewOrganization creatingNewOrganizationPage = PageFactory.initElements(driver, CreatingNewOrganization.class);
		 creatingNewOrganizationPage.createNewOrganization(organization);
		 
		/*	driver.findElement(By.name("accountname")).sendKeys(organization);
			driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
			wLib.waitForPageLoad(driver);  */
					
			/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
			
			 organizationPage.navigateToOpportunities();
			 
		/*	WebElement wb7 = driver.findElement(By.className("dvHeaderText"));
		    wLib.waitForCompleteElementToLoad(wb7);
			driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
			wLib.waitForPageLoad(driver);  */
			
			/* verify Oppurtunities List Page  */
		//	 String expoppPage1 = fLib.getExcelData("Sheet1", 4, 11);
			 String actoppPage1 = driver.getTitle();
		
    		Assert.assertEquals(expoppPage1, actoppPage1, output12); 
			System.out.println(output11);
			
		/* create multiple oppurtunities */
		 for(int i=0;i<oppName.length;i++)
			{
			    Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
			    oppurtunitiesPage.navigateToCreateOpportunity();
			    
			   /* driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			    wLib.waitForPageLoad(driver);  */
			    String oppName1= oppName[i];
			    CreatingNewOpportunity creatingNewOppurtinityPage =PageFactory.initElements(driver, CreatingNewOpportunity.class);
			    creatingNewOppurtinityPage.createNewOpportunity(oppName1);
				/*driver.findElement(By.name("potentialname")).sendKeys(oppName[i]);
				driver.findElement(By.xpath("//input[@name='related_to_display']/../img[@src='themes/softed/images/select.gif']")).click();  */
				
			    OrganizationsWindow organizationWindow = PageFactory.initElements(driver, OrganizationsWindow.class);
			    organizationWindow.getOrgNameLink(organization);
			    
			    organizationWindow.orgWindow();
			    
			   
			    
			    
			    
			/*	Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				String parentId = it.next();
				String childId = it.next();
				driver.switchTo().window(childId);
				driver.findElement(By.xpath("//a[text()='"+organization+"']")).click();
				driver.switchTo().window(parentId);
				wLib.waitForPageLoad(driver); */
			
			    creatingNewOppurtinityPage.save();
			    
			/*	driver.findElement(By.name("button")).click();
				wLib.waitForPageLoad(driver); */
			    
			    organizationPage.navigateToOpportunities();
			/*	driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
				wLib.waitForPageLoad(driver); */
			}
		 
		 
		/*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		 
	/*	List<WebElement> lst=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		wLib.waitForPageLoad(driver); */
		
		Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
		List<WebElement> lst = oppurtunitiesPage.getLst();
	    
		 for(int i=0;i<lst.size();i++)
		 {
			//System.out.println(data.getText()); 
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
					String oppName1 = oppName[j];
					oppurtunitiesPage.getOppTable(oppName1);
					oppurtunitiesPage.selectRows(oppName);
				// String x=	"//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[j]+"']/../preceding-sibling::td[2]";
			 	// driver.findElement(By.xpath(x)).click();
			 	//wLib.waitForPageLoad(driver);
			 	
			 	}
			}
		 } 
		
	/*	driver.findElement(By.xpath("//input[@value='Mass Edit']")).click(); 
		wLib.waitForPageLoad(driver);*/
		
	    
	    oppurtunitiesPage.navigateToMassEditPage();
		
		/*5.enter the "Amount" value */
	    MassEditRecordsField massEditRecordFieldPage = PageFactory.initElements(driver, MassEditRecordsField.class);
	    massEditRecordFieldPage.massEditRecord(amount);
	/*	 driver.findElement(By.name("amount")).sendKeys(amount);    */ 
		
		 /*6.click on save */
	    massEditRecordFieldPage.save();
		/* driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();  */
		 
		 /* verify Opportunities List Page  */
		 
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
		 
		 oppurtunitiesPage.navigateToCreateFilter();
		 
		 NewCustomView newCustomViewPage = PageFactory.initElements(driver, NewCustomView.class);
		 newCustomViewPage.newCustomView(filter,filter1,filter2,filter3,filter4);
		/*	driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
			wLib.waitForPageLoad(driver);
			
			
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
			wLib.waitForPageLoad(driver);   */
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
				 
			{  
				String oppName2= oppName[i];
				WebElement wb= oppurtunitiesPage.getOppTableAmount(oppName2);
				String value1 = wb.getText();
			    /*  String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[5]")).getText(); */
			        Assert.assertEquals(amount, value1, output4+oppName[i]+output5); //if fails then print this
					System.out.println(output1+oppName[i]+output2+value1+output3);// if pass then print this
			
			}
			 
	}

			 


			 
	
	@Test(groups= {"regressionTest"})
	public  void Edit_OppurtunitiesWith_MassEditButton_Group_SupportGroupTest() throws Throwable 
	{
	
		/* Test Data */
		
		String value = fLib.getExcelData("Sheet1", 1, 1);
		
	
		
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
		
		String filter1 =fLib.getExcelData("Sheet1", 0, 0);
		String filter2 =fLib.getExcelData("Sheet1", 0, 2);
		String filter3 =fLib.getExcelData("Sheet1", 0, 3);
		String filter4 =fLib.getExcelData("Sheet1", 0, 4);
		
		
		/*1.navigate to application  */
	
		
		/* verify login page  */
		 String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
				 
		 Assert.assertTrue(actlogPage.contains(explogPage), output10 );
		 System.out.println(output9);
			 
		 
		/*2.login to application */
	
		 
		 
		 	/*3.Create organization */
			
			/* navigate to "organization" List Page by Clicking on "organization" tab*/
		 	
		 Home homePage =PageFactory.initElements(driver, Home.class);
		 homePage.navigateToOrganization();
		
			
			/*create */
		 
		 Organizations organizationPage = PageFactory.initElements(driver, Organizations.class);
		 organizationPage.navigateToCreateOrganization();
		 
		 CreatingNewOrganization creatingNewOrganizationPage = PageFactory.initElements(driver, CreatingNewOrganization.class);
		 creatingNewOrganizationPage.createNewOrganization(organization);
		 
					
			/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
			
			 organizationPage.navigateToOpportunities();
			 
			 String actoppPage1 = driver.getTitle();
		
 		Assert.assertEquals(expoppPage1, actoppPage1, output12); 
			System.out.println(output11);
			
		/* create multiple oppurtunities */
		 for(int i=0;i<oppName.length;i++)
			{
			    Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
			    oppurtunitiesPage.navigateToCreateOpportunity();
			    
			    String oppName1= oppName[i];
			    CreatingNewOpportunity creatingNewOppurtinityPage =PageFactory.initElements(driver, CreatingNewOpportunity.class);
			    creatingNewOppurtinityPage.createNewOpportunity(oppName1);
				
				
			    OrganizationsWindow organizationWindow = PageFactory.initElements(driver, OrganizationsWindow.class);
			    organizationWindow.getOrgNameLink(organization);
			    
			    organizationWindow.orgWindow();
			  
			
			    creatingNewOppurtinityPage.save();
			 
			    
			    organizationPage.navigateToOpportunities();
			}
		 
		 
		/*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		 
	
		
		Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
		List<WebElement> lst = oppurtunitiesPage.getLst();
	    
		 for(int i=0;i<lst.size();i++)
		 {
			
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
					String oppName1 = oppName[j];
					oppurtunitiesPage.getOppTable(oppName1);
					oppurtunitiesPage.selectRows(oppName);
							 	
			 	}
			}
		 } 
		
		    
	    oppurtunitiesPage.navigateToMassEditPage();
		
		/* 5.select "SupportGroup" after clicking the radio button of "Group"  */
	    
	    MassEditRecordsField massEditRecordFieldPage = PageFactory.initElements(driver, MassEditRecordsField.class);
	    massEditRecordFieldPage.selectSupportGroup(value);
	    
		/* driver.findElement(By.xpath("//input[@value='T']")).click();
		 WebElement wbd =  driver.findElement(By.name("assigned_group_id"));
		 Select sel = new Select(wbd);
		 sel.selectByVisibleText(value);
		 driver.findElement(By.id("assigned_user_id_mass_edit_check")).click();*/
		 
		 /* click on save */
	    
	    massEditRecordFieldPage.save();
		/* driver.findElement(By.name("button")).click(); */
		 
         /* verify Oppurtunities List Page  */
		 
				 String actoppPage2 = driver.getTitle();
		
		 Assert.assertEquals(expoppPage1, actoppPage2, output12); 
		 System.out.println(output11);
		 
		 /* validation */
		 
			/*create filter */
		
		 oppurtunitiesPage.navigateToCreateFilter();
		 
		 NewCustomView newCustomViewPage = PageFactory.initElements(driver, NewCustomView.class);
		 newCustomViewPage.newCustomView(filter,filter1,filter2,filter3,filter4);
		 
		 /*driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
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
			wLib.waitForPageLoad(driver);  */
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
			{   
				String oppName3= oppName[i];
				WebElement wb= oppurtunitiesPage.getOppTableSupportGroup(oppName3);
				String value1 = wb.getText();
			   //   String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[3]")).getText();
			    			      
			        Assert.assertEquals(value, value1, output4+oppName[i]+output5); //if fails then print this
					System.out.println(output1+oppName[i]+output2+value1+output3);// if pass then print this
			
			  }
			 		
	}

	@Test(groups= {"regressionTest"})
	public  void Edit_OppurtunitiesWith_MassEditButton_LeadSource_WebsiteTest() throws Throwable {

	
		String value = fLib.getExcelData("Sheet1", 1, 2);
				
		String expoppPage1 = fLib.getExcelData("Sheet1", 4, 11);
		
		/* Test Data */
	
		
		Random num = new Random();
		String data1=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String data2=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter =fLib.getExcelData("Sheet1", 1, 14)+num.nextInt(200);
		String organization =fLib.getExcelData("Sheet1", 1, 9)+num.nextInt(200);
		
		String output1= fLib.getExcelData("Sheet1", 6, 0);
		String output2= fLib.getExcelData("Sheet1", 6, 1);
		String output3= fLib.getExcelData("Sheet1", 6, 2);
		String output4= fLib.getExcelData("Sheet1", 6, 3);
		String output5= fLib.getExcelData("Sheet1", 6, 4);
		String output9= fLib.getExcelData("Sheet1", 4, 9);
		String output10= fLib.getExcelData("Sheet1", 4, 10);
		String output11= fLib.getExcelData("Sheet1", 4, 12);
		String output12= fLib.getExcelData("Sheet1", 4, 13);
		
		String filter1 =fLib.getExcelData("Sheet1", 0, 0);
		String filter2 =fLib.getExcelData("Sheet1", 0, 2);
		String filter3 =fLib.getExcelData("Sheet1", 0, 3);
		String filter4 =fLib.getExcelData("Sheet1", 0, 4);
		
				
		/*1.navigate to application  */
			
		/* verify login page  */
		String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
				 
		 Assert.assertTrue(actlogPage.contains(explogPage), output10 );
		 System.out.println(output9);
			 
		 
		/*2.login to application */
	
		 
		 	/*3.Create organization */
			
			/* navigate to "organization" List Page by Clicking on "organization" tab*/
		 	
		 Home homePage =PageFactory.initElements(driver, Home.class);
		 homePage.navigateToOrganization();
		
			
			/*create */
		 
		 Organizations organizationPage = PageFactory.initElements(driver, Organizations.class);
		 organizationPage.navigateToCreateOrganization();
		 
		 CreatingNewOrganization creatingNewOrganizationPage = PageFactory.initElements(driver, CreatingNewOrganization.class);
		 creatingNewOrganizationPage.createNewOrganization(organization);
		 
					
			/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
			
			 organizationPage.navigateToOpportunities();
			 
			 String actoppPage1 = driver.getTitle();
		
 		Assert.assertEquals(expoppPage1, actoppPage1, output12); 
			System.out.println(output11);
			
		/* create multiple oppurtunities */
		 for(int i=0;i<oppName.length;i++)
			{
			    Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
			    oppurtunitiesPage.navigateToCreateOpportunity();
			    
			    String oppName1= oppName[i];
			    CreatingNewOpportunity creatingNewOppurtinityPage =PageFactory.initElements(driver, CreatingNewOpportunity.class);
			    creatingNewOppurtinityPage.createNewOpportunity(oppName1);
				
				
			    OrganizationsWindow organizationWindow = PageFactory.initElements(driver, OrganizationsWindow.class);
			    organizationWindow.getOrgNameLink(organization);
			    
			    organizationWindow.orgWindow();
			  
			
			    creatingNewOppurtinityPage.save();
			 
			    
			    organizationPage.navigateToOpportunities();
			}
		 
		 
		/*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		 
	
		
		Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
		List<WebElement> lst = oppurtunitiesPage.getLst();
	    
		 for(int i=0;i<lst.size();i++)
		 {
			
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
					String oppName1 = oppName[j];
					oppurtunitiesPage.getOppTable(oppName1);
					oppurtunitiesPage.selectRows(oppName);
							 	
			 	}
			}
		 } 
		
		    
	    oppurtunitiesPage.navigateToMassEditPage();
		
		/* 5.select the "Website" by clicking  on the "Lead Source" drop down menu */
	/*	 WebElement wbd =  driver.findElement(By.name("leadsource"));
		 Select sel = new Select(wbd);
		 sel.selectByVisibleText(value);*/
		 
		  MassEditRecordsField massEditRecordFieldPage = PageFactory.initElements(driver, MassEditRecordsField.class);
		  massEditRecordFieldPage.selectLeadSourceWebsite(value);
	    
		 /*6.click on save */
		 massEditRecordFieldPage.save();
		// driver.findElement(By.name("button")).click();
		 
		 /* verify Oppurtunities List Page  */
		 
		// String expoppPage2 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage2 = driver.getTitle();
			 
		   Assert.assertEquals(expoppPage1, actoppPage2, output12); 
			System.out.println(output11);
		 
		 /* validation */
		 
			/*create filter */
			
			 oppurtunitiesPage.navigateToCreateFilter();
			 
			 NewCustomView newCustomViewPage = PageFactory.initElements(driver, NewCustomView.class);
			 newCustomViewPage.newCustomView(filter,filter1,filter2,filter3,filter4);
			 
		/*	driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
			wLib.waitForPageLoad(driver);
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
			wLib.waitForPageLoad(driver);  */
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
			{   
			    //  String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[6]")).getText();
			    //  System.out.println(value1);
				String oppName4= oppName[i];
				WebElement wb= oppurtunitiesPage.getOppTableLeadSorceWebsite(oppName4);
				String value1 = wb.getText();
			     			      
			      Assert.assertEquals(value, value1, output4+oppName[i]+output5); //if fails then print this
					System.out.println(output1+oppName[i]+output2+value1+output3);// if pass then print this
			
			  }
			wLib.waitForPageLoad(driver);
	
		
	}

	@Test(groups= {"regressionTest"})
	public  void Edit_OppurtunitiesWith_MassEditButton_NextStepTest() throws Throwable 
	{
	
		
		
		/* Test Data */
	
		String value = fLib.getExcelData("Sheet1", 1, 3);
		String expoppPage1 = fLib.getExcelData("Sheet1", 4, 11);
		
		Random num = new Random();
		
		String data1=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String data2=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter =fLib.getExcelData("Sheet1", 1, 14)+num.nextInt(200);
		String organization =fLib.getExcelData("Sheet1", 1, 9)+num.nextInt(200);
		
		String output1= fLib.getExcelData("Sheet1", 7, 0);
		String output2= fLib.getExcelData("Sheet1", 7, 1);
		String output3= fLib.getExcelData("Sheet1", 7, 2);
		String output4= fLib.getExcelData("Sheet1", 7, 3);
		String output5= fLib.getExcelData("Sheet1", 7, 4);
		String output9= fLib.getExcelData("Sheet1", 4, 9);
		String output10= fLib.getExcelData("Sheet1", 4, 10);
		String output11= fLib.getExcelData("Sheet1", 4, 12);
		String output12= fLib.getExcelData("Sheet1", 4, 13);
		
		String filter1 =fLib.getExcelData("Sheet1", 0, 0);
		String filter2 =fLib.getExcelData("Sheet1", 0, 2);
		String filter3 =fLib.getExcelData("Sheet1", 0, 3);
		String filter4 =fLib.getExcelData("Sheet1", 0, 4);
		
		
		/*1.navigate to application  */
	
		
		/* verify login page  */
		String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
		
		 Assert.assertTrue(actlogPage.contains(explogPage), output10 );
		 System.out.println(output9);
			 
		
		/*2.login to application */
	
		 
		 	/*3.Create organization */
			
			/* navigate to "organization" List Page by Clicking on "organization" tab*/
		 	
		 Home homePage =PageFactory.initElements(driver, Home.class);
		 homePage.navigateToOrganization();
		
			
			/*create */
		 
		 Organizations organizationPage = PageFactory.initElements(driver, Organizations.class);
		 organizationPage.navigateToCreateOrganization();
		 
		 CreatingNewOrganization creatingNewOrganizationPage = PageFactory.initElements(driver, CreatingNewOrganization.class);
		 creatingNewOrganizationPage.createNewOrganization(organization);
		 
					
			/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
			
			 organizationPage.navigateToOpportunities();
			 
			 String actoppPage1 = driver.getTitle();
		
 		Assert.assertEquals(expoppPage1, actoppPage1, output12); 
			System.out.println(output11);
			
		/* create multiple oppurtunities */
		 for(int i=0;i<oppName.length;i++)
			{
			    Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
			    oppurtunitiesPage.navigateToCreateOpportunity();
			    
			    String oppName1= oppName[i];
			    CreatingNewOpportunity creatingNewOppurtinityPage =PageFactory.initElements(driver, CreatingNewOpportunity.class);
			    creatingNewOppurtinityPage.createNewOpportunity(oppName1);
				
				
			    OrganizationsWindow organizationWindow = PageFactory.initElements(driver, OrganizationsWindow.class);
			    organizationWindow.getOrgNameLink(organization);
			    
			    organizationWindow.orgWindow();
			  
			
			    creatingNewOppurtinityPage.save();
			 
			    
			    organizationPage.navigateToOpportunities();
			}
		 
		 
		/*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		 
	
		
		Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
		List<WebElement> lst = oppurtunitiesPage.getLst();
	    
		 for(int i=0;i<lst.size();i++)
		 {
			
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
					String oppName1 = oppName[j];
					oppurtunitiesPage.getOppTable(oppName1);
					oppurtunitiesPage.selectRows(oppName);
							 	
			 	}
			}
		 } 
		
		    
	    oppurtunitiesPage.navigateToMassEditPage();
		
		/*5.enter the value in "NextStep" edit box */
	    MassEditRecordsField massEditRecordFieldPage = PageFactory.initElements(driver, MassEditRecordsField.class);
		  massEditRecordFieldPage.nextStep(value);
		  
		//driver.findElement(By.id("nextstep")).sendKeys(value);
		
		 /*6.click on save */
		  massEditRecordFieldPage.save();
		// driver.findElement(By.name("button")).click();
		 
		 /* verify Oppurtunities List Page  */
		 
		// String expoppPage2 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage2 = driver.getTitle();
		
		 Assert.assertEquals(expoppPage1, actoppPage2, output12); 
		 System.out.println(output11);
		 
		 /* validation */
		 
			/*create filter */
		 
		 oppurtunitiesPage.navigateToCreateFilter();
		 
		 NewCustomView newCustomViewPage = PageFactory.initElements(driver, NewCustomView.class);
		 newCustomViewPage.newCustomView(filter,filter1,filter2,filter3,filter4);
		 
		 
		/*	driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
			wLib.waitForPageLoad(driver);
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
			wLib.waitForPageLoad(driver);  */
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
			{   
			    //  String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[7]")).getText();
			  
				String oppName5= oppName[i];
				WebElement wb= oppurtunitiesPage.getOppTableNextStep(oppName5);
				String value1 = wb.getText();
				
			      Assert.assertEquals(value, value1, output4+oppName[i]+output5); //if fails then print this
					System.out.println(output1+oppName[i]+output2+value1+output3);// if pass then print this
			  }
			wLib.waitForPageLoad(driver);
			
		
	}
	@Test(groups= {"regressionTest"})
	public  void Edit_OppurtunitiesWith_MassEditButton_Type_NewBuisinessTest () throws Throwable
	{
		/* Test Data */
	
		String value = fLib.getExcelData("Sheet1", 1, 4);
		String expoppPage1 = fLib.getExcelData("Sheet1", 4, 11);
		
		
		String output1= fLib.getExcelData("Sheet1", 8, 0);
		String output2= fLib.getExcelData("Sheet1", 8, 1);
		String output3= fLib.getExcelData("Sheet1", 8, 2);
		String output4= fLib.getExcelData("Sheet1", 8, 3);
		String output5= fLib.getExcelData("Sheet1", 8, 4);
		String output9= fLib.getExcelData("Sheet1", 4, 9);
		String output10= fLib.getExcelData("Sheet1", 4, 10);
		String output11= fLib.getExcelData("Sheet1", 4, 12);
		String output12= fLib.getExcelData("Sheet1", 4, 13);
		
		String filter1 =fLib.getExcelData("Sheet1", 0, 0);
		String filter2 =fLib.getExcelData("Sheet1", 0, 2);
		String filter3 =fLib.getExcelData("Sheet1", 0, 3);
		String filter4 =fLib.getExcelData("Sheet1", 0, 4);
		
		
		Random num = new Random();
		
		String data1=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String data2=fLib.getExcelData("Sheet1", 1, 13)+num.nextInt(200);
		String[] oppName = {data1,data2};
		String filter =fLib.getExcelData("Sheet1", 1, 14)+num.nextInt(200);
		String organization =fLib.getExcelData("Sheet1", 1, 9)+num.nextInt(200);
		
		
		
		/*1.navigate to application  */

		
		/* verify login page  */
		 String explogPage =fLib.getExcelData("Sheet1", 4, 8);
		 String actlogPage = driver.getTitle();
		 System.out.println(actlogPage);
	
		 
		 Assert.assertTrue(actlogPage.contains(explogPage), output10 );
		 System.out.println(output9);
			 
		
		/*2.login to application */
	
		
		 
		 	/*3.Create organization */
			
			/* navigate to "organization" List Page by Clicking on "organization" tab*/
		 	
		 Home homePage =PageFactory.initElements(driver, Home.class);
		 homePage.navigateToOrganization();
		
			
			/*create */
		 
		 Organizations organizationPage = PageFactory.initElements(driver, Organizations.class);
		 organizationPage.navigateToCreateOrganization();
		 
		 CreatingNewOrganization creatingNewOrganizationPage = PageFactory.initElements(driver, CreatingNewOrganization.class);
		 creatingNewOrganizationPage.createNewOrganization(organization);
		 
					
			/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
			
			 organizationPage.navigateToOpportunities();
			 
			 String actoppPage1 = driver.getTitle();
		
 		Assert.assertEquals(expoppPage1, actoppPage1, output12); 
			System.out.println(output11);
			
		/* create multiple oppurtunities */
		 for(int i=0;i<oppName.length;i++)
			{
			    Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
			    oppurtunitiesPage.navigateToCreateOpportunity();
			    
			    String oppName1= oppName[i];
			    CreatingNewOpportunity creatingNewOppurtinityPage =PageFactory.initElements(driver, CreatingNewOpportunity.class);
			    creatingNewOppurtinityPage.createNewOpportunity(oppName1);
				
				
			    OrganizationsWindow organizationWindow = PageFactory.initElements(driver, OrganizationsWindow.class);
			    organizationWindow.getOrgNameLink(organization);
			    
			    organizationWindow.orgWindow();
			  
			
			    creatingNewOppurtinityPage.save();
			 
			    
			    organizationPage.navigateToOpportunities();
			}
		 
		 
		/*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		 
	
		
		Oppurtunities oppurtunitiesPage = PageFactory.initElements(driver, Oppurtunities.class);
		List<WebElement> lst = oppurtunitiesPage.getLst();
	    
		 for(int i=0;i<lst.size();i++)
		 {
			
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
					String oppName1 = oppName[j];
					oppurtunitiesPage.getOppTable(oppName1);
					oppurtunitiesPage.selectRows(oppName);
							 	
			 	}
			}
		 } 
		
		    
	    oppurtunitiesPage.navigateToMassEditPage();
		

		/*5.select the "NewBuisiness" by clicking on the "Type" drop down menu */
	    
	    MassEditRecordsField massEditRecordFileldPage = PageFactory.initElements(driver, MassEditRecordsField.class);
	    massEditRecordFileldPage.selectTypeNewBuisiness(value);
		/*WebElement wb = driver.findElement(By.name("opportunity_type"));
		Select sel = new Select(wb);
		sel.selectByVisibleText(value);*/
		
		/*6.click on save */
	    massEditRecordFileldPage.save();
		// driver.findElement(By.name("button")).click();
		 
		 /* verify Oppurtunities List Page  */
		 
		// String expoppPage2 = "Administrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM";
		 String actoppPage2 = driver.getTitle();
		
		 Assert.assertEquals(expoppPage1, actoppPage2, output12); 
		 System.out.println(output11);
		 wLib.waitForPageLoad(driver);
		 
		 /* validation */
		 
			/*create filter */

		 oppurtunitiesPage.navigateToCreateFilter();
		 
		 NewCustomView newCustomViewPage = PageFactory.initElements(driver, NewCustomView.class);
		 newCustomViewPage.newCustomView(filter,filter1,filter2,filter3,filter4);
		 
           /*driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
			wLib.waitForPageLoad(driver);
			driver.findElement(By.name("viewName")).sendKeys(filter);
			WebElement wb4 = driver.findElement(By.name("column6"));
			Select sel4 = new Select(wb4);
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
			wLib.waitForPageLoad(driver);  */
			
			/* Checking the value has been changed or not */
		
			for(int i =0;i<oppName.length;i++)
			{   
			    //  String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName[i]+"']/../following-sibling::td[8]")).getText();
			  
				String oppName6= oppName[i];
				WebElement wb1= oppurtunitiesPage.getOppTableTypeNewBuisiness(oppName6);
				String value1 = wb1.getText();
			      Assert.assertEquals(value, value1, output4+oppName[i]+output5); //if fails then print this
					System.out.println(output1+oppName[i]+output2+value1+output3);// if pass then print this
			
			  }
			wLib.waitForPageLoad(driver);
	

	}

	
	
	

}
