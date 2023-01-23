package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class HomePageCrmLinkTest extends TestBase{

	LoginPage logPage;
	HomePage homePage;
	ContactsPage conPage;
	
	public HomePageCrmLinkTest() {
		super(); // initialising the super class constructor for testbase class
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		logPage = new LoginPage();  // using loginpage constructor to initialise
		homePage = logPage.loginToFreeCrmApp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String expectedTitle = "Cogmento CRM";
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Home page title mismatch");
	}
	
	@Test(priority = 2)
	public void verifyUserNameIsDisplayedTest() {
		String usr = homePage.getUserNameDisplay();
		Assert.assertTrue(homePage.verifyUserNameIsDisplayed());
		Assert.assertEquals(usr, prop.getProperty("userdisplay"), "Home page user name mismatch");
	}
	
	//@Test(priority = 2)
	public void verifyUserNameDisplayTextTest() {
		String usr = homePage.getUserNameDisplay();
		Assert.assertEquals(usr, prop.getProperty("userdisplay"), "Home page user name mismatch");
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		conPage = homePage.clickOnContactsLink();
		Assert.assertTrue(conPage.verifyContactsLabelIsDisplayed()); // contact label is displayed
		//Assert.assertEquals(conPage.getContactsLabelText(), null, null);
	}
	
	
	
	
}
