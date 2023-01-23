package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//div[text() = 'Contacts']")
	WebElement contactsLabel;
	
	@FindBy(linkText = "Create")
	WebElement createContact;
	
	
	
//---------------------------------------------------------------------------
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabelIsDisplayed() {
		return contactsLabel.isDisplayed();
	}
	
	public String getContactsLabelText() {
		return contactsLabel.getText();
	}
	
	public void createContactButton() {
		createContact.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
