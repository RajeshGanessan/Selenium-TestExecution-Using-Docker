package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(partialLinkText = " sign-in ")
    private WebElement signIn;


    @FindBy(partialLinkText = "Flights")
    private WebElement flightsLink;

    @FindBy(xpath = "//input[contains(@class,'hello')]")
    private WebElement newLink;

    public registerationConfirmationPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
			PageFactory.initElements(driver, this);
    }


    public void goToFlightsDetailsPage() {
        this.flightsLink.click();

    }
}
