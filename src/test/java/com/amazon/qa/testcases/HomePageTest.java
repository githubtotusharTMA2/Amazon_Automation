package com.amazon.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CouponsPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CouponsPage couponsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	// Test cases should be separated -- independent with each other.
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() throws InterruptedException
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Thread.sleep(2000);
		Assert.assertEquals(homePageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyCouponsLinkTest()
	{
		couponsPage = homePage.clickOnCoupons();
	}
	
	@Test(priority = 1)
	public void verifyRecommendations() throws InterruptedException
	{
		homePage.mouseOverAndClickOnYourRecommendations();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'More to Explore')]")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
