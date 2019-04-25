package Skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions {
	Person sean=new Person();

	@Given("Sean is {int} meters away from Lucia")
	public void sean_is_meters_away_from_Lucia(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		//throw new cucumber.api.PendingException();
		sean.setDistance(int1);	

	}

	@When("Sean shouts {string}")
	public void sean_shouts(String string) {
		// Write code here that turns the phrase above into concrete actions
		//throw new cucumber.api.PendingException();
		sean.setMessage(string);
	}

	@Then("Lucia {string} to the message")
	public void lucia_listens_to_the_message(String flag) {
		if(flag.contentEquals("listens"))
		{
			String message=sean.getMessage();
			Assert.assertEquals("Free Coffee",message);  
		}
		else
		{
			String message=sean.getMessage();
			Assert.assertEquals("CANNOT HEAR",message);  
		}

	}



}
