package com.bancaedge.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bancaedge.base.BaseClass;
import com.bancaedge.pages.ContactInfoPage;
import com.bancaedge.pages.CustomerSearchPage;
import com.bancaedge.pages.HomePage;
import com.bancaedge.pages.LoginPage;
import com.bancaedge.pages.PolicyLeadPage;
import com.bancaedge.pages.ProposerDetailsPage;

public class ContactInfoPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	CustomerSearchPage cusearchpage;
	PolicyLeadPage policyleadpage;
	ProposerDetailsPage proposerdtlspage;
	ContactInfoPage contactinfopage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity","Smoke","Regression"})
public void setup(String browser) throws InterruptedException {
		
		luanchApp(browser);
	}

	//@AfterMethod(groups = {"Sanity","Smoke","Regression"})
	public void teardown() {
		getDriver().quit();

	}
	
	@Test(groups = {"Sanity","Smoke","Regression"})
	public void checkAllfieldDisplayed() throws InterruptedException {
		loginpage = new LoginPage();
		proposerdtlspage=new ProposerDetailsPage();
		contactinfopage=new ContactInfoPage();
		homepage = loginpage.branchUserLogin(prop.getProperty("userid"), prop.getProperty("password"));
		cusearchpage=homepage.searchCustomer(prop.getProperty("validCIF"));
		homepage.submitCustomerSearch();
		Thread.sleep(2000);
		policyleadpage=cusearchpage.selectCreateLeadMenu();
		Thread.sleep(2000);
		policyleadpage.clickOnInsurerList();
		Thread.sleep(1000);
		policyleadpage.selectInsurer(prop.getProperty("InsurerName"));
		Thread.sleep(1000);
		policyleadpage.clickOnLOBList();
		Thread.sleep(1000);
		policyleadpage.selectLOB();
		Thread.sleep(2000);
		policyleadpage.clickOnProductList();
		policyleadpage.selectProduct();
		Thread.sleep(1000);
		policyleadpage.clickOnLeadGenaratorList();
		Thread.sleep(1000);
		policyleadpage.selectLeadGenarator();
		policyleadpage.enterPT(prop.getProperty("PT"));
		policyleadpage.enterPPT(prop.getProperty("PPT"));
		policyleadpage.enterTotalPremGST(prop.getProperty("TotalPremGST"));
		policyleadpage.enterBasePrem(prop.getProperty("BasePrem"));
		policyleadpage.clickOnNextBtn();
		Thread.sleep(1000);
		proposerdtlspage.clickOnTitle();
		proposerdtlspage.selectTitleMr();
		proposerdtlspage.clickOnMarritalStatus();
		proposerdtlspage.selectMarritalStatusMarried();
		proposerdtlspage.enterEmailID(prop.getProperty("EmailID"));
		proposerdtlspage.enterPAN(prop.getProperty("PAN"));
		Thread.sleep(1000);
		proposerdtlspage.clickOnNextBtn();
		Thread.sleep(1000);
		contactinfopage.selectMailingAddr();
		contactinfopage.clickOnNextBtn();
	}

}
