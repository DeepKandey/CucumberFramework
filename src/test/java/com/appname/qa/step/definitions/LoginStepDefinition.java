package com.appname.qa.step.definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {

	public WebDriver driver;

	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		Assert.assertEquals("Log In", driver.findElement(By.xpath("//input[@value='Log In']")).getAttribute("value"));
	}

	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("deepak.rai21@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("Rehan@91");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		String exp_message = "Deepak";
		String actual = driver.findElement(By.xpath("//span[@class='_1vp5']")).getText();
		System.out.println("Logged in as: " + actual);
		Assert.assertEquals(exp_message, actual);
		driver.quit();
	}
}
