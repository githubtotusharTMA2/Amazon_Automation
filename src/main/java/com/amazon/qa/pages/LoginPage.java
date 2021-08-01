package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	// Page Factoy - OR :
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	public WebElement	signInBtn;
	
	@FindBy(id = "ap_email")
	WebElement username;
	
	@FindBy(id = "continue")
	WebElement continueBtn;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement finalSignInBtn;
	
	@FindBy(id = "nav-logo-sprites")
	WebElement amazonLogo;
	
	// Initializing the Page Objects :
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions :
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateAmazonImage()
	{
		return amazonLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		signInBtn.click();
		username.sendKeys(un);
		continueBtn.click();
		password.sendKeys(pwd);
		finalSignInBtn.click();
		
		return new HomePage();
	}
	
	
	
}
