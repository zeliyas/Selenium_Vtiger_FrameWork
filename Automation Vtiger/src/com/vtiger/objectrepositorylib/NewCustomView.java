package com.vtiger.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.genericlib.BaseClass;

public class NewCustomView extends BaseClass
{
	
	@FindBy(name="viewName")
	private WebElement viewNameEdt;
	
	@FindBy(name="column6")
	private WebElement column6drpdwn;
	
	@FindBy(name="column7")
	private WebElement column7drpdwn;
	
	@FindBy(name="column8")
	private WebElement column8drpdwn;
	
	@FindBy(name="column9")
	private WebElement column9drpdwn;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement savebtn;
	
	public void newCustomView(String filter, String filter1, String filter2, String filter3, String filter4)
	{
		viewNameEdt.sendKeys(filter);
		Select sel = new Select(column6drpdwn);
		sel.selectByVisibleText(filter1);
		Select sel1 = new Select(column7drpdwn);
		sel1.selectByVisibleText(filter2);
		Select sel2 = new Select(column8drpdwn);
		sel2.selectByVisibleText(filter3);
		Select sel3 = new Select(column9drpdwn);
		sel3.selectByVisibleText(filter4);
		savebtn.click();
		wLib.waitForPageLoad(driver);
	}
	
	/*
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
			wLib.waitForPageLoad(driver);
	 
	 */

}
