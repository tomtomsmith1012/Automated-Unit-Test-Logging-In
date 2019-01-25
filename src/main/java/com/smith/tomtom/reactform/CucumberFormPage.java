
package com.smith.tomtom.reactform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CucumberFormPage {

	private WebElement wait;
		
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/input[1]")
	private WebElement name;
		
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countryButton;
		
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement countryUk;
		
	@FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement countryFrance;
	
	@FindBy (xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement countryGermany;
		
	@FindBy(xpath = "//*[@id=\"nameInput\"]")
	private WebElement email;
		
	@FindBy(xpath = "//*[@id=\"passInput\"]")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"passInput2\"]")
	private WebElement password2;
		
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submit;
	
	public void selectCountry(WebDriver driver, String country) {
		Actions actions = new Actions(driver);
		actions.moveToElement(countryButton).perform();
		wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(countryUk));
			
		if (country.equals("United Kingdom")) {
			countryUk.click();
		}else if (country.equals("France")) {
			countryFrance.click();
		}else {
			countryGermany.click();
		}

	}
	
	public void fillEmail(String user) {
		email.sendKeys(user);
	}
	
	public void fillPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void fillPassword2(String pass) {
		password2.sendKeys(pass);
		submit.click();
	}
		

	}

