package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.DriverUtility;

public class KeyboardActions {
	@Test
	public void testKeyboard()
	{
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.id("myInput"));
		Actions act1=new Actions(driver);
		act1.keyDown(search,Keys.SHIFT).perform();
		act1.sendKeys("b").keyUp(search,Keys.SHIFT).pause(1000).sendKeys("a").pause(1000).sendKeys("g").perform();
		act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		String result=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[1]/center[1]/h4")).getText();
		Assert.assertTrue(result.contains("Hand bag"));
	}

}
