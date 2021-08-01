package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CouponsPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.TestUtil;

public class CouponsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CouponsPage couponsPage;
	
	public CouponsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		couponsPage = new CouponsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnCoupons();
	}
	
	
	@Test(priority = 1)
	public void verifyCouponsPageLabel()
	{
		Assert.assertTrue(couponsPage.verifyCouponsLabel(), "coupons page is missing");
	}
	
	@Test(priority = 2)
	public void selectShopByCategoryTest() throws InterruptedException
	{
		couponsPage.selectShopByCategory();
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
