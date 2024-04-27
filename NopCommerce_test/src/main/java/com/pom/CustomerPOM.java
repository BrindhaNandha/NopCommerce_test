package com.pom;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.DataDriven.Data_Driven_Classnew;

import com.base.BaseClass;

public class CustomerPOM extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(xpath="//i[@class='nav-icon far fa-user']")
	private WebElement customerMenu;
	
	@FindBy(xpath="//i[@class='nav-icon far fa-user']//following::li[1]")
	private WebElement customer;
	
	@FindBy(id="SearchEmail")
	private WebElement sEmail;
	
	@FindBy(xpath="(//table)[2]/tbody/tr/td[2]")
	private WebElement matchEmail;
	
	@FindBy(id="SearchFirstName")
	private WebElement sFirstName;
	
	@FindBy(xpath="(//table)[2]/tbody/tr/td[3]")
	private WebElement matchName;
	
	@FindBy(id="SearchLastName")
	private WebElement sLastName;
	
	@FindBy(id="SearchCompany")
	private WebElement sCompany;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	private WebElement sCustomerRoles;
	
	@FindBy(xpath="(//li[@class='k-item']//following-sibling::li)[2]")
	private WebElement registered_custRole;
	
	@FindBy(xpath="(//table)[2]/tbody/tr[1]/td[7]")
	private WebElement editFirstCol;
	
	@FindBy(id="customer-delete")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//button[contains(text(),'Delete')]")
	private WebElement deletePrompt;
	
	@FindBy(id="search-customers")
	private WebElement searchCust;
	
	@FindBy(xpath="//i[@class='fas fa-plus-square']")
	private WebElement addNewCustomer;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="Password")
	private WebElement pwd;

	@FindBy(id="FirstName")
	private WebElement firstName;

	@FindBy(id="LastName")
	private WebElement lastName;

	@FindBy(id="Gender_Male")
	private WebElement gender_Male;

	@FindBy(id="Gender_Female")
	private WebElement gender_Female;

	@FindBy(id="DateOfBirth")
	private WebElement dob;

	@FindBy(id="Company")
	private WebElement company;
	
	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
	private WebElement newsLetter;

	@FindBy(xpath="//li[text()='Test store 2']")  
	private WebElement newsLetterSelection;

	@FindBy(xpath="(//div[@class='k-widget k-multiselect k-multiselect-clearable'])[2]")				
	private WebElement customerRoles;
	
	@FindBy(xpath="//li[text()='Registered']")
	private WebElement custRolesSelection;
	
	@FindBy(xpath="(//li[@class='k-item']//following-sibling::li)[4]")
	private WebElement custRole_Registered;

	@FindBy(id="VendorId")										
	private WebElement vendorId;
	
	@FindBy(name="save")
	private WebElement saveBtn;
	
	@FindBy(xpath="//button[@data-dismiss='alert']")
	private WebElement dismiss;
	
	public CustomerPOM(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMenu() {
		clickElement(driver, customerMenu);
	}
	
	public void clickCustomer() {
		clickElement(driver, customer);
	}
	public void addCustomer() {
		clickElement(driver, addNewCustomer);
	}
	public void addCustomerDetails() throws InvalidFormatException, IOException{
		Data_Driven_Classnew data = new Data_Driven_Classnew();
		inputValues(driver, email, data.getEmail());				
		inputValues(driver, pwd, data.getPassword());
		inputValues(driver, firstName, data.getFirstName());
		inputValues(driver, lastName, data.getLastName());
		clickElement(driver, gender_Female);
		inputValues(driver, dob, data.getDOB());
		inputValues(driver, company, data.getDOB());
		clickElement(driver, newsLetter);
		clickElement(driver, newsLetterSelection);
		selectFromDropdown(vendorId, 1);
	}
	public void saveDetails() {
		clickElement(driver, saveBtn);		
	}
	
	public void successMsg() {
		
		boolean contains = dismiss.getText().contains("added successfully");
		Assert.assertFalse(contains);
	}
	public void searchByEmail() throws InvalidFormatException, IOException {
		Data_Driven_Classnew data = new Data_Driven_Classnew();
		inputValues(driver, sEmail, data.getEmail());				
		clickElement(driver, sCustomerRoles);
	}
	
	public void clickSearch() {
		clickElement(driver, searchCust);
	}
	
	public void searchByName() throws InvalidFormatException, IOException {
		Data_Driven_Classnew data = new Data_Driven_Classnew();
		inputValues(driver, sFirstName, data.getFirstName());	
	}
	
	public void EditOption() throws InvalidFormatException, IOException {
		Data_Driven_Classnew data = new Data_Driven_Classnew();
		inputValues(driver, sFirstName,data.getFirstName() );		
		clickElement(driver, searchCust);
		clickElement(driver, editFirstCol);
	}
	public void deleteCust() {
		clickElement(driver, deleteBtn);
	}
	
	public void confDelete() {
		clickElement(driver, deletePrompt);
	}	
	
	public void deleteMsg() {
		boolean contains = dismiss.getText().contains("deleted successfully");
		Assert.assertFalse(contains);
	}
}
