package com.stepdefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.pom.GiftCardsPOM;
import com.pom.LoginPOM;
import com.runner.RunnerTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.base.BaseClass;

public class GiftCard_StepDef extends BaseClass {

	public WebDriver driver=RunnerTest.driver;
	//@Before
	public void beforeScenario(Scenario s) {
		System.out.println("Scenario : "+s.getName());
	}
	//@After (order = 1)
	public void scenarioStatus(Scenario s) {
		Status status = s.getStatus();
		System.out.println("Status : "+s.getStatus());
		if ((status.toString()).equalsIgnoreCase("FAILED")) {
			screenshot(driver, s.getName());
		}
	}
	//@After(order=0)
	public void logOut() {
		LoginPOM login=new LoginPOM(driver);
		login.logOut();		
	}
	@When("user Enters GiftCard Option")
	public void user_enters_gift_card_option() {
		GiftCardsPOM gift = new GiftCardsPOM(driver);
		gift.clickSales();
	}

	@When("user Clicks On Add Button")
	public void user_clicks_on_add_button() {
		GiftCardsPOM gift = new GiftCardsPOM(driver);
		gift.clickAdd();
	}

	@When("user Enters Gift Card Details")
	public void user_enters_gift_card_details() throws InvalidFormatException, IOException {
		GiftCardsPOM gift = new GiftCardsPOM(driver);
		gift.giftDetails();
	}

	@Then("user Gets {string} Msg")
	public void user_gets_msg(String string) {
		GiftCardsPOM gift = new GiftCardsPOM(driver);
		gift.successMsg();
	}
	@When("user Activates Gift Card")
	public void user_activates_gift_card() {
		GiftCardsPOM gift = new GiftCardsPOM(driver);
		gift.activateGiftCard();
	}
	@Then("user Gets {string} message")
	public void user_gets_message(String string) {
		GiftCardsPOM gift = new GiftCardsPOM(driver);
		gift.updateMsg();
	}
}
