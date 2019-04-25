package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class MultipleBrowserTest {
	
	
	@Test
	public void testInternetExplorer()
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\battula.devakeeswar\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.flipkart.com/");
		
		System.setProperty("webdriver.ie.driver","C:\\Users\\battula.devakeeswar\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
		WebDriver driver1=new InternetExplorerDriver();
		
		driver1.get("http://www.google.co.in/");
			
	}

}
