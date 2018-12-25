package com.vtiger.objectrepositorylib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;

public class Logout extends BaseClass
{
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutLink;
	
	public void logoutFromApp()
	{
		Actions act = new Actions(driver);
		act.moveToElement(logoutImg).perform();
		logoutLink.click();
	}
	
	
/* WebElement img   =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		wLib.waitForPageLoad(driver); */
}
