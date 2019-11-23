package com.appname.qa.step.definitions;

import org.testng.Assert;

import com.appname.qa.base.Base;
import com.appname.qa.pageobjects.LoginPage;
import com.appname.qa.util.LoggerUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends Base {

	LoginPage loginPage;

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		initialization();
		driver.get(prop.getProperty("url"));
		Reporter.addScenarioLog("Scenario is to check user Login");
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		loginPage = new LoginPage();
		Assert.assertEquals("Log In", loginPage.getLoginTxt());
		Reporter.addStepLog("User is navigated to Login Page");
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		loginPage = new LoginPage();
		String exp_message = prop.getProperty("username");
		String actual_message = loginPage.getUserNameTxt();
		LoggerUtil.logMessage("Logged in as: " + actual_message);
		Assert.assertEquals(exp_message, actual_message, "Expected Username is not displayed");
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_credentials(String userName, String password) throws Throwable {
		loginPage = new LoginPage();
		loginPage.enterUserCredentials(userName, password);
	}
}
