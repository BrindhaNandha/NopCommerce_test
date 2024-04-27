package com.stepdefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pom.LoginPOM;
import com.runner.Test_Runner;
import com.pom.CustomerPOM;
import com.nopcommerce.property.configReader;

public class Customer_StepDef extends BaseClass {
	
	public WebDriver driver=Test_Runner.driver;
	@Before
	public void beforeScenario(Scenario s) {
		System.out.println("Scenario : "+s.getName());
	}
	@After (order = 1)
	public void scenarioStatus(Scenario s) {
		Status status = s.getStatus();
		System.out.println("Status : "+s.getStatus());
		if ((status.toString()).equalsIgnoreCase("FAILED")) {
			screenshot(driver, s.getName());
		}
	}
	@After(order=0)
	public void logOut() {
		LoginPOM login=new LoginPOM(driver);
		login.logOut();		
	}
	
	@Given("user Launch NopCommerce Website")
	public void user_launch_nop_commerce_website() {
		configReader reader = new configReader();
		launchURL(driver,reader.getURL());
	}
	@When("user Enters incorrect {string} And {string}")
	public void user_enters_incorrect_and(String string, String string2) {
		LoginPOM login=new LoginPOM(driver);
		login.enterLoginDetails(string, string2);
	}

	@When("user Enters Email And Password")
	public void user_enters_email_and_password() {
		LoginPOM login=new LoginPOM(driver);
		configReader reader = new configReader();
		login.enterLoginDetails(reader.getUserName(), reader.getPwd());
	}
	@Then("user Gets {string}")
	public void user_gets(String string) {
		LoginPOM login=new LoginPOM(driver);
		login.loginFail();
		//driver.close();
	}

	@When("user Click On LogIn")
	public void user_click_on_log_in() {
		LoginPOM login=new LoginPOM(driver);
		login.login();
	}

	@Then("user Can View The Dashboard")
	public void user_can_view_the_dashboard() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Dashboard / nopCommerce administration");
	}

	@When("user Click On Customers Menu")
	public void user_click_on_customers_menu() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.clickMenu();
	}

	@When("user Clicks On Customers Option")
	public void user_clicks_on_customers_option() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.clickCustomer();
	}

	@Then("user Can View  The Customer Page")
	public void user_can_view_the_customer_page() {
	}

	@When("user Click on AddNew Button")
	public void user_click_on_add_new_button() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.addCustomer();
	}

	@When("user Updates Customer Information")
	public void user_updates_customer_information() throws InvalidFormatException, IOException {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.addCustomerDetails();
	}

	@When("user Clicks On Save Button")
	public void user_clicks_on_save_button() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.saveDetails();
	}

	@Then("user Can View Success Message {string}")
	public void user_can_view_success_message(String string1) {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.successMsg();
	}

	@When("user Enters The Email To Be Searched In Email Tab")
	public void user_enters_the_email_to_be_searched_in_email_tab() throws InvalidFormatException, IOException {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.searchByEmail();
	}

	@When("user Clicks On Search Button")
	public void user_clicks_on_search_button() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.clickSearch();
	}

	@Then("user Should Find The Customer In The Customer Table")
	public void user_should_find_the_customer_in_the_customer_table() {
		CustomerPOM customer = new CustomerPOM(driver);
		//customer.matchEmail();
	}

	@When("user Enters The ForeName To Be Searched In ForeName Tab")
	public void user_enters_the_fore_name_to_be_searched_in_fore_name_tab() throws InvalidFormatException, IOException {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.searchByName();
	}

	@When("user Selects the Searched Customer Record From Table")
	public void user_selects_the_searched_customer_record_from_table() {
		//CustomerPOM customer = new CustomerPOM(driver);
		//customer.matchName();
	}

	@When("user Clicks Edit Button")
	public void user_clicks_edit_button() throws InvalidFormatException, IOException {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.EditOption();
	}

	@When("user Clicks Delete Button")
	public void user_clicks_delete_button() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.deleteCust();
	}

	@When("user Confirms the Delate Prompt Message")
	public void user_confirms_the_delate_prompt_message() {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.confDelete();
	}

	@Then("user Can View Confirmation Message {string}")
	public void user_can_view_confirmation_message(String string) {
		CustomerPOM customer = new CustomerPOM(driver);
		customer.deleteMsg();
	}
}
