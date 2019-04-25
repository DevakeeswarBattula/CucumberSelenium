package Skeleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.util.DriverUtility;

import Page.Case1AddCategoryPage;
import Page.Case1LoginPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Case1LoginStepDefs {
	
	
	WebDriver driver;
	@Before
	public void init()
	{

		driver=DriverUtility.getDriver("chrome");
		PageFactory.initElements(driver, Case1LoginPage.class);
		PageFactory.initElements(driver, Case1AddCategoryPage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	
	@Given("The URL of TestMe App")
	public void the_URL_of_TestMe_APP()
	{
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");  
	}
	
	
	
	@When("user logged in as admin")
	public void user_logged_in_as_admin() {
		Case1LoginPage.username.sendKeys("admin");
		Case1LoginPage.password.sendKeys("Password456");
		Case1LoginPage.login.click();
		
	   
	}

	@Then("user is in admin home page")
	public void user_is_in_admin_home_page() {
		
		
	   
	}
	
	@Given("select add category")
	public void select_add_category() {
		Case1AddCategoryPage.addproduct.click();
		Case1AddCategoryPage.catname.click();
		Case1AddCategoryPage.subcatname.click();
		Case1AddCategoryPage.productname.sendKeys("Laptop");
		Case1AddCategoryPage.price.sendKeys("38,000");
		Case1AddCategoryPage.quantity.sendKeys("1");
		Case1AddCategoryPage.brand.sendKeys("HP");
		Case1AddCategoryPage.desc.sendKeys("HP Laptop with 8GB RAM");
		
		
	    
	}

	@When("user enters category name and description")
	public void user_enters_category_name_and_description() {
		
	}

	@Then("adding products successfully")
	public void adding_products_successfully() {
		
		
	   
	}

	
	


}
