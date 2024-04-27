package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	protected static WebDriver driver;
	protected static String username="sbrinsoctt91@gmail.com";
	protected static String pwd="Deekshi*123";
	public static ExtentReports extentReports;
	public static ExtentSparkReporter extentSparkReporter;
	public static File file;

		public static WebDriver browserLaunch(String browserName) {
			switch (browserName) {
			case "Chrome":
				ChromeOptions options = new ChromeOptions ();
				options.addArguments("incognito");			
				driver = new ChromeDriver ();
				break;
			case "FireFox":
				driver = new FirefoxDriver();
				break;
			case "Edge":
				driver = new EdgeDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			return driver;
			}
		protected void launchURL(WebDriver driver, String url) {
			try {
				driver.get(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void clickElement(WebDriver driver, WebElement element) {
			try {
				new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		protected void inputValues(WebDriver driver,WebElement element, String value) {
			try {
				element.clear();
				new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));
				element.sendKeys(value);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		protected void expliciWaitVisible(WebDriver driver,WebElement element) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(30))		
				.until(ExpectedConditions.visibilityOf(element));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		protected void implicitWaitVisible(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		protected void staticWait(long sec	) {
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		protected void selectFromDropdown(WebElement element, int index) {
			Select option = new Select(element);
			option.selectByIndex(index);			
		}
		protected void selectFromDropdownByValue(WebElement element, String value) {
			Select option = new Select(element);
			option.selectByValue(value);			
		}
		protected void selectFromDropdownByText(WebElement element, String value) {
			Select option = new Select(element);
			option.selectByValue(value);			
		}		
		
		protected void pageRefresh() {
			driver.navigate().refresh();
		}
		/*	protected void openNewTab(WebDriver driver, WebElement tab) throws AWTException {
			
			new WebDriverWait(driver,Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(tab));		
			Actions a1= new Actions (driver);
			a1.contextClick(tab).build().perform();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			
		}
		protected void switchTab(String parent,Set<String> set) {
			set.toArray().toString();
			for(String subTab: set) {
				if(!parent.equalsIgnoreCase(subTab)) {
					driver.switchTo().window(subTab);
				}
			}
		}			*/
		
		protected void switchTab() {
			try {
				Set<String> set = driver.getWindowHandles();
				ArrayList arr = new ArrayList(set);
				driver.switchTo().window((String)arr.get(1));
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		protected void switchToHome() {
			try {
				Set<String> set = driver.getWindowHandles();
				ArrayList arr=new ArrayList(set);
				driver.switchTo().window((String)arr.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		protected void screenshot(WebDriver driver, String name) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File ("C:\\Users\\snk27\\eclipse-workspace\\NopCommerce\\Screenshot"+ name + ".png");
			try {
				FileHandler.copy(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		protected void jsClick(WebDriver driver, WebElement element) {
			try {
				JavascriptExecutor js= (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		protected void closeTab() {
			driver.close();
		}
		
		protected void terminateBrower() {
			driver.quit();
		}
		
		public void extendReportStart() {
			extentReports = new ExtentReports();
			file = new File("C:\\Users\\snk27\\eclipse-workspace\\NopCommerce_test\\Reports");
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);		
		}
		public void extendReportTearDown() throws IOException {
			extentReports.flush();
			file = new File("C:\\Users\\snk27\\eclipse-workspace\\NopCommerce_test\\Reports");
			Desktop.getDesktop().browse((file).toURI());
		}
		public String takeScreenshot() throws IOException {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmSS").format(new Date());
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dest = new File("Screenshot\\.png" + "_"+ timestamp + ".png");
			FileUtils.copyFile(src, dest);
			return dest.getAbsolutePath();
			
		}

}
