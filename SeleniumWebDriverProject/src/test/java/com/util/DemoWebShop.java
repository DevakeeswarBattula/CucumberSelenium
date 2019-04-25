package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoWebShop {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		driver=DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
	}
	@AfterMethod

	public void afterMethod()
	{
		//driver.close();
	}


	
	@Test
	public void testDemoWebShop()
	{
		driver.get("http://demowebshop.tricentis.com/login");
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("webshop"));
		WebElement email=driver.findElement(By.id("Email"));
		email.sendKeys("askmail@email.com");
		driver.findElement(By.id("Password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		
	}
	
}
