package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class findFlightPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "reserveFlights")
	private WebElement findFlightsBtn;
	
	@FindBy(name = "buyFlights")
	private WebElement submitBookFlight;

	public findFlightPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	
	public void submitFindFlight() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.findFlightsBtn));
		this.findFlightsBtn.click();
		
	}
	
	public void goToFlightConfirmationPage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.submitBookFlight));
		
		this.submitBookFlight.click();
	}
}
