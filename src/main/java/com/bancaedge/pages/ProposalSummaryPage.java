package com.bancaedge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class ProposalSummaryPage extends BaseClass{
	public ProposalSummaryPage() {
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "//span[text()=' Submit ']")
	WebElement clickOnPropSubmitBtn;
	
	@FindBy(xpath = "//input[@formcontrolname='otp']")
	WebElement enterCustOTP;
	
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement clickOnCustOTPSubmitBtn;
	
	public void clickOnPropSubBtn() {
		CommonMethods.click(getDriver(), clickOnPropSubmitBtn);
		
	}
	
	public void enterCustomerConsentOTP(String OTP) {
		CommonMethods.type(enterCustOTP, OTP);
	}
	
	public void clickOnCustOTPSubBtn() {
		CommonMethods.click(getDriver(), clickOnCustOTPSubmitBtn);
		
	}

}

