package com.appname.qa.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/features", glue = "com.appname.qa.step.definitions", monochrome = true, dryRun = false, plugin = {
		"pretty","html:target/LoginReport" })

public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}
