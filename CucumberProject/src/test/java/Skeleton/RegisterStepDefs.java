package Skeleton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.util.DriverUtility;

import Page.RegisterPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefs {
	WebDriver driver;
	@Before
	public void init()
	{

		driver=DriverUtility.getDriver("chrome");
		PageFactory.initElements(driver, RegisterPage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@Given("url of the demowebshop")
	public void url_of_the_demowebshop() {
	   driver.get("http://demowebshop.tricentis.com/register");
	}

	@When("user enters the data for registration")
	public void user_enters_the_data_for_registration() {
	    RegisterPage.gender.click();
	    RegisterPage.firstname.sendKeys("battula");
	    RegisterPage.lastname.sendKeys("devakeeswar");
	    RegisterPage.email.sendKeys("bat1112333@gmail.com");
	    RegisterPage.password.sendKeys("1234567890");
	    RegisterPage.confirmpassword.sendKeys("1234567890");
	    RegisterPage.registerbutton.click();
	}

	@Then("user is registered successfully")
	public void user_is_registered_successfully() {
		//Assert.assertEquals("Your registration completed",RegisterPage.regsuccess);
		Assert.assertTrue(RegisterPage.regsuccess.getText().contains("registration completed"));
		
	
	}


}
