package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginToCrmAppTest extends TestBase {
	
	LoginPage logPage;
	HomePage homePage;
		
	public LoginToCrmAppTest() {
		super(); // initialising the super class constructor for testbase class
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		logPage = new LoginPage();  // using loginpage constructor to initialise
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String expectedTitle = "Cogmento CRM";
		String actualTitle = logPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2)
	public void loginToAppTest() {
		homePage = logPage.loginToFreeCrmApp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
}
