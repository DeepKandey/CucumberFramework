package com.appname.qa.util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appname.qa.base.Base;

public class WebInteractUtil extends Base {

	/**********************************************************************************************
	 * Waits for mobile element and set text in it
	 * 
	 * @param mobileElement
	 *            {@link MobileElement} - MobileElement to set text
	 * @param text
	 *            {@link String} - Text to set
	 * @return status {@link boolean} - true/false
	 * @version 1.0 December 10, 2018
	 ***********************************************************************************************/
	public static boolean sendKeys(WebElement mobileElement, String text) {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
			mobileElement.clear();
			mobileElement.sendKeys(text);
			status = true;
		} catch (Exception e) {
			LoggerUtil.logMessage("Unable to set text in mobileElement: " + mobileElement.toString());
		}
		return status;
	}

	/**********************************************************************************************
	 * Waits for mobile element and clicks on it
	 * 
	 * @param mobileElement
	 *            {@link MobileElement} - MobileElement to click on
	 * @return status {@link boolean} - true/false
	 ***********************************************************************************************/
	public static boolean click(WebElement mobileElement) {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).click();
			status = true;
		} catch (StaleElementReferenceException e1) {
			for (int i = 0; i <= 10; ++i) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
					wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).click();
					break;
				} catch (Exception e) {
					continue;
				}
			}
		} catch (Exception e2) {
			LoggerUtil.logMessage("Unable to click mobileElement: " + mobileElement.toString());
		}

		return status;
	}

	/**********************************************************************************************
	 * Fetches elements specific attribute value
	 * 
	 * @param mobileElement
	 *            {@link MobileElement} - MobileElement to fetch the attribute
	 * @param attribute
	 *            - {@link String} - The specific attribute type to evaluate
	 * @return attributeValue
	 ***********************************************************************************************/
	public static String getAttribute(WebElement mobileElement, String attribute) {
		String attributeValue = "";

		try {
			attributeValue = mobileElement.getAttribute(attribute);
		} catch (Exception e) {
			LoggerUtil.logMessage("Unable to get attribute for mobileElement: " + mobileElement.toString());
		}
		return attributeValue;
	}
}
