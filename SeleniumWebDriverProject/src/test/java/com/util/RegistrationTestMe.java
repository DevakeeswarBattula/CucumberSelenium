package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RegistrationTestMe {
	

	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		driver=Drivers.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass()

	{
		//driver.close();
	}
	
	@Test
	public void registrationLogin() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("battula11");
		driver.findElement(By.id("firstName")).click();
		String text=driver.findElement(By.id("err")).getText();
		Assert.assertEquals(text,"Available");
		driver.findElement(By.id("firstName")).sendKeys("deva");
		driver.findElement(By.id("lastName")).sendKeys("battula");
		driver.findElement(By.id("password")).sendKeys("Deva1234");
		driver.findElement(By.id("pass_confirmation")).sendKeys("Deva1234");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
	
		driver.findElement(By.id("emailAddress")).sendKeys("battula@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("7729901301");
		//calendar
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		Select bmonth=new Select (driver.findElement(By.className("ui-datepicker-month")));
		bmonth.selectByVisibleText("May");
		Select byear=new Select (driver.findElement(By.className("ui-datepicker-year")));
		byear.selectByVisibleText("1997");
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("address")).sendKeys("D.no:12/1,Srikakulam,AP-532005");
		driver.findElement(By.id("securityQuestion")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("answer")).sendKeys("Srikakulam");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		
		//String text1=driver.findElement(By.
		
		
		
		//Assert.assertEquals(text1,"User Registered Succesfully!!! Please login");
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
