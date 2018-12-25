package quotes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFilter {

	public static void main(String[] args)
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
		
		/*create filter */
		driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("viewName")).sendKeys("new4");
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
		/*Select filter */
		WebElement wb4 = driver.findElement(By.name("viewname"));
		Select sel4 = new Select(wb4);
		sel4.selectByVisibleText("new4");
		////table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='opp8']/../following-sibling::td[5]
		List<WebElement> lst3 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a"));
		for(int i =0;i<arr.length;i++)
		{   String y = lst3.get(i).getText();
		     if(arr[i].equals(y))
		     {
		      String value1 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+arr[i]+"']/../following-sibling::td[5]")).getText();
		      
		
		     }
		 }
	}

}
