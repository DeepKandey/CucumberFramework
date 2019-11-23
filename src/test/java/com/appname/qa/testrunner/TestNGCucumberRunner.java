package com.appname.qa.testrunner;

import org.testng.annotations.AfterSuite;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = "com.appname.qa.step.definitions", monochrome = true, dryRun = false, plugin = {
		"pretty", "html:target/HTMLReport", "json:target/cucumber/cucumber.json",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html" })

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
	@AfterSuite
	public static void writeExtentReport() {
		// Reporter.loadXMLConfig(new
		// File("src/test/resources/ReportConfig/ExtentReportConfig.xml"));
		Reporter.setSystemInfo("User Name", "AJ");
		Reporter.setSystemInfo("Application Name", "Test App ");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
