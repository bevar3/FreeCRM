package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class LoginPage extends TestBase{
	
	/*
	 * @FindBy(xpath="//img[contains(@class,\"img-responsive\")]") WebElement logo;
	 */
	@FindBy(xpath= "//a[text()='Login']")
	WebElement Login;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement LoginSite;
	
	//init page objects
	public LoginPage() {
		PageFactory.initElements(driver, this); 	
	}
	
	//actions
	
	public String validatelogin() {
		return driver.getTitle();
		
	}
	
	public Homepage login(String un, String pwd) {
		Login.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		LoginSite.click();
		
		return new Homepage();
	}

}
