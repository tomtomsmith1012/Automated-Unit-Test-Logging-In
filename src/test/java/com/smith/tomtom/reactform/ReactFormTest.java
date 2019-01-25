package com.smith.tomtom.reactform;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReactFormTest {

	WebDriver driver;
	static ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public static void firstStart() {
		report = new ExtentReports(Constant.REPORT_PATH, true);
	}

	@AfterClass
	public static void finalClose() {
		report.flush();
	}

	@Before

	public void startUp() {
		System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
		driver = new ChromeDriver();
	}

	@After
	public void shutDown() {
		driver.quit();
	}

	@Test
	public void webTest() {

		int testNumber = 1;
		for (int i = 0; i < 4; i++) {
			test = report.startTest("Correct password log in test " + testNumber + ".");
			testNumber++;
			LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
			FormPage form = PageFactory.initElements(driver, FormPage.class);

			driver.get(Constant.START_URL);
			test.log(LogStatus.INFO, "Navigating to react home page");
			
			landing.clickLink();
			test.log(LogStatus.INFO, "Navigating to form page");

			form.fillForm(driver, Constant.emails[i], Constant.passwords[i], Constant.passwords[i],
					Constant.countryIds[i]);
			test.log(LogStatus.INFO, "Filling in form using email: " + Constant.emails[i] + ", password: "
					+ Constant.passwords[i] + ".");

			assertEquals("Login was not successful.", "Success!",
					driver.findElement(By.xpath(Constant.FINAL_CHECK)).getText());
			if (driver.findElement(By.xpath(Constant.FINAL_CHECK)).getText().equals("Success!")) {
				test.log(LogStatus.PASS, "Login was successful.");
			} else {
				test.log(LogStatus.FAIL, "Login failed.");
			}
			report.endTest(test);
		}
	}

	@Test
	public void errorTest() {

		int testNumber = 1;
		for (int i = 0; i < 4; i++) {
			test = report.startTest("Wrong password log in test " + testNumber + ".");
			testNumber++;
			LandingPage landing = PageFactory.initElements(driver, LandingPage.class);
			FormPage form = PageFactory.initElements(driver, FormPage.class);

			driver.get(Constant.START_URL);
			test.log(LogStatus.INFO, "Navigating to react home page");
			
			landing.clickLink();
			test.log(LogStatus.INFO, "Navigating to form page");

			form.fillForm(driver, Constant.emails[i], Constant.passwords[i], Constant.wrongPasswords[i],
					Constant.countryIds[i]);
			test.log(LogStatus.INFO, "Filling in form using email: " + Constant.emails[i] + ", password: "
					+ Constant.passwords[i] + ", confirm password: " + Constant.wrongPasswords[i] + ".");

			assertEquals("Passwords do not match message not displayed.", "The passwords do not match",
					driver.findElement(By.xpath(Constant.PASSWORD_CHECK)).getText());
			if (driver.findElement(By.xpath(Constant.PASSWORD_CHECK)).getText().equals("The passwords do not match")) {
				test.log(LogStatus.PASS, "Passwords do not match message was correctly displayed.");
			} else {
				test.log(LogStatus.FAIL, "Passwords do not match message was not correctly displayed.");
			}
		}
		report.endTest(test);
	}

}
