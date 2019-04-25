package com.tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.util.Drivers;

public class OnlineShoppingTest {

	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		
		driver=Drivers.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


	}




	@BeforeTest
	public void startReportBeforeTest()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm");

		String path=System.getProperty("user.dir")+"/extent-report/"+sdf.format(new Date())+".html";
		htmlreporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("username","deva");
		reports.setSystemInfo("hostname","localhost");
		reports.setSystemInfo("environment","test environment");

		htmlreporter.config().setReportName("test me app");
		htmlreporter.config().setTheme(Theme.DARK);
	}




	//**********************************************************************************************************************************
	@Test(priority=1)
	public void testRegistration() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("devabattu");
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
		
		
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		String text2=driver.findElement(By.xpath("//form[@role='form']/fieldset/div[8]")).getText();
		Assert.assertEquals(text2,"User Registered Succesfully!!! Please login");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login");
		System.out.println("Registration Successful");
		logger=reports.createTest("Registration Page");
		logger.log(Status.INFO,"Registration Success");
		String regSuccess=driver.findElement(By.xpath("//form[@role='form']/fieldset/div[8]")).getText();
		Assert.assertTrue(regSuccess.contains("Registered Succesfully"));
		Assert.assertTrue(true);
		//String text1=driver.findElement(By.



		//Assert.assertEquals(text1,"User Registered Successfully!!! Please login");

	}

	//**************************************************************************************************************************	
	@Test(dataProvider="dp1",priority=2) 
	public void testLogin(String username,String password) throws InterruptedException
	{
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.name("Login")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul")).getText().contains("hi deva");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Home");
		System.out.println("Login Successful");

	}


	@DataProvider(name="dp1")
	public Object[][] getData() 
	{ Object[][] obj= {
			{"devabattu","Deva1234"}
	}; 
	return obj; 
	}


	//****************************************************************************************************************************

	@Test(priority=3)
	public void testCart() throws InterruptedException
	{

		Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).click().perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Head Phone"))).click().perform();

		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		logger=reports.createTest("cart");
		logger.log(Status.INFO,"Products added");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		driver.findElement(By.cssSelector("input[value='Proceed to Pay']")).click();
		Thread.sleep(3000);


	}

	//********************************************************************************************************************************	

	@Test(priority=4)
	public void testPayment() throws InterruptedException
	{

		String title=driver.getTitle();
		Assert.assertEquals(title, "Payment Gateway");
		System.out.println("Payement Gateway");
		driver.findElement(By.xpath("//div[@id='swit']/div/div/label/i")).click();
		//driver.findElement(By.cssSelector("input[name='Andhra Bank']")).click();
		driver.findElement(By.cssSelector("a[id='btn']")).click();
		logger=reports.createTest("Payment");
		logger.log(Status.INFO,"Bank Opted");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Pass@456");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.cssSelector("input[value='PASSWORD']")).sendKeys("Trans@456");
		driver.findElement(By.cssSelector("input[value='PayNow']")).click();
		logger=reports.createTest("PaymentStatus");
		logger.log(Status.INFO,"Payment Processed");
		String text3=driver.findElement(By.xpath("/html/body/b/section/div/div/div/div[2]/p")).getText();
		Assert.assertEquals(text3,"Your order has been confirmed");
		String title1=driver.getTitle();
		Assert.assertEquals(title1, "Order Details");
		System.out.println("Order Details");
		driver.findElement(By.linkText("Home")).click();

	}
	@AfterMethod
	public void afterMethod(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,"Test Failed");
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,"Test Success");
		}
		if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP,"Test Skipped");
		}

	}


	@AfterClass
	public void afterClass()

	{
		reports.flush();
		driver.close();
	}


	@AfterTest
	public void endReportAfterTest()
	{

	}

}
