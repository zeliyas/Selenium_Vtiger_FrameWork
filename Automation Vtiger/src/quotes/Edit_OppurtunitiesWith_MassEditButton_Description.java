package quotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author zeliya
 *test case name:Edit_OppurtunitiesWith_MassEditButton_Description
 *test case id:tc_16_15
 */
public class Edit_OppurtunitiesWith_MassEditButton_Description {

	public static void main(String[] args) throws InterruptedException {
		/*1.navigate to application  */
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		
		/*2.login to application */
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("zeli1234");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(4000);
		
		/*3. navigate to "OPPURTUNITIES" List Page by Clicking on "OPPURTUNITIES" tab */
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		/*4.select the particular rows of oppurtunites you want to edit by clicking on the
		  corresponding checkboxes and then click on "Mass Edit"  button */
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[1]")).click();
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		
		Thread.sleep(3000);
		/*5. enter the details on the "Description" edit box present in "Description information" tab */
		driver.findElement(By.xpath("//b[text()='Description Information:']")).click();
		driver.findElement(By.name("description")).sendKeys("The customer is genuine willing to buy");
        
		/*6.click on save */
		 driver.findElement(By.name("button")).click();
		
		/*7. Log Out the application*/
		 WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(img).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			Thread.sleep(3000);
	}

}
