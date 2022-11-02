package com.bancaedge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class CustomerSearchPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='SUNIL SHRIKRISHNA KULKARNI']")
	WebElement custName;
	
	@FindBy(xpath="//span[text()='Quick Quote']")
	WebElement menuQuickQuote;
	
	@FindBy(xpath = "//span[text()='Create Lead']")
	WebElement menuCreateLead;
	
	
	
	public CustomerSearchPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean custNameCheck() {
		boolean custname=CommonMethods.isDisplayed(getDriver(), custName);
		return custname;
	}
	
	public void selectQuickQuote() {
		CommonMethods.click(getDriver(), menuQuickQuote);
	}
	
	public PolicyLeadPage selectCreateLeadMenu() {
		CommonMethods.click(getDriver(), menuCreateLead);
		return new PolicyLeadPage();
	}

}
