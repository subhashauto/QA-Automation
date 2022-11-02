package com.bancaedge.testcases;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bancaedge.base.BaseClass;
import com.bancaedge.pages.CustomerSearchPage;
import com.bancaedge.pages.HomePage;
import com.bancaedge.pages.LoginPage;

public class HomePageTest extends BaseClass {
	HomePage homepage;
	LoginPage loginpage;
	CustomerSearchPage cusearchpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity","Smoke","Regression"})
public void setup(String browser) throws InterruptedException {
		
		luanchApp(browser);
	}

	@AfterMethod(groups = {"Sanity","Smoke","Regression"})
	public void teardown() throws InterruptedException {
		getDriver().quit();
		//Thread.sleep(2000);

	}
 @Test(groups = "Sanity")
	public void verifyHomePageURL() throws InterruptedException {
		loginpage = new LoginPage();
		homepage = loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		Thread.sleep(1000);
		String URL = homepage.getCurrentURL();
		System.out.println("URL IS: " + URL);
	}

	@Test(groups = {"Sanity","Smoke","Regression"})
	public void validateMySpaceMenu() throws InterruptedException {
		loginpage = new LoginPage();
		homepage = loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		Thread.sleep(3000);
		boolean result = homepage.validateMySpace();
		// Assert.assertTrue(result);
		Assert.assertTrue("My Space Menu Validation Failed: :", result);

	}

	@Test(groups = {"Sanity","Smoke","Regression"})
	public void validatePolicyVaultMenu() throws InterruptedException {
		loginpage = new LoginPage();
		homepage = loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		Thread.sleep(3000);
		boolean result1 = homepage.validatePolicyVault();
		Assert.assertTrue("Policy Vault Menu Validation Failed: :", result1);

	}

	@Test(groups = {"Sanity","Smoke","Regression"})
	public void validateGroupCreditMenu() throws InterruptedException {
		loginpage = new LoginPage();
		homepage = loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		Thread.sleep(3000);
		boolean result2 = homepage.validateGroupCredit();
		Assert.assertTrue("Group Credit  Menu Validation Failed: :", result2);

	}
	@Test(groups = {"Sanity","Smoke"})
	public void validateInvalidCIF() throws InterruptedException {
		loginpage = new LoginPage();
		 homepage=new HomePage();
		homepage=loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		Thread.sleep(3000);
		//cusearchpage=homepage.searchCustomer();
		cusearchpage=homepage.searchCustomer(prop.getProperty("invalidCIF"));
		homepage.submitCustomerSearch();
		Thread.sleep(1000);
		boolean result=homepage.validateCustomer();
		Assert.assertTrue("Customer Not Found Err Msg Validation Failed", result);
		
	}
	@Test(groups = {"Sanity","Smoke"})
	public void validateValidCIF() throws InterruptedException {
		loginpage = new LoginPage();
		 homepage=new HomePage();
		homepage=loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		Thread.sleep(3000);
		//cusearchpage=homepage.searchCustomer();
		cusearchpage=homepage.searchCustomer(prop.getProperty("validCIF"));
		homepage.submitCustomerSearch();
		Thread.sleep(1000);
	}

}
