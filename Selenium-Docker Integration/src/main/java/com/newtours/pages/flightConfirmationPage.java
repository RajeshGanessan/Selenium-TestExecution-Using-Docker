package com.newtours.pages;

import java.awt.List;

import javax.swing.text.html.ListView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.This;

public class flightConfirmationPage {

	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//font[contains(text(),'Flight')]")
	private WebElement flightConfirmationHeader;
	
	@FindBy(xpath = "//font[contains(text(),'USD')]")
	private java.util.List<WebElement>prices;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffBtn;

	public flightConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	
	public String getPrice() {
		this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
		System.out.println(this.flightConfirmationHeader.getText());
		System.out.println(this.prices.get(1).getText());
		String price = this.prices.get(1).getText();
		this.signOffBtn.click();
		return price;
	}
}
