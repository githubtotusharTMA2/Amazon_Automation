package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class CouponsPage extends TestBase
{
	@FindBy(xpath = "//span[@class = 'a-size-large vpc_coupon_bar_my_coupons coupon_bar_text vpc_clickable']")
	WebElement myCouponsLabel;
	
	// Initializing the page objects :
	public CouponsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCouponsLabel()
	{
		return myCouponsLabel.isDisplayed();
	}
	
	public void selectShopByCategory()
	{
		driver.findElement(By.xpath("//img[@src = 'https://images-eu.ssl-images-amazon.com/images/G/31/img18/Coupons/nav/new/SBC-desktop._AA180_.jpg']")).click();
	}
	
}
