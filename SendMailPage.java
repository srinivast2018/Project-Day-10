package com.ibm.groceriespages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMailPage {

	// To lcoate To dropdown field
	@FindBy(xpath = "//select[@name='to']")
	WebElement toEle;

	// To locate Customer E-mail text box
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailEle;

	// To locate Subject text box
	@FindBy(xpath = "//input[@name='subject']")
	WebElement subjectEle;

	/*
	 * To locate message web element
	 * 
	 * @FindBy(xpath="//div[@class='note-editable panel-body']") WebElement
	 * messageEle;
	 */

	// To locate Save button
	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveEle;

	WebDriverWait wait;
	WebDriver driver;

	public SendMailPage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// Method to add email
	public String addMail(String customerEmail, String subject, String message) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// To select the value for dropdown 'To'
		Select toSelect = new Select(toEle);
		toSelect.selectByIndex(2);

		// To enter custormer email
		emailEle.sendKeys(customerEmail);
		// To enter subject
		subjectEle.sendKeys(subject);
		// To enter message
		js.executeScript("document.getElementById('summernote').value='Welcome All'");
		// To click on Save button
		saveEle.click();
		Thread.sleep(1000);
		return driver.getPageSource();
	}

}
