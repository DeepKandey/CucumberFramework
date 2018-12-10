package com.appname.qa.testrunner;

import java.io.File;

import org.testng.annotations.AfterSuite;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = "com.appname.qa.step.definitions", monochrome = true, dryRun = false, plugin = {
		"pretty", "html:target/HTMLReport",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" })

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(
				new File(System.getProperty("user.dir") + "//src//test//resources//ExtentConfig//report.xml"));

	}
}
