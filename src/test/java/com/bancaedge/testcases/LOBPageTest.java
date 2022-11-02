package com.bancaedge.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bancaedge.base.BaseClass;
import com.bancaedge.pages.CustomerSearchPage;
import com.bancaedge.pages.HomePage;
import com.bancaedge.pages.LOBPage;
import com.bancaedge.pages.LoginPage;

public class LOBPageTest extends BaseClass {
	HomePage homepage;
	LoginPage loginpage;
	CustomerSearchPage cusearchpage;
	LOBPage lobpage;

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
	@Test(groups = {"Sanity","Smoke"})
	public void verifyLOBURL() throws InterruptedException {
		loginpage = new LoginPage();
		 homepage=new HomePage();
		 cusearchpage=new CustomerSearchPage();
		 lobpage=new LOBPage();
		 homepage=loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
			Thread.sleep(2000);			
			cusearchpage=homepage.searchCustomer(prop.getProperty("validCIF"));
			homepage.submitCustomerSearch();
			Thread.sleep(1000);
			cusearchpage.selectQuickQuote();
			String actualURL=lobpage.getLOBURL();
			String expectedURL="https://uat.bancaedge.com/364/quickquote";
			Assert.assertEquals(expectedURL, actualURL);
	}
	
	

}
