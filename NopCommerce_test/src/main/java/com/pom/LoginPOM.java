package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class LoginPOM extends BaseClass {

	public WebDriver driver;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//div[text()='Login was unsuccessful. Please correct the errors and try again.']")
	private WebElement loginFail;
	
	public LoginPOM(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public void enterLoginDetails(String userName,String pwd) {
		email.clear();
		password.clear();
		inputValues(driver, email, userName);
		inputValues(driver, password, pwd);
	}
	public void login() {
		clickElement(driver, loginBtn);
	}
	
	public void logOut() {
		clickElement(driver, logoutBtn);
	}
	
	public void loginFail() {
		boolean contains = loginFail.getText().contains("Login was unsuccessful");
		Assert.assertTrue(contains);
	}
	
	
}
