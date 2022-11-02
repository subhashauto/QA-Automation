package com.bancaedge.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;

public class ContactInfoPage extends BaseClass {

	public ContactInfoPage() {
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "//div[text()='Yes']")
	WebElement selectMailingAddr;
	@FindBy(xpath = "//input[@formcontrolname='policyaddressline1']")
	WebElement enterAddrLine1;
	@FindBy(xpath = "//input[@formcontrolname='policyaddressline2']")
	WebElement enterAddrLine2;
	@FindBy(xpath = "//input[@formcontrolname='policyaddressline3']")
	WebElement enterAddrLine3;
	@FindBy(xpath = "//span[text()=' Next ']")
	WebElement clickOnNextBtn;

	public void selectMailingAddr() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> select_address = getDriver().findElements(By.xpath("//div[text()='Yes']"));
		select_address.get(1).click();

	}

	public void fill_address_lines() {
		

	}

	public void clickOnNextBtn() {
		List<WebElement> next_btn = getDriver().findElements(By.xpath("//span[text()=' Next ']"));
		next_btn.get(2).click();

	}

}
