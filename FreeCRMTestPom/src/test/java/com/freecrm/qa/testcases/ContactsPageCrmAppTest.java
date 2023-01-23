package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class ContactsPageCrmAppTest extends TestBase {
	
	
	LoginPage logPage;
	HomePage homePage;
	ContactsPage conPage;
	
	public ContactsPageCrmAppTest() {
		super(); // initialising the super class constructor for testbase class
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		logPage = new LoginPage();  // using loginpage constructor to initialise
		conPage = new ContactsPage();
		homePage = logPage.loginToFreeCrmApp(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(conPage.verifyContactsLabelIsDisplayed(),"Contacts label is missing");
		//Assert.assertEquals(conPage.getContactsLabelText(), null, null);
	}
	
	
	
	

}
