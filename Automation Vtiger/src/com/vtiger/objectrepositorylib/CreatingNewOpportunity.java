package com.vtiger.objectrepositorylib;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;

public class CreatingNewOpportunity extends BaseClass
{

	String parentId;
	@FindBy(name="potentialname")
	private WebElement oppurtunityNameEdt;
	
	@FindBy(xpath="//input[@name='related_to_display']/../img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookUpImg;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement opportunityLnk;
	
	public void createNewOpportunity(String oppName1)
	{
		oppurtunityNameEdt.sendKeys(oppName1);
		orgLookUpImg.click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		 parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
	}
	public void save()
	{
		driver.switchTo().window(parentId);
		wLib.waitForPageLoad(driver);
		savebtn.click();
		wLib.waitForPageLoad(driver);
		opportunityLnk.click();
		wLib.waitForPageLoad(driver);
	}
	
	/*
	 * driver.findElement(By.name("potentialname")).sendKeys(oppName[i]);
				driver.findElement(By.xpath("//input[@name='related_to_display']/../img[@src='themes/softed/images/select.gif']")).click();
				
				driver.findElement(By.name("button")).click();
				wLib.waitForPageLoad(driver);
				driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
				wLib.waitForPageLoad(driver);
				
				*
				*/
}
