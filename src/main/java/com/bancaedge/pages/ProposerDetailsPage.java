package com.bancaedge.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class ProposerDetailsPage extends BaseClass {

	public ProposerDetailsPage() {
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "//mat-select[@formcontrolname='title']")
	WebElement clickOnTitle;

	@FindBy(xpath = "//span[text()='Mr. ']")
	WebElement selectTitleMr;

	@FindBy(xpath = "//mat-select[@formcontrolname='maritalStatus']")
	WebElement clickOnMaritalStatus;

	@FindBy(xpath = "//span[text()='Married ']")
	WebElement SelectMarriedStatus;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement enterEmailID;

	@FindBy(xpath = "//input[@formcontrolname='panNo']")
	WebElement enterPAN;

	@FindBy(xpath = "//span[text()=' Next ']")
	WebElement clickOnNextBtn;

	public void clickOnTitle() {
		CommonMethods.click(getDriver(), clickOnTitle);

	}

	public void selectTitleMr() {
		CommonMethods.click(getDriver(), selectTitleMr);
	}

	public void clickOnMarritalStatus() {
		CommonMethods.click(getDriver(), clickOnMaritalStatus);
	}

	public void selectMarritalStatusMarried() {
		CommonMethods.click(getDriver(), SelectMarriedStatus);
	}

	public void enterEmailID(String EmailID) {
		CommonMethods.type(enterEmailID, EmailID);
	}

	public void enterPAN(String PAN) {
		CommonMethods.type(enterPAN, PAN);
	}

	public void clickOnNextBtn() {		
		List<WebElement> next = getDriver().findElements(By.xpath("//span[text()=' Next ']"));
		next.get(1).click();
	}
}
