package com.newtours.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.RegistrationPage;
import com.newtours.pages.findFlightPage;
import com.newtours.pages.flightConfirmationPage;
import com.newtours.pages.flightDetailsPage;
import com.newtours.pages.registerationConfirmationPage;

import baseTest.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class bookFlightTest extends BaseTest {

	private String noOfPassengers;
	private String expectedPrice;

	@BeforeTest
	@Parameters({ "noOfpassengers", "expectedPrice" })
	public void setupParameters(String noOfpassengers, String expectedPrice) {
		this.expectedPrice = expectedPrice;
		this.noOfPassengers = noOfpassengers;

	}

	@Test
	public void registrationTest() throws InterruptedException {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo();
		registrationPage.enteringUserDetails("Docker", "Selenium");
		registrationPage.enteringUserCredetials("Rajesh", "Ganessan", "Ganessan");

		Thread.sleep(20000);
		registrationPage.clickSubmit();
	}

	@Test(dependsOnMethods = "registrationTest")
	public void registrationConfirmation() {
		registerationConfirmationPage registerationConfirmationPage = new registerationConfirmationPage(driver);
		registerationConfirmationPage.goToFlightsDetailsPage();
	}

	@Test(dependsOnMethods = "registrationConfirmation")
	public void FlightsDetails() {

		flightDetailsPage flightDetailsPage = new flightDetailsPage(driver);
		flightDetailsPage.selectPassenger(noOfPassengers);
		flightDetailsPage.findFlightsPage();
	}

	@Test(dependsOnMethods = "FlightsDetails")
	public void findFlightPage() {
		com.newtours.pages.findFlightPage findFlightPage = new findFlightPage(driver);
		findFlightPage.submitFindFlight();
		findFlightPage.goToFlightConfirmationPage();
	}

	@Test(dependsOnMethods = "findFlightPage")
	public void flightConfirmation() {
		flightConfirmationPage flightConfirmationPage = new flightConfirmationPage(driver);
		String actualPrice = flightConfirmationPage.getPrice();
		AssertJUnit.assertEquals(expectedPrice, actualPrice);
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
