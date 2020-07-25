package com.searchModule.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath="//form[@id='search_form_homepage_top']//input[@name='q']")
	private WebElement searchBox;

	@FindBy(xpath = "//form[@id='search_form_homepage_top']//input[contains(@class,'js-search-button')]")
	private WebElement searchBtn;
	
	@FindBy(linkText = "Videos")
	private WebElement videosLink;
	
	@FindBy(xpath = "//div[contains(@class,'tile--vid')]")
	private java.util.List<WebElement> allVideos;

	public searchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	public void goTo() {

		this.driver.get("https://duckduckgo.com/");
	}

	// search method
	public void doSearch(String searchTerm) {

		this.wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(searchTerm);
		searchBtn.click(); 
	}
	
	//navigating to Videostab
	public void goToVideosTab() {
		this.wait.until(ExpectedConditions.visibilityOf(videosLink));
		videosLink.click();
	}
	
	//get all videos
	public int getResult() {
		By by = By.className("tile--vid");
		this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		return this.allVideos.size();

		
		
	}
}
