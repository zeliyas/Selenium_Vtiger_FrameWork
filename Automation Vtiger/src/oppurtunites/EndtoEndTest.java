package oppurtunites;

import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.vtiger.genericlib.WebdriverUtils;
import com.vtiger.genericlib.BaseClass;
import com.vtiger.genericlib.FileUtils;

/**
 * 
 * @author zeliya
 *
 */

public class EndtoEndTest extends BaseClass{

	@Test
	public void EndtoEnd1Test() throws Throwable
	{
	/*	FileUtils fLib = new FileUtils();
		Properties pObj = fLib.getPropertyFileObject();
		String URL = pObj.getProperty("URL");
		String USERNAME = pObj.getProperty("USERNAME");
		String PASSWORD = pObj.getProperty("PASSWORD"); */
		String billAddress = fLib.getExcelData("Sheet1", 1, 5);
		String shipAddress =fLib.getExcelData("Sheet1", 1, 6);
		String Quantity = fLib.getExcelData("Sheet1", 1, 7);
		String unitPrice =fLib.getExcelData("Sheet1", 1, 8);
		
		
		Random num = new Random();
		String organization =fLib.getExcelData("Sheet1", 1, 9)+num.nextInt(200);
		String product = fLib.getExcelData("Sheet1", 1, 10)+num.nextInt(200);
		String quoteName = fLib.getExcelData("Sheet1", 1, 11)+num.nextInt(200);
		String contact = fLib.getExcelData("Sheet1", 1, 12)+num.nextInt(200);
		
		String output1= fLib.getExcelData("Sheet1", 9, 0);
		String output2= fLib.getExcelData("Sheet1", 9, 1);
		String output3= fLib.getExcelData("Sheet1", 9, 2);
		String output4= fLib.getExcelData("Sheet1", 9, 3);
		String output5= fLib.getExcelData("Sheet1", 9, 4);
		String output6= fLib.getExcelData("Sheet1", 9, 5);
		String output7= fLib.getExcelData("Sheet1", 9, 6);
		String output8= fLib.getExcelData("Sheet1", 9, 7);
		
		/*1.navigate to application  */
	/*	WebdriverUtils wLib = new WebdriverUtils();
		WebDriver driver = new FirefoxDriver();
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);  */
		
		/*2.login to application */
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		wLib.waitForPageLoad(driver);  */
		
		/*3.Create organization */
		
		/* navigate to "organization" List Page by Clicking on "organization" tab*/
		driver.findElement(By.linkText("Organizations")).click();
		wLib.waitForPageLoad(driver);
		
		/*create */
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		wLib.waitForPageLoad(driver);
		driver.findElement(By.name("accountname")).sendKeys(organization);
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
		
		/*4.Create contacts for above organization*/
		
		/* navigate to contacts List page by clicking on "contacts" tab*/
		
	    WebElement wb7 = driver.findElement(By.className("dvHeaderText"));
	    wLib.waitForCompleteElementToLoad(wb7);
	//	Thread.sleep(3000);	
		WebElement wb = driver.findElement(By.linkText("Contacts"));
		wb.click();
//		wLib.waitForCompleteElementToLoad(driver.findElement(By.xpath("//tbody/tr[1]/td[8]/a[text()='Contacts']")));
	//	wLib.waitForCompleteElementToLoad(wb);
		
	//	Actions act3= new Actions(driver);
	//	act3.moveToElement(wb).click().perform();
		
	//	wLib.waitForPageLoad(driver);
		
		/* create*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(3000);
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		//driver.findElement(By.linkText(organization)).click();
		wLib.waitForPageLoad(driver);
		driver.findElement(By.xpath("//a[text()='"+organization+"']")).click();
	
		driver.switchTo().window(parentId);		
		
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmButton small save']")).click();  
		wLib.waitForPageLoad(driver);
		
		/*5.Create products*/
		WebElement wb1 = driver.findElement(By.linkText("Products"));
		wLib.waitForCompleteElementToLoad(wb1);
		wb1.click();
		wLib.waitForPageLoad(driver);
		
		/*create */
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		wLib.waitForPageLoad(driver);
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.name("unit_price")).sendKeys(unitPrice);
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
		wLib.waitForPageLoad(driver);
		
		/*6. Create Quotes for above product, contact and organization*/
		WebElement wb8 =driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		wLib.waitForCompleteElementToLoad(wb8);
		WebElement wb2   =  driver.findElement(By.xpath("//a[text()='More']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(wb2).perform();
		driver.findElement(By.xpath("//a[text()='Quotes']")).click();
		wLib.waitForPageLoad(driver);
		
		/*create*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		wLib.waitForPageLoad(driver);
		driver.findElement(By.name("subject")).sendKeys(quoteName);
		wLib.waitForPageLoad(driver);
		
		
		
		/*add organization*/
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		String parentId1 = it1.next();
		String childId1 = it1.next();
		driver.switchTo().window(childId1);
		
		WebElement wb3= driver.findElement(By.linkText(organization));
		wb3.click();
	
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driver.switchTo().window(parentId1);
		
		
		/*adding contacts*/
		driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> set3 = driver.getWindowHandles();
		Iterator<String> it3 = set3.iterator();
		String parentId3 = it3.next();
		String childId3 = it3.next();
		driver.switchTo().window(childId3);
		
	    WebElement wb5= driver.findElement(By.linkText(contact));
	    wb5.click();
	    
	    Alert alt1 = driver.switchTo().alert();
		System.out.println(alt1.getText());
		alt1.accept();
		
    	driver.switchTo().window(parentId3);
    	
    	driver.findElement(By.name("bill_street")).sendKeys(billAddress);
		wLib.waitForPageLoad(driver);
		
		driver.findElement(By.name("ship_street")).sendKeys(shipAddress);
		wLib.waitForPageLoad(driver);
		
		/*For page down*/
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("window.scrollBy(0,200)");
		
		/*For adding product*/
		
		driver.findElement(By.xpath("//input[@name='productName1']/following-sibling::img[@title='Products']")).click();
		
		Set<String> set2 = driver.getWindowHandles();
		Iterator<String> it2 = set2.iterator();
		String parentId2 = it2.next();
		String childId2 = it2.next();
		driver.switchTo().window(childId2);
	
	    WebElement wb6= driver.findElement(By.linkText(product));
	    wLib.waitForCompleteElementToLoad(wb6);
	    wb6.click();
	   
	    driver.switchTo().window(parentId2);
	
		wLib.waitForPageLoad(driver);
		
		/*For adding quantity*/
		driver.findElement(By.name("qty1")).sendKeys(Quantity);
		wLib.waitForPageLoad(driver);
		
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
		wLib.waitForPageLoad(driver);
		
		
		/*7. validation*/
    	String data1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(data1.contains(organization))
		{
			System.out.println(output1);
		}
		else
		{
			System.out.println(output2);
		}
		 String data2 = driver.findElement(By.xpath("//tbody/tr[3]/td[1][@class='crmTableRow small lineOnTop']")).getText();
		 if(data2.contains(product))
		 {
			 System.out.println(output3);
		 }
		 else
		 {
			 System.out.println(output4);
		 }
		String data3= driver.findElement(By.id("mouseArea_Contact Name")).getText();
		if(data3.contains(contact))
		{
			 System.out.println(output5);
		 }
		 else
		 {
			 System.out.println(output6);
			 
		 }
		String data4 = driver.findElement(By.id("mouseArea_Subject")).getText();
		if(data4.contains(quoteName))
		{
			 System.out.println(output7);
		 }
		 else
		 {
			 System.out.println(output8);
			 
		 }
		
		/*8. Log Out the application*/
    /*	WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(img).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		wLib.waitForPageLoad(driver);
		driver.close();    */
	
		
		
		

		
	}

}
