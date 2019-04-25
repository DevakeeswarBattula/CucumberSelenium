package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class InternetExplorerTest {
	
	
	@Test
	public void testInternetExplorer()
	{
		System.setProperty("webdriver.ie.driver","C:\\Users\\battula.devakeeswar\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		driver.get("http://www.google.co.in/");
			
	}

}
