package com.smith.tomtom.reactform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement formLink;
	
	public void clickLink() {
		formLink.click();
	}
}
