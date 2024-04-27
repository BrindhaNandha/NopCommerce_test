package com.pom;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DataDriven.Data_Driven_Classnew;
import com.base.BaseClass;

public class GiftCardsPOM extends BaseClass{
	
	public WebDriver driver;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-cart']")
	private WebElement salesMenu;
	
	@FindBy(xpath="//p[text()=' Gift cards']")
	private WebElement giftCard;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement addBtn;
	
	@FindBy(xpath="//input[@class='k-formatted-value k-input']")
	private WebElement amount;
	
	@FindBy(xpath="//span[@title='Increase value']")
	private WebElement increaseValue;
	
	@FindBy(id="RecipientName")
	private WebElement recipientName;
	
	@FindBy(xpath="//button[@name='save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//table)[2]/tbody/tr/td[4]")
	private WebElement validateName;
	
	@FindBy(id="ActivatedId")
	private WebElement activatedId; 
	
	@FindBy(id="search-giftcards")
	private WebElement searchBtn;
	
	@FindBy(xpath="(//table)[2]/tbody/tr")
	private WebElement rows;
	
	@FindBy(xpath="(//table)[2]/tbody/tr[1]/td[7]")
	private WebElement rowEdit;
	
	@FindBy(xpath="(//table)[2]/tbody/tr[1]/td[4]")
	private WebElement firstRowName;
	
	@FindBy(id="IsGiftCardActivated")
	private WebElement activateBtn;
	
	@FindBy(xpath="//button[@data-dismiss='alert']")
	private WebElement dismiss;
	
	public GiftCardsPOM(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public void clickSales() {
		clickElement(driver, salesMenu);
		clickElement(driver, giftCard);
	}
	public void clickAdd(){
		clickElement(driver, addBtn);
	}
	public void giftDetails() throws InvalidFormatException, IOException {
		Data_Driven_Classnew data = new Data_Driven_Classnew();
		clickElement(driver, increaseValue);
		clickElement(driver, increaseValue);
		inputValues(driver, recipientName, data.getFirstName());          
		clickElement(driver, saveBtn);
	}
		
	public void successMsg() {
		boolean contains = dismiss.getText().contains("added successfully");
		Assert.assertFalse(contains);
		
	}
	
	public void activateGiftCard() {
		clickElement(driver, activatedId);
		selectFromDropdownByValue(activatedId, "2");
		clickElement(driver, searchBtn);
		clickElement(driver, rowEdit);
		clickElement(driver, activateBtn);
		clickElement(driver, saveBtn);
	}
	public void updateMsg() {
		boolean contains = dismiss.getText().contains("updated successfully");
		Assert.assertFalse(contains);
		
	}
	

}
