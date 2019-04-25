package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CasestudyLogin {
	
	
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		driver=DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass()

	{
		//driver.close();
	}
	
	@Test(dataProvider="dp1")
	public void testLogin(String userName,String password)
	{
		driver.findElement(By.partialLinkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		driver.findElement(By.partialLinkText("SignOut")).click();
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		Object[][] obj= {
				{"Lalitha","Password123"},{"admin","Password456"}
		};
		return obj;
	}


}
