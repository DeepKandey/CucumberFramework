package com.appname.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appname.qa.base.Base;

public class LoginPage extends Base {

	@FindBy(xpath ="//input[@value='Log In']")
	WebElement logInLnk;

	@FindBy(id ="email")
	WebElement emailTxt;

	@FindBy(id = "pass")
	WebElement passwordTxt;

	@FindBy(xpath = "//span[@class='_1qv9']")
	WebElement userName;

	public void enterUserCredentials(String userName, String password) {
		emailTxt.sendKeys(userName);
		passwordTxt.sendKeys(password);
		logInLnk.click();
	}

	public String getLoginTxt() {
		return logInLnk.getAttribute("value");
	}

	public String getUserNameTxt() {
		return userName.getText();
	}

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
