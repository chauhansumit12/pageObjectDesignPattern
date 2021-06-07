package com.utility.base;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.utility.logger.Log;

public class WrapperFunctions extends TestBase {



	public static void waitForElementVisibility(WebElement element, int time, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		
		} catch (ElementNotVisibleException e) {
		
		}

		catch (Exception e) {
			// Log.info("Element is not visible");
		}
	}

	public static void waitForTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static boolean isElementPresent(WebElement ele, String name) {
		WrapperFunctions.waitForTime(5000);
		if (ele.isDisplayed()) {
			//Log.info(name + " is displayed");
			return true;
		} else {
			//Log.info(name + " is Not displayed");
			return false;
		}

	}
	
	// Clear Existing Text & Send Value in Text Area
		public static void clearAndSend(WebElement element, Object value) {
			element.clear();
			element.sendKeys(value.toString());
		}
		
		public static void closeBrowser(WebDriver driver) {
			driver.close();
			//Log.info("Browser Closed");
		}

		public static void driverQuit(WebDriver driver) {
			driver.quit();
			//Log.info("Browser Thread Closed");

		}


}
