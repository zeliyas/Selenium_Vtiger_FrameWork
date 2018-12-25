package com.vtiger.objectrepositorylib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.vtiger.genericlib.BaseClass;

public class Oppurtunities extends BaseClass
{
	

	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOppurtunityImg;
	
	
	@FindBys({@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]/a")})
	private List<WebElement> lst;
	
	
	
	public List<WebElement> getLst()
	{
		return lst;
	}

	private WebElement oppTable;
	private WebElement oppTable1;
	private WebElement oppTable2;
	private WebElement oppTable3;
	private WebElement oppTable4;
	private WebElement oppTable5;
	
	@FindBy(xpath="//input[@value='Mass Edit']")
	private WebElement massEditbtn;
	
	@FindBy(xpath="//a[text()='Create Filter']")
	private WebElement createFilterlnk;
	
	public WebElement getOppTable(String oppName1)
	{
		
		oppTable=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName1+"']/../preceding-sibling::td[2]"));
		return oppTable;
	}
	public WebElement getOppTableAmount(String oppName2)
	{
		
		oppTable1=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName2+"']/../following-sibling::td[5]"));
		return oppTable1;
	}

	public WebElement getOppTableSupportGroup(String oppName3)
	{
		
		oppTable2=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName3+"']/../following-sibling::td[3]"));
		return oppTable2;
	}
	
	public WebElement getOppTableLeadSorceWebsite(String oppName4)
	{
		
		oppTable3=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName4+"']/../following-sibling::td[6]"));
		return oppTable3;
	}
	
	public WebElement getOppTableNextStep(String oppName5) {
		
		oppTable4 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName5+"']/../following-sibling::td[7]"));
		return oppTable4;
	}
	public WebElement getOppTableTypeNewBuisiness(String oppName6) {
		oppTable5 = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]/a[text()='"+oppName6+"']/../following-sibling::td[8]"));
		return oppTable5;
	}
	public void navigateToCreateOpportunity()
	{
		createOppurtunityImg.click();
		wLib.waitForPageLoad(driver);
	}
	
	public void selectRows(String[] oppName)
	{
		
				
			 	 oppTable.click();
			 	wLib.waitForPageLoad(driver);
			 	
	}
	
	public void navigateToMassEditPage()
	{
		massEditbtn.click();
		wLib.waitForPageLoad(driver);
	}
	
	public void navigateToCreateFilter()
	{
		createFilterlnk.click();
		wLib.waitForPageLoad(driver);
	}
	
	
	
	
	
	/*
	 * driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			    wLib.waitForPageLoad(driver);
			    
		List<WebElement> lst=  driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		wLib.waitForPageLoad(driver);	 
		
		   
		   for(int i=0;i<lst.size();i++)
		 {
			//System.out.println(data.getText()); 
			String d1 = lst.get(i).getText();
			System.out.println(d1);
			for(int j=0;j<oppName.length;j++)
			{
				if(d1.equals(oppName[j]))
			 	{
				 String x=	"//table[@class='lvt small']/tbody/tr[*]/td[3]/a[text()='"+oppName[j]+"']/../preceding-sibling::td[2]";
			 	 driver.findElement(By.xpath(x)).click();
			 	wLib.waitForPageLoad(driver);
			 	
			 	}
			}
		 }
		
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click(); 
		wLib.waitForPageLoad(driver);
		
		driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
	wLib.waitForPageLoad(driver);
	*/
	
	

}
