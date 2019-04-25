package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class MozillaFirefoxTest {
	
	
	@Test
	public void testMozilla()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\battula.devakeeswar\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.flipkart.com/");
		
		
	}

}
