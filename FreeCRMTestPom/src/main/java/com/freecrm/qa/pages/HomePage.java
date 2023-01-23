package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(className = "user-display")
	WebElement userNameLabel;
	
//-------------contacts link--------------	
	@FindBy(xpath = "//i[contains(@class,'users icon')]")
	WebElement contactsIcon;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
//------------deals link-------------------
	@FindBy(xpath = "//i[contains(@class,'money icon')]")
	WebElement dealsIcon;
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
//------------tasks link-------------------
	@FindBy(xpath = "//i[contains(@class,'tasks icon')]")
	WebElement tasksIcon;
		
	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	// initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		return driver.getTitle().toString();
	}
	
	public boolean verifyUserNameIsDisplayed() {
		return userNameLabel.isDisplayed();
	}
	
	public String getUserNameDisplay() {
		return userNameLabel.getText();
	}
	
	public ContactsPage clickOnContactsLink() {
		Actions builder = new Actions(driver);
	    //WebElement contact = driver.findElement(By.xpath("//i[contains(@class,'users icon')]"));
		builder.moveToElement(contactsIcon).build().perform();
		//driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		Actions builder = new Actions(driver);
		builder.moveToElement(dealsIcon).build().perform();
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		Actions builder = new Actions(driver);
	    builder.moveToElement(tasksIcon).build().perform();
	    tasksLink.click();
		return new TasksPage();
	}
	
		
	
	
	
	
	
	
	
	
	
	

}
