package com.smith.tomtom.reactform;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class TestRunner {
	
	static ExtentReports report;
	
	@BeforeClass
	public static void firstSetup() {
		report = new ExtentReports(Constant.REPORT_PATH, true);
	}
	
	@AfterClass
	public static void lastShutDown() {
		report.flush();
	}

}
