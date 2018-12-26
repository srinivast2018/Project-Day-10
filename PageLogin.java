package com.ibm.groceriespages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin {
	
	@FindBy(name="email")
	WebElement emailEle;
	
	@FindBy(name="pword")
	WebElement passEle;
	
	//@FindBy(className="btn btn-labeled btn-info m-b-5")
	@FindBy(xpath="//button[@class='btn btn-labeled btn-info m-b-5']")
	WebElement loginEle;
	
	WebDriverWait wait;
	WebDriver driver;
	
	public PageLogin(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	
	//To enter email address
	public void enterEmailAddress(String userName)
	{
		emailEle.sendKeys(userName);
	}
	
	//To enter apssword 
	public void enterPassword(String password)
	{
		passEle.sendKeys(password);
	}
	
	//To click on Login button
	public void clickOnLogin()
	{
		loginEle.click();
		
	}

}
