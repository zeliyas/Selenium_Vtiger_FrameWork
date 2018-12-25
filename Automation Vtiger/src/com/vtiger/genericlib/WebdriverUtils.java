package com.vtiger.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebdriverUtils
{

	
		/**
		 * wait for page to load
		 */
		public void waitForPageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		/**
		 * wait for any element is available in GUI
		 */
		
			public void waitForElementPresent(WebDriver driver, WebElement wb)
			{

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(wb));
				

			}
			
			/**
			 * wait for element to load completely and available in GUI
			 */
			
				public void waitForCompleteElementToLoad(WebElement wb)throws InterruptedException
				{
					int count = 0;
					while(count<20)
					{
						try
						{
							wb.isDisplayed();
							break;
						}
						catch(Throwable t)
						{
							System.out.println("handle the Exception and continue");
							Thread.sleep(1000);
							count++;
						}
					}
				}
				
			
}
