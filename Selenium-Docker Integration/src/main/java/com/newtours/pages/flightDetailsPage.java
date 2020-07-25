package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightDetailsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "passCount")
	private WebElement passengers;

	@FindBy(name = "findFlights")
	private WebElement findFlights;

	public flightDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void selectPassenger(String passengerCount) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.passengers));
		Select select = new Select(passengers);
		select.selectByValue(passengerCount);

	}
	
	public void findFlightsPage() {
		this.findFlights.click(); 
	}

}
