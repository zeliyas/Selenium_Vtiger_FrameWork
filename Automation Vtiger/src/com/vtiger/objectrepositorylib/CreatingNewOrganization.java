package com.vtiger.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlib.BaseClass;


public class CreatingNewOrganization extends BaseClass
{
 
	@FindBy(name= "accountname")
	private WebElement organizationName;
	
    @FindBy(xpath="//tbody/tr[1]/td/div/input[@class='crmbutton small save']")
	private WebElement saveBtn;
    
    @FindBy(className="dvHeaderText")
	private WebElement orgCreatedMsg;
    
    public void createNewOrganization(String organization) throws InterruptedException
    {
    	
		organizationName.sendKeys(organization);
		saveBtn.click();
		wLib.waitForPageLoad(driver); 
		wLib.waitForCompleteElementToLoad(orgCreatedMsg);
    }
    
    /*
	 * 
	 * 
			driver.findElement(By.name("accountname")).sendKeys(organization);
			driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@class='crmbutton small save']")).click();
			wLib.waitForPageLoad(driver); 

*/
}
