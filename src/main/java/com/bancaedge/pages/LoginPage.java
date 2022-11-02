package com.bancaedge.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class LoginPage extends BaseClass{
	
	//private By loginTitle=By.xpath("//mat-card-title/h2[text()='Login']");
	@FindBy(xpath = "//mat-card-title/h2[text()='Login']")
	WebElement loginTitle;
	
	@FindBy(xpath="//div/input[@formcontrolname='username']")
	WebElement username;
	
	@FindBy(xpath="//div/input[@formcontrolname='password']")
	WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement login_btn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String checkTitle() {
		
		String title=getDriver().getTitle();
		return title;
	}

	public HomePage branchUserLogin(String uname,String pass) {
		CommonMethods.type(username, uname);
		CommonMethods.type(password, pass);
		CommonMethods.click(getDriver(), login_btn);
		
		return new HomePage();
		
	}
	
	
}
