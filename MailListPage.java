package com.ibm.groceriespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailListPage {

	@FindBy(xpath = "//a[@title='Add New']")
	WebElement addnewEle;

	WebDriverWait wait;
	WebDriver driver;

	public MailListPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// Method to add email
	public void clickOnAdd() {
		addnewEle.click();

	}

}
