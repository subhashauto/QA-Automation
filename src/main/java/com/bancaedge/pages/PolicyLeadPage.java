package com.bancaedge.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class PolicyLeadPage extends BaseClass {

	@FindBy(xpath = "//mat-select[@formcontrolname='insurer']")
	WebElement clickOnInsurerList;
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	WebElement insurerList;

	@FindBy(xpath = "//span[text()=' ICICI Prudential ']")
	WebElement selectICICIPruInsurer;

	@FindBy(xpath = "//mat-select[@formcontrolname='product']")
	WebElement clickOnLOBList;

	@FindBy(xpath = "//span[text()=' Saving Traditional ']")
	WebElement selectSavingTraditionalLOB;

	@FindBy(xpath = "//mat-select[@formcontrolname='productName']")
	WebElement clickOnProductNameList;

	@FindBy(xpath = "//span[text()=' ICICI Pru Future Perfect ']")
	WebElement selectProdICICIPrufuturePerfect;

	@FindBy(xpath = "//mat-select[@formcontrolname='sp']")
	WebElement clickOnSPList;

	@FindBy(xpath = "//span[text()='NAMITA RAHUL']")
	WebElement selectSPNamita;

	@FindBy(xpath = "//mat-select[@formcontrolname='fls']")
	WebElement clickOnFLSList;

	@FindBy(xpath = "//span[text()='SNEHA GUTHE']")
	WebElement selectFLSSneha;

	@FindBy(xpath = "//mat-select[@formcontrolname='lgCode']")
	WebElement clickonLeadGenaratorList;

	@FindBy(xpath = "//span[text()=' KAVITA KISHOR ']")
	WebElement selectLeadGenartorKavita;

	@FindBy(xpath = "//input[@formcontrolname='pt']")
	WebElement enterPT;

	@FindBy(xpath = "//input[@formcontrolname='ppt']")
	WebElement enterPPT;

	@FindBy(xpath = "//mat-select[@formcontrolname='mode']")
	WebElement clickOnModeList;

	@FindBy(xpath = "//span[text()='Annual ']")
	WebElement selectModeAnnual;

	@FindBy(xpath = "//input[@formcontrolname='premiumAmount']")
	WebElement enterTotalPremGST;

	@FindBy(xpath = "//input[@formcontrolname='basePremium']")
	WebElement enterBasePrem;

	@FindBy(xpath = "//span[text()=' Next ']")
	WebElement clickOnNextBtn;
	
	@FindBy(xpath="//span[@class='mat-option-text']")
	WebElement insurerNameList;

	public PolicyLeadPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnInsurerList() {
		CommonMethods.click(getDriver(), clickOnInsurerList);
		//return new ProposerDetailsPage();
		
	}

	public void selectInsurer(String InsurerName) {
		List<WebElement> insurerList=getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		int count=insurerList.size();
		System.out.println("Total number of count" +count);
		for (int i=0;i<insurerList.size();i++) {
			String nameOfInsurer=insurerList.get(i).getText();
			if(nameOfInsurer.contains(InsurerName)) {
				insurerList.get(i).click();
				break;
			
			}
		}

	}

	public void clickOnLOBList() {
		CommonMethods.click(getDriver(), clickOnLOBList);
	}

	public void selectLOB() {
		CommonMethods.click(getDriver(), selectSavingTraditionalLOB);
	}

	public void clickOnProductList() {
		CommonMethods.click(getDriver(), clickOnProductNameList);
	}

	public void selectProduct() {
		CommonMethods.click(getDriver(), selectProdICICIPrufuturePerfect);
	}

	public void clickOnSPList() {
		CommonMethods.click(getDriver(), clickOnSPList);
	}

	public void selectSP() {

	}

	public void clickOnFLSList() {
		CommonMethods.click(getDriver(), clickOnFLSList);
	}

	public void selectFLS() {

	}

	public void clickOnLeadGenaratorList() {
		CommonMethods.click(getDriver(), clickonLeadGenaratorList);
	}

	public void selectLeadGenarator() {
		CommonMethods.click(getDriver(), selectLeadGenartorKavita);
	}

	public void enterPT(String PT) {
		CommonMethods.type(enterPT, PT);

	}

	public void enterPPT(String PPT) {
		CommonMethods.type(enterPPT, PPT);
	}

	public void clickOnModeList() {
		CommonMethods.click(getDriver(), clickOnModeList);
	}

	public void selectMode() {
		CommonMethods.click(getDriver(), selectModeAnnual);
	}

	public void enterTotalPremGST(String TotalPremGST) {
		CommonMethods.type(enterTotalPremGST, TotalPremGST);
	}

	public void enterBasePrem(String BasePrem) {
		CommonMethods.type(enterBasePrem, BasePrem);
	}
	
	public void clickOnNextBtn() {
		CommonMethods.click(getDriver(), clickOnNextBtn);
	}
	
	
	public String getLeadFormURL() {
		String leadformurl=getDriver().getCurrentUrl();
		return leadformurl;
	}
	
	public void verifyInsurerName(String InsurerName) {
		List<WebElement> insurerList=getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
		int count=insurerList.size();
		System.out.println("Total number of count" +count);
		for (int i=0;i<insurerList.size();i++) {
			String nameOfInsurer=insurerList.get(i).getText();
			if(nameOfInsurer.contains(InsurerName)) {
				insurerList.get(i).click();
				break;
			
			}
		}
			
		
	}
}
