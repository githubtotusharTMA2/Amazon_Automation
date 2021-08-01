package com.amazon.qa.util;

import com.amazon.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
