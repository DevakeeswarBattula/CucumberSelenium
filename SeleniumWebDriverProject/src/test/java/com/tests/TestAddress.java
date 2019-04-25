package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.util.DriverUtility;

public class TestAddress {
	@Test
	public void testAddressapp()
	{
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).click().perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Head Phone"))).click().perform();
		driver.findElement(By.cssSelector("a[class='btn btn-success btn-product']")).click();
	}

}
