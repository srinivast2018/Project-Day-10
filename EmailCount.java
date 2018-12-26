package com.ibm.groceries;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.ibm.groceriespages.MailListPage;
import com.ibm.groceriespages.PageDashboard;
import com.ibm.groceriespages.PageLogin;
import com.ibm.groceriespages.SendMailPage;
import com.ibm.initialization.WebDriverLaunch;
import com.ibm.utilities.DatabaseConnection;
import com.ibm.utilities.GetScreenshot;

public class EmailCount extends WebDriverLaunch {

	@Test(priority = 1, testName = "VerifyEmailCount", groups = "low")

	public void verifyEmailCountDbase() throws IOException, InterruptedException, SQLException {
		String url = data.get("url");
		String userName = data.get("username");
		String password = data.get("password");
		String email = data.get("customerEmail");
		String subject = data.get("subject");
		String message = data.get("message");
		String expMessage = data.get("emailMessage");
		String query = "select count(mail_id) from as_mail";
		String beforemsg = data.get("beforeMsg");
		String afterMsg = data.get("afterMsg");

		DatabaseConnection dbaseutil = new DatabaseConnection();
		// Verifying the email count from database before adding email
		int emailCountBefore = dbaseutil.countRecords(query);
		System.out.println(beforemsg + emailCountBefore);
		// Launching the web site for atozgroceries
		driver.get(url);
		GetScreenshot screen = new GetScreenshot();

		PageLogin login = new PageLogin(driver, wait);
		// To enter email address and password and clickon login button
		login.enterEmailAddress(userName);
		login.enterPassword(password);
		screen.takeScreenshot(driver);
		login.clickOnLogin();
		Assert.assertTrue(driver.findElement(By.partialLinkText("Logout")).isDisplayed());

		PageDashboard dashboard = new PageDashboard(driver, wait);
		// To click on Catalog
		dashboard.clickOnMarketing();

		// To click on Mail link
		dashboard.clickOnMail();
		screen.takeScreenshot(driver);

		MailListPage maillistObj = new MailListPage(driver, wait);
		// Calling method to click on Add email button
		maillistObj.clickOnAdd();
		screen.takeScreenshot(driver);
		// Calling method to add email
		SendMailPage addemailObj = new SendMailPage(driver, wait);
		String pageSource = addemailObj.addMail(email, subject, message);

		screen.takeScreenshot(driver);
		if (pageSource.contains(expMessage)) {
			Reporter.log(expMessage);

			// checking whether success message is displayed or not
			Assert.assertTrue(pageSource.contains(expMessage));

			// Checking whether added email record is displayed or not
			Assert.assertTrue(pageSource.contains(subject));

			// Verifying the email count from database after adding email
			int emailCountAfter = dbaseutil.countRecords(query);
			System.out.println(afterMsg + emailCountAfter);
			Assert.assertEquals(emailCountAfter, emailCountBefore + 1);
		}

	}
}
