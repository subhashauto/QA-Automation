package com.bancaedge.pages;

import org.openqa.selenium.support.PageFactory;

import com.bancaedge.base.BaseClass;

public class ContactDtlsPage extends BaseClass {
	
	public ContactDtlsPage() {
		PageFactory.initElements(getDriver(),this);
	}

}
