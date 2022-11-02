package com.bancaedge.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bancaedge.base.BaseClass;
import com.bancaedge.pages.HomePage;
import com.bancaedge.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity","Smoke","Regression"})
public void setup(String browser) throws InterruptedException {
		
		luanchApp(browser);
	}

	@AfterMethod(groups = {"Sanity","Smoke","Regression"})
	public void teardown() {
		getDriver().quit();

	}

	@Test(priority = 0,groups = {"Sanity","Smoke"})
	public void verifyTitle() {
		loginpage = new LoginPage();
		// boolean result = loginpage.checkTitleLogin();
		String actual_title = loginpage.checkTitle();
		Assert.assertEquals(actual_title, "BancaEdge");
		// Assert.assertTrue(result);
	}

	@Test(priority = 1,groups = {"Sanity","Smoke","Regression"})
	public void verifyLogin() throws InterruptedException {
		loginpage = new LoginPage();
		homepage = loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		//Thread.sleep(1000);		
		String actualURL = homepage.getCurrentURL();
		String expectedURL = "https://uat.bancaedge.com/mycustomers";
		Assert.assertEquals(actualURL, expectedURL);

	}
}
