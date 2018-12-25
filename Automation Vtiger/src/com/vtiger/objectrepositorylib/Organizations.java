package com.vtiger.objectrepositorylib;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;

public class Organizations extends BaseClass
{
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgImage;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	private WebElement opportunitiesLink;
	
	
	
	
    public void navigateToCreateOrganization() throws InterruptedException
    {
    	createOrgImage.click();
    	wLib.waitForPageLoad(driver);
    	
    }
    
    public void navigateToOpportunities() throws InterruptedException
	{
		
		
		opportunitiesLink.click();
		wLib.waitForPageLoad(driver);
	}
	

}
