package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchModule.pages.searchPage;

import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest extends BaseTest{
	
	
	@Parameters({"keyword"})
	@Test
	public void search(String keyword) {
		searchPage searchPage = new searchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.goToVideosTab();
		int size = searchPage.getResult();
		System.out.println("Video results : " + size);
		Assert.assertTrue(size>0);
	}

}
