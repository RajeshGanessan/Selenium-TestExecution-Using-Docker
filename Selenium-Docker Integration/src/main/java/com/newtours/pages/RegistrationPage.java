package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(name = "firstName")
	private WebElement firstNameTxt;

	@FindBy(name = "lastName")
	private WebElement lastNameTxt;

	@FindBy(name = "email")
	private WebElement emailTxtBox;

	@FindBy(name = "password")
	private WebElement passwordTxt;

	@FindBy(name = "confirmPassword")
	private WebElement confirmPassBox;

	@FindBy(name = "register")
	private WebElement registerBtn;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver,this);
	}

	public void goTo() {

		this.driver.get("http://newtours.demoaut.com/mercuryregister.php ");
		this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt ));

	}
	
	//entering details
	public void enteringUserDetails(String firstName,String lastName) {
		this.firstNameTxt.sendKeys(firstName);
		
		this.lastNameTxt.sendKeys(lastName);
	}
	
	//entering lastname
	public void enteringUserCredetials(String userName,String password,String confirmPassword) {
		this.emailTxtBox.sendKeys(userName);
		
		this.passwordTxt.sendKeys(password);
		
		this.confirmPassBox.sendKeys(confirmPassword);
	}
	
	//clicking submit button
	public void clickSubmit() {
		
		this.registerBtn.click(); 
	}
}
