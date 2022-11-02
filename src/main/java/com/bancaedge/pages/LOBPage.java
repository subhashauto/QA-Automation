package com.bancaedge.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class LOBPage extends BaseClass {

	@FindBy(xpath = "//div//img[@src='../../../assets/images/Health_Hospi_ICON.svg']")
	WebElement lobHealth;
	
	public LOBPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectLOBHealth() {
		CommonMethods.click(getDriver(), lobHealth);
	}
	
	public String getLOBURL() {
		String url=getDriver().getCurrentUrl();
		return url;
	}

}
