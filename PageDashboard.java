package com.ibm.groceriespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageDashboard {

	// @FindBy(xpath="//a[@class='material-ripple']")
	@FindBy(xpath = "//a[text()=' Catalog']")
	WebElement catalogEle;

	@FindBy(xpath = "//a[text()=' Products']")
	WebElement productEle;

	By prodElt = By.xpath("//a[text()=' Products']");
	WebDriverWait wait;
	WebDriver driver;

	// Locating elements for Marketing link
	@FindBy(xpath = "//a[text()='  Marketing']")
	WebElement marketEle;

	// Locating Pushnotification link
	@FindBy(xpath = "//a[text()=' Push Notification']")
	WebElement notificatonEle;

	// Locating System link
	@FindBy(xpath = "//a[text()='   System']")
	WebElement systemEle;

	// Locating Returns link
	@FindBy(xpath = "//a[text()='  Returns']")
	// @FindBy(xpath("//a[contains(text(),'Returns')]"))
	WebElement returnsEle;

	// Locating Shipping link
	@FindBy(xpath = "//a[text()='  Shipping']")
	WebElement shippingEle;

	// Locating ShippingLocatons link
	@FindBy(xpath = "//a[text()=' Shipping Locations']")
	WebElement locatoinEle;

	@FindBy(xpath = "//a[text()=' Return Actions']")
	WebElement actionsEle;

	@FindBy(xpath = "//a[text()=' Settings']")
	WebElement settingsEle;

	@FindBy(xpath = "//a[text()=' Mail']")
	WebElement mailEle;

	public PageDashboard(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	// To click on Catalog
	public void clickOnCatalog() {
		catalogEle.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(prodElt));

	}

	// To click on Products
	public void clickOnProducts() {
		productEle.click();

	}

	// To click on Marketing link
	public void clickOnMarketing() {

		marketEle.click();

	}

	// To click on Push Notificatoin link
	public void clickOnPushNotification() {
		notificatonEle.click();

	}

	// TO click on System link
	public void clickOnsystem() {
		systemEle.click();

	}

	// To click on Retuns link
	public void clickOnReturns() {
		driver.findElement(By.partialLinkText("Returns")).click();
		// returnsEle.click();
	}

	// To click on Return actoins link
	public void clickOnRetrunActions()

	{
		actionsEle.click();
	}

	public void clickOnShipping() {
		driver.findElement(By.partialLinkText("Shipping")).click();
		// shippingEle.click();

	}

	public void clickOnShippingLocations() {
		locatoinEle.click();

	}

	// To click on Settings link
	public void clickOnSettings() {
		settingsEle.click();
	}

	public void clickOnMail() {
		mailEle.click();
	}

}
