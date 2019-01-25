package com.smith.tomtom.reactform;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	WebDriver driver;
	LandingPage landing;
	CucumberFormPage form;
	ExtentTest test;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
		driver = new ChromeDriver();
		test = TestRunner.report.startTest("Log in test");
	}
	
	@After
	public void shutDown() {
		TestRunner.report.endTest(test);
		driver.quit();
	}
	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
		driver.get(Constant.START_URL);
		landing = PageFactory.initElements(driver, LandingPage.class);
		test.log(LogStatus.INFO, "Navigating to home page.");
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() {
		landing.clickLink();
		test.log(LogStatus.INFO, "Navigating to form page.");
		form = PageFactory.initElements(driver, CucumberFormPage.class);
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1) {
		form.selectCountry(driver, arg1);
		test.log(LogStatus.INFO, "Selecting country: " + arg1 + ".");
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1) {
	    form.fillEmail(arg1);
	    test.log(LogStatus.INFO, "Filling email field: " + arg1 + ".");
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {
		form.fillPassword(arg1);
		test.log(LogStatus.INFO, "Filling password field: " + arg1 + ".");
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		form.fillPassword2(arg1);
		test.log(LogStatus.INFO, "Filling password confirmation field: " + arg1 + ".");
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() {
		assertEquals("Login was not successful.", "Success!",
				driver.findElement(By.xpath(Constant.FINAL_CHECK)).getText());
		if (driver.findElement(By.xpath(Constant.FINAL_CHECK)).getText().equals("Success!")) {
			test.log(LogStatus.PASS, "Login was successful.");
		} else {
			test.log(LogStatus.FAIL, "Login failed.");
		}
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) {
		form.fillPassword2(arg1);
		test.log(LogStatus.INFO, "Filling password confirmation field with wrong password: " + arg1 + ".");
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		assertEquals("Passwords do not match message not displayed.", "The passwords do not match",
				driver.findElement(By.xpath(Constant.PASSWORD_CHECK)).getText());
		if (driver.findElement(By.xpath(Constant.PASSWORD_CHECK)).getText().equals("The passwords do not match")) {
			test.log(LogStatus.PASS, "Passwords do not match message was correctly displayed.");
		} else {
			test.log(LogStatus.FAIL, "Passwords do not match message was not correctly displayed.");
		}
	}

}
