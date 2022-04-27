package com.crm.qa.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	Homepage homepage;

	public LoginPageTest() {
		super();
	}
	
	

	@BeforeMethod
	public void loginsetup() {
		init();
		loginpage = new LoginPage();
		}
	
	@Test(priority = 1)
	public void validatelogotest() {
		String title = loginpage.validatelogin();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
		
		}
	@Test(priority = 2)
	public void LoginTest() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		}

}
