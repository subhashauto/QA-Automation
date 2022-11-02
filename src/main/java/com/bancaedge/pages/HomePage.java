package com.bancaedge.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[text()='My Space']")
	WebElement menuMySpace;

	@FindBy(xpath = "//span[text()=' Policy Vault ']")
	WebElement menuPolicyVault;

	@FindBy(xpath = "//span[text()=' Group Credit ']")
	WebElement menuGroupCredit;

	@FindBy(xpath = "//button[text()=' Sign Out ']")
	WebElement userSignOut;

	@FindBy(xpath = "//div/input[@id='mat-input-2']")
	WebElement customersearch;

	@FindBy(xpath = "//span[text()=' Submit ']")
	WebElement submitcustsearch;

	@FindBy(xpath = "//div[text()='Customer not Found']")
	WebElement errormsg_cusearch;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateMySpace() {
		return CommonMethods.isDisplayed(getDriver(), menuMySpace);

	}

	public void validateQuickQuote() {

	}

	public boolean validatePolicyVault() {
		return CommonMethods.isDisplayed(getDriver(), menuPolicyVault);

	}

	public boolean validateGroupCredit() {
		return CommonMethods.isDisplayed(getDriver(), menuGroupCredit);

	}

	public String getCurrentURL() {
		WebDriverWait w=new WebDriverWait(getDriver(), 5);
		w.until(ExpectedConditions.visibilityOf(menuMySpace));
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}

	public CustomerSearchPage searchCustomer(String cif) {
		CommonMethods.type(customersearch, cif);
		// driver.findElement((By) customersearch).sendKeys("12458877");
		// CommonMethods.click(driver, submitcustsearch);
		return new CustomerSearchPage();

	}

	public boolean validateCustomer() {
		boolean validatErrMsg = CommonMethods.isDisplayed(getDriver(), errormsg_cusearch);
		return validatErrMsg;

	}

	public void submitCustomerSearch() {
		CommonMethods.click(getDriver(), submitcustsearch);
	}
	
	public void are_Element_Displayed_OnHomePage() {
		//WebElement[] ListofwebElement= { getDriver().findElement(By.xpath("//span[text()=' Group Credit ']")),getDriver().findElement(By.xpath("//span[text()=' Policy Vault ']")) }
	}

}
