package oppurtunites;
/**
 * 
 * @author zeliya
 * 
 */

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.genericlib.WebdriverUtils;
public class SampleTestVtiger {

	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();
		/* Testdata */
		String url = "http://localhost:8888/";
		String username = "admin";
		String password = "zeli1234";
		String uname = "Zeliya"+r.nextInt(1000);
		String upwd = "zeli@123";
		String email = "zeli@gmail.com";
		String lname = "Jithesh"+r.nextInt(1000);
		String orgname = "Kochar"+r.nextInt(1000);
		String pname = "GamlinPen"+r.nextInt(1000);
		String clastname = "Panda"+r.nextInt(1000);
		String sub = "Quotation For Gamlin Pen";
		String billaddress = "Bangalore";
		String qty = "50";
		
		WebdriverUtils WLib = new WebdriverUtils();
		WebDriver driver = new FirefoxDriver();
		WLib.waitForPageLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to CRM Settings page
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.linkText("CRM Settings")).click();
		
		//1.Click on Users Link and create a new User
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.xpath("//input[@class='crmButton create small']")).click();
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(upwd);
		driver.findElement(By.name("confirm_password")).sendKeys(upwd);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.name("last_name")).sendKeys(lname);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//Get all window Session ID
		Set<String> set = driver.getWindowHandles();
		//Capture the Session ID
		Iterator<String> it = set.iterator();
		String parentID = it.next();
		String childID = it.next();
		//Pass driver control to child window
		driver.switchTo().window(childID);
		//perform an action on child window
		driver.findElement(By.linkText("Vice President")).click();
		//Pass control back to Parent Window
		driver.switchTo().window(parentID);
		
		//Click on Save Button
		driver.findElement(By.xpath("//table[@class='settingsSelUITopLine']/tbody/tr[3]/td/input[@class='small crmbutton save']")).click();
		
		WebElement wb1 = driver.findElement(By.xpath("//a[text()='Settings']"));
		WLib.waitForCompleteElementToLoad(wb1);
		
		//2.Navigate to Organization Page
		driver.findElement(By.linkText("Organizations")).click();
		
		//Create a new Organization
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		//Select User from available options
		WebElement wb2 = driver.findElement(By.name("assigned_user_id"));
		Select sel = new Select(wb2);
		sel.selectByVisibleText(lname);
		//Click on Save Button
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
		
		//3.Click on "Products" Link and create product
		WebElement wb3 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		WLib.waitForCompleteElementToLoad(wb3);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(pname);
		//Select "Handler" from the available options
		WebElement wb4 = driver.findElement(By.name("assigned_user_id"));
		Select sel1 = new Select(wb4);
		sel1.selectByVisibleText(lname);
		//Click on Save Button
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();

		//4.Click on "Contacts" link and create the product for created organization
		WebElement wb5 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		WLib.waitForCompleteElementToLoad(wb5);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(clastname);
		driver.findElement(By.xpath("//tbody/tr[5]/td[2]/img[@src='themes/softed/images/select.gif']")).click();
		
		//Get all window Session ID
		Set<String> set1 = driver.getWindowHandles();
		//Capture the Session ID
		Iterator<String> it1 = set1.iterator();
		String parentID1 = it1.next();
		String childID1 = it1.next();
		//Pass driver control to child window
		driver.switchTo().window(childID1);
		WebElement wb6 = driver.findElement(By.xpath("//tbody/tr/td[@class='dvtCellLabel']/img"));
		WLib.waitForCompleteElementToLoad(wb6);
		//perform an action on child window
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		WebElement wb7 = driver.findElement(By.linkText(orgname));
		if(wb7.isDisplayed())
		{
			wb7.click();
		}
		//Pass control back to Parent Window
		driver.switchTo().window(parentID1);
		
		//Select user from available option in "Assigned To"
		WebElement cwb = driver.findElement(By.name("assigned_user_id"));
		Select csel = new Select(cwb);
		csel.selectByVisibleText(lname);
		
		//Click on Save Button
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmButton small save']")).click();
		
		//5.Navigate to "More" link
		WebElement swb = driver.findElement(By.xpath("//tbody/tr/td/span[@class='dvHeaderText']"));
		WLib.waitForCompleteElementToLoad(swb);
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[22]/a[text()='More']"))).perform();
		driver.findElement(By.linkText("Quotes")).click();
		
		//Create Quote for the above product,contact and organization
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("subject")).sendKeys(sub);
		WebElement qwb = driver.findElement(By.name("quotestage"));
		Select qsel = new Select(qwb);
		qsel.selectByVisibleText("Accepted");
		
		//Click on "Contacts" look up image
		driver.findElement(By.xpath("//tbody/tr[5]/td[4]/img[@src='themes/softed/images/select.gif']")).click();
		//Get all window Session ID
		Set<String> set2 = driver.getWindowHandles();
		//Capture the Session ID
		Iterator<String> it2 = set2.iterator();
		String parentID2 = it2.next();
		String childID2 = it2.next();
		//Pass driver control to child window
		driver.switchTo().window(childID2);
		WebElement cwb1 = driver.findElement(By.xpath("//tbody/tr/td[@class='dvtCellLabel']/img"));
		WLib.waitForCompleteElementToLoad(cwb1);
		//perform an action on child window
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		WebElement wb9 = driver.findElement(By.linkText(clastname));
		if(wb9.isDisplayed())
		{
			wb9.click();
		}
		//Pass driver control to alert
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		//Click on OK Button
		alt.accept();
		//Pass driver control to parent window
		driver.switchTo().window(parentID2);
		
		//Click on "Contacts" look up image
		driver.findElement(By.xpath("//tbody/tr[7]/td[4]/img")).click();
		//Get all window Session ID
		Set<String> set3 = driver.getWindowHandles();
		//Capture the Session ID
		Iterator<String> it3 = set3.iterator();
		String parentID3 = it3.next();
		String childID3 = it3.next();
		//Pass driver control to child window
		driver.switchTo().window(childID3);
		WebElement owb = driver.findElement(By.xpath("//tbody/tr/td[@class='dvtCellLabel']/img"));
		WLib.waitForCompleteElementToLoad(owb);
		//perform an action on child window
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		WebElement owb1 = driver.findElement(By.linkText(orgname));
		if(owb1.isDisplayed())
		{
			owb1.click();
		}
		//Pass driver control to alert
		Alert alt1 = driver.switchTo().alert();
		System.out.println(alt1.getText());
		//Click on OK Button
		alt.accept();
		//Pass driver control to parent window
		driver.switchTo().window(parentID3);
		
		//Enter the Billing Address
		driver.findElement(By.name("bill_street")).sendKeys(billaddress);
		//Click on Copy Mailing address radio button
		driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
		
		//Click on "Item Image" to select an item
		driver.findElement(By.id("searchIcon1")).click();
		//Get all window Session ID
		Set<String> set4 = driver.getWindowHandles();
		//Capture the Session ID
		Iterator<String> it4 = set4.iterator();
		String parentID4 = it4.next();
		String childID4 = it4.next();
		//Pass driver control to child window
		driver.switchTo().window(childID4);
		WebElement iwb = driver.findElement(By.xpath("//tbody/tr/td[@class='dvtCellLabel']/img"));
		WLib.waitForCompleteElementToLoad(iwb);
		//perform an action on child window
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		WebElement iwb1 = driver.findElement(By.linkText(pname));
		if(iwb1.isDisplayed())
		{
			iwb1.click();
		}
		//Pass driver control to parent window
		driver.switchTo().window(parentID4);
		//Enter the quantity of the item selected
		driver.findElement(By.id("qty1")).sendKeys(qty);
		
		//Click on Save Button
		driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
				
		//Validating the details in the Quotation Page
		String expResult = "Quote Information";
		String actResult = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(actResult.contains(expResult))
		{
			System.out.println("Quotation created successfully ==> PASS");
		}
		else
		{
			System.out.println("Quotation not created ==> FAIL");
		}
		
		//Validating the details
		String actTitle = driver.findElement(By.id("mouseArea_Subject")).getText();
		String expTitle = sub;
		System.out.println(actTitle);
		if(actTitle.contains(expTitle))
		{
			System.out.println("The subject is verified ==> PASS");
		}
		else
		{
			System.out.println("The subject is not verified ==> FAIL");
		}
		
		//Verifying Contact Details
		String actCon = driver.findElement(By.id("mouseArea_Contact Name")).getText();
		String expCon = clastname;
		System.out.println(actCon);
		if(actCon.contains(expCon))
		{
			System.out.println("The contact detail is verified ==> PASS");
		}
		else
		{
			System.out.println("The contact detail is not verified ==> FAIL");
		}
		
		//Verifying Organization details
		String actOrg = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		String expOrg = orgname;
		System.out.println(actOrg);
		if(actOrg.contains(expOrg))
		{
			System.out.println("The organization detail is verified ==> PASS");
		}
		else
		{
			System.out.println("The organization detail is not verified ==> FAIL");
		}
		
		//verify whether the "Shipping address" same as "Billing address"
		String billingAddress = billaddress;
		String shippingAddress = driver.findElement(By.id("mouseArea_Shipping Address")).getText();
		if(shippingAddress.contains(billingAddress))
		{
			System.out.println("Shipping Address is same as Mailing Address==>Pass");
		}
		else
		{
			System.out.println("Shipping Address is not same as Mailing Address==>Fail");
		}
				
		//Verifying the item Name
		String expItem = pname;
		String actItem = driver.findElement(By.xpath("//tbody/tr[3]/td[1][@class='crmTableRow small lineOnTop']")).getText();
		System.out.println(actItem);
		if(actItem.contains(expItem))
		{
			System.out.println("The product detail is verified ==> PASS");
		}
		else
		{
			System.out.println("The product detail is not verified ==> FAIL");
		}
		
		//Logout from the application
		WebElement wbl = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actl = new Actions(driver);
		actl.moveToElement(wbl).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Close the browser
		driver.close();
	}
	

}
