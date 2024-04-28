package com.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import com.base.BaseClass;
import com.nopcommerce.property.configReader;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features",
					glue="com.stepdefinition",
					plugin={"pretty",
					"html:Reports/HTMLREport.html",
					"json:Reports/JSONREport.jason",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}					)

public class RunnerTest {
	public static WebDriver driver;
@BeforeClass
	public static void setUp() {
	configReader reader = new configReader();
	driver=BaseClass.browserLaunch(reader.getBrowser());
}
@AfterClass
	public static void tearDown() {
	driver.quit();
}
	
	

}
