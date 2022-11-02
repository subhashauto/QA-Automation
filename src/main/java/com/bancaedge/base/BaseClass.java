package com.bancaedge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.bancaedge.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	// public static WebDriver driver;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static WebDriver getDriver() {
		return driver.get();

	}
	//@BeforeSuite(groups = {"Sanity","Smoke","Regression"})
	@BeforeTest(groups = {"Sanity","Smoke","Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		try {
			prop = new Properties();
			System.out.println("----------BancaEdge Test Automation Started---------");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
			//System.out.println("driver : " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/*@BeforeTest(groups = {"Sanity","Smoke","Regression"})
	public void loadConfig1() {
		

	}*/
    
	public static void luanchApp(String browserName ) {

		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}

		getDriver().manage().window().maximize();
		// driver.get(prop.getProperty("URL"));
		getDriver().get("https://uat.bancaedge.com/account/login");

		/*
		 * WebDriverManager.chromedriver().setup(); String
		 * browserName=prop.getProperty("browser"); if(browserName.contains("Chrome")) {
		 * driver=new ChromeDriver(); } else if(browserName.contains("FireFox")){
		 * driver=new FirefoxDriver(); } else if(browserName.contains("IE")) {
		 * driver=new InternetExplorerDriver(); } driver.manage().window().maximize();
		 * //driver.get(prop.getProperty("URL"));
		 * driver.get("https://uat.bancaedge.com/account/login");
		 */
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	//@AfterSuite
	@AfterTest
	public void afterSuite() {
			ExtentManager.endReport();
	}

}
