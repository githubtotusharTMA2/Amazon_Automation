package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(xpath = "//span[contains(text(), 'Hello, Tushar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Coupons')]")
	WebElement coupons;
	
	@FindBy(xpath = "//a[contains(text(), 'Toys & Games')]")
	WebElement toysAndGames;
	
	@FindBy(xpath = "//a[contains(text(), 'Sports, Fitness & Outdoors')]")
	WebElement sfo;
	
	LoginPage loginPage;
	
	// Initializing the page Objects :
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public CouponsPage clickOnCoupons()
	{
		coupons.click();
		return new CouponsPage();
	}
	
	public ToysAndGames clickOnToysAndGames()
	{
		toysAndGames.click();
		return new ToysAndGames();
	}
	
	public SFO clickOnSFO()
	{
		sfo.click();
		return new SFO();
	}
	
	public void mouseOverAndClickOnYourRecommendations()
	{
		Actions action = new Actions(driver);
		loginPage = new LoginPage();
		action.moveToElement(loginPage.signInBtn).build().perform();
		driver.findElement(By.linkText("Your Recommendations")).click();
		
	}
	
}
