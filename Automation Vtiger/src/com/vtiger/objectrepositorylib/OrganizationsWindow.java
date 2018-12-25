package com.vtiger.objectrepositorylib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;


public class OrganizationsWindow extends BaseClass
{
	
	private WebElement orgNameLink;
	public WebElement getOrgNameLink(String organization)
	{
		
		orgNameLink = driver.findElement(By.xpath("//a[text()='"+organization+"']"));
		return orgNameLink;
	}
	
	public void orgWindow()
	{
		
		orgNameLink.click();
		
		
	}
	
    
	/*Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	String parentId = it.next();
	String childId = it.next();
	driver.switchTo().window(childId);
	driver.findElement(By.xpath("//a[text()='"+organization+"']")).click();
	driver.switchTo().window(parentId);
	wLib.waitForPageLoad(driver);  */


}
