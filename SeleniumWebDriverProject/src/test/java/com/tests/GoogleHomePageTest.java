package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.DriverUtility;

public class GoogleHomePageTest {

	
	@Test
	public void testGoogleHomePage()
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\battula.devakeeswar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in/");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		
		
	}
}
