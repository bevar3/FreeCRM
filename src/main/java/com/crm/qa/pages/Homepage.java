package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase {
	
	@FindBy(xpath = "//div[(text()=\"Contacts activity stream\")]")
	WebElement contactsdash;

}

