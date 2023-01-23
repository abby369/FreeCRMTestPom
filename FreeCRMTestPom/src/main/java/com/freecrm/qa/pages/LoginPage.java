package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page factory / object repository (OR)
	
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(@class,'submit button')]")
	WebElement loginBtn;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgetPwd;
	
	// initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// actions
	public String getLoginPageTitle() {
		return driver.getTitle().toString();
	}
	
	public HomePage loginToFreeCrmApp(String usr, String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
	

}
