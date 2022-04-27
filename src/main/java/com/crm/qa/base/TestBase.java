package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){

		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("D:\\Automation\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fp);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void init() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("firefox")) {
			String driverPath =  "C:\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Timeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.wait));
		
		driver.get(prop.getProperty("url"));  
	}

}
