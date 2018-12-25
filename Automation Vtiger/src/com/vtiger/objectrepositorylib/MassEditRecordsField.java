package com.vtiger.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MassEditRecordsField 
{
	@FindBy(name="amount")
	private WebElement amountEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement AssignToradiobtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement groupdrpdwn;
	
	@FindBy(id="assigned_user_id_mass_edit_check")
	private WebElement AssignTocheckbx;
	
	@FindBy(name="leadsource")
	private WebElement leadsorcedrpdwn;
	
	@FindBy(id="nextstep")
	private WebElement nextStepEdt;
	
	@FindBy(name="opportunity_type")
	private WebElement Typedrpdwn;
	
	
	public void massEditRecord(String amount)
	{
		amountEdt.sendKeys(amount);
	}
	public void save()
	{
		savebtn.click();
		
	}
	public void selectSupportGroup(String value)
	{
		AssignToradiobtn.click();
		Select sel = new Select(groupdrpdwn);
		sel.selectByVisibleText(value);
		AssignTocheckbx.click();
	}
	
	public void selectLeadSourceWebsite(String value)
	{
		Select sel = new Select(leadsorcedrpdwn);
		 sel.selectByVisibleText(value);
	}
	
	public void nextStep(String value)
	{
		nextStepEdt.sendKeys(value);
		
	}
	
	public void selectTypeNewBuisiness(String value)
	{
		
		Select sel = new Select(Typedrpdwn);
		sel.selectByVisibleText(value);
	}
	
	/*driver.findElement(By.name("amount")).sendKeys(amount); 
	 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();  
	 * 
	 * driver.findElement(By.xpath("//input[@value='T']")).click();
		 WebElement wbd =  driver.findElement(By.name("assigned_group_id"));
		 Select sel = new Select(wbd);
		 sel.selectByVisibleText(value);
		 driver.findElement(By.id("assigned_user_id_mass_edit_check")).click();
		 
		 WebElement wbd =  driver.findElement(By.name("leadsource"));
		 Select sel = new Select(wbd);
		 sel.selectByVisibleText(value);
		 
		 driver.findElement(By.id("nextstep")).sendKeys(value);
		 
		 WebElement wb = driver.findElement(By.name("opportunity_type"));
		Select sel = new Select(wb);
		sel.selectByVisibleText(value);
		 */

}
