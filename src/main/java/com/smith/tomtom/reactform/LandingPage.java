package com.smith.tomtom.reactform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	private WebElement wait;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement formLink;
	
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
	
	public void fillForm(WebDriver driver, String user, String pass, String pass2, int countryId) {
		Actions actions = new Actions(driver);
		
		formLink.click();
		name.sendKeys("Tom");
		actions.moveToElement(countryButton).perform();
		wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(countryUk));
		
		if (countryId == 0) {
			countryUk.click();
		}else if (countryId == 1) {
			countryFrance.click();
		}else {
			countryGermany.click();
		}
		
		email.sendKeys(user);
		password.sendKeys(pass);
		password2.sendKeys(pass2);
		submit.click();
	}
}
