package com.vtiger.objectrepositorylib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;;

public class Home extends BaseClass
{
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutLink;
	
	public void navigateToOrganization()
	{
		organizationLink.click();
		wLib.waitForPageLoad(driver);  
	}
	
	
	
	
	
	
	
	public void logoutFromApp()
	{
		Actions act = new Actions(driver);
		act.moveToElement(logoutImg).perform();
		logoutLink.click();
	}
	
	
/*  driver.findElement(By.linkText("Organizations")).click(); 
 * driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
 * 
 * WebElement wb7 = driver.findElement(By.className("dvHeaderText"));
	
	
	
	
	
	
	
	
	
	*/
	
}
