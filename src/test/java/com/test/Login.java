package com.test;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.Base;

public class Login extends Base {

	SoftAssert softAssert = new SoftAssert();
	private static final Logger logger = LogManager.getLogger(Login.class);
	String[] EligibilityRequirements = {
			"Eligibility Requirements:, Over 18, Attended UK state schools (only) since age 11 (or since age 14 if you were educated abroad before then), At least BBB at A-Level or equivalent (including Access to Higher Education courses) UCAS tariff, At least C in GCSE Maths and English, Household income below £42,620, Not studying social work or an NHS funded course (e.g. Nursing)" };

	String[] smnEligibilityRequirements2 = {
			"E, 1, Anglia Ruskin University, Cambridge, Completed, 2, A Level - NW64AA , GCSE Level - NW64AB, NIL, Male, SOCIAL MOBILITY NETWORK SOCIAL MOBILITY NETWORK, asdfghjk@ac.uk, asdfghjk@ac.uk, 09999999999" };

	String[] manualEligibilityRequirements = {
			"D, D, Anglia Ruskin University, Cambridge, Completed, 2, A Level - NW64AA , GCSE Level - NW64AA, JLC_ARGENT, Male, 41, 168, nareen kumar, nareen@ac.uk, 09999999999" };

	@Test(priority = 1, testName = "loginPage")
	public void loginPage() throws Exception {
		extenTest = extent.createTest("login");
		extenTest.info("Login verification");

		// Navigate to theURL
		driver.get(URL);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='username']")).click();
		// Enter UserName
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("adam@mydomain.com");
		driver.findElement(By.xpath("//input[@id='password']")).click();
		// Enter Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("upReach@user123456789012");
		// Check the Layout for the LoginPage
		// Click on LogIn
		driver.findElement(By.id("login-button")).click();
		logger.info("Login successfull");
		driver.findElement(By.xpath(
				"//ul[@class='nav nav-list enki-sidebar']//a[@class='tree-toggle nav-header'][normalize-space()='Associate Pipeline']"))
				.click();
		driver.findElement(By.xpath(
				"//ul[@class='nav nav-list enki-sidebar']//li[@class='ripple']//ul[@class='nav nav-list tree']//li//a[normalize-space()='Manual Sifting']"))
				.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='pr_id_1_header_0']")).click();

		extenTest.pass("fdg");
		// Locating the web element

		System.out.println(new WebDriverWait(driver, 20)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
						"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)")))
				.getText());

		String text = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)"))
				.getText();

		String[] header = {
				"Please review the following applications to check they meet our eligibility requirements" };
		softAssert.assertEquals(text,
				"Please review the following applications to check they meet our eligibility requirements");

		if (text.equals(header)) {
			extenTest.info("test passed");
			obj.SnapshotPass(driver, "Text matches");
			logger.info("verification of Header text passed");

		} else {
			extenTest.info("test failed");
			obj.SnapshotFail(driver, "screenshot");
			extenTest.fail("login" + " is verified", MediaEntityBuilder
					.createScreenCaptureFromPath("./ScreenShotsFailCase/" + "screenshot" + ".png").build());
		}

		String text2 = driver.findElement(By.cssSelector(".pb-4.sub-tab-title")).getText();

		String text3 = driver.findElement(By.cssSelector("li:nth-child(1) p:nth-child(1)")).getText();

		String text4 = driver.findElement(By.cssSelector("li:nth-child(3) p:nth-child(1)")).getText();

		String text5 = driver.findElement(By.cssSelector("li:nth-child(4) p:nth-child(1)")).getText();

		String text6 = driver.findElement(By.cssSelector("li:nth-child(5) p:nth-child(1)")).getText();

		String text7 = driver.findElement(By.cssSelector("li:nth-child(6) p:nth-child(1)")).getText();

		String text8 = driver.findElement(By.cssSelector("li:nth-child(7) p:nth-child(1)")).getText();

		String[] EligibilityRequirements1 = new String[] { text2, text3, text4, text5, text6, text7, text8 };

		String el1 = (Arrays.toString(EligibilityRequirements1));

		String el2 = (Arrays.toString(EligibilityRequirements));

		softAssert.assertEquals(el1, el2);

		if (el1.equals(el2)) {

			extenTest.info("True string");
			logger.info("verification of manual shifting instruction passed");
			obj.SnapshotPass(driver, "True string");
			extenTest.pass("login" + " is verified", MediaEntityBuilder
					.createScreenCaptureFromPath("./ScreenShotsPassCase/" + "True string" + ".png").build());

		} else {

			extenTest.info("false string");
			obj.SnapshotFail(driver, "false string");
			extenTest.fail("login" + " is verified", MediaEntityBuilder
					.createScreenCaptureFromPath("./ScreenShotsPassCase/" + "false string" + ".png").build());

		}

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@id='pr_id_1_header_0']")).click();
		// search function
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("nareen");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='pi pi-search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='fa fa-eye']")).click();
		Thread.sleep(2000);

		String manualInfoTextCheck1 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]"))
				.getText();

		String manualinfoTextCheck2 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]"))
				.getText();

		String manualinfoTextCheck3 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/table[2]/tbody[1]/tr[1]/td[2]"))
				.getText();

		String manualinfoTextCheck4 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/table[2]/tbody[1]/tr[2]/td[2]"))
				.getText();

		String manualinfoTextCheck5 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/table[2]/tbody[1]/tr[3]/td[2]"))
				.getText();

		String manualinfoTextCheck6 = driver.findElement(By.xpath("//td[contains(text(),'A Level - NW64AA')]"))
				.getText();

		String manualinfoTextCheck7 = driver.findElement(By.xpath("//td[normalize-space()='JLC_ARGENT']")).getText();

		String manualinfoTextCheck8 = driver.findElement(By.xpath("//td[normalize-space()='Male']")).getText();

		String manualinfoTextCheck9 = driver.findElement(By.xpath("//td[normalize-space()='41']")).getText();

		String manualinfoTextCheck10 = driver.findElement(By.xpath("//td[normalize-space()='168']")).getText();

		String manualinfoTextCheck11 = driver.findElement(By.xpath("//td[normalize-space()='nareen kumar']")).getText();

		String manualinfoTextCheck12 = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/table[3]/tbody[1]/tr[2]/td[2]"))
				.getText();

		String manualinfoTextCheck13 = driver.findElement(By.xpath("//td[normalize-space()='09999999999']")).getText();

		String[] manualEligibilityRequirements1 = new String[] { manualInfoTextCheck1, manualinfoTextCheck2,
				manualinfoTextCheck3, manualinfoTextCheck4, manualinfoTextCheck5, manualinfoTextCheck6,
				manualinfoTextCheck7, manualinfoTextCheck8, manualinfoTextCheck9, manualinfoTextCheck10,
				manualinfoTextCheck11, manualinfoTextCheck12, manualinfoTextCheck13 };

		String ml1 = (Arrays.toString(manualEligibilityRequirements1));

		String ml2 = (Arrays.toString(manualEligibilityRequirements));

		softAssert.assertEquals(ml1, ml2);

		if (ml1.equals(ml2)) {

			extenTest.info("True string manual check");
			logger.info("verification of  upreach associate info passed");
			obj.SnapshotPass(driver, "True string manual check");
			extenTest.pass("login" + " is verified",
					MediaEntityBuilder
							.createScreenCaptureFromPath("./ScreenShotsPassCase/" + "True string manual check" + ".png")
							.build());

		} else {
			System.out.println("false string manual check");
			extenTest.info("false string manual check");
			obj.SnapshotFail(driver, "false string manual check");
			extenTest.fail("login" + " is verified", MediaEntityBuilder
					.createScreenCaptureFromPath("./ScreenShotsPassCase/" + "false string manual check" + ".png")
					.build());

		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();

	}

	@Test(priority = 2, testName = "Manual shifting upreach programme email")
	public void Manualemail() throws Exception {
		extenTest = extent.createTest("manual Shifting upreach programme email");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@value='SMN']//span[@class='p-inputswitch-slider']")).click();
		driver.findElement(By.xpath("//button[@title='Manual Mail']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//form[@class='cmxform mb-0']//input[@value='Submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);

		driver.findElement(By.xpath("//form[@class='cmxform mb-0']//input[@value='Submit']")).click();
		Thread.sleep(3000);
		String successMessage = driver.findElement(By.xpath("//*[@id=\"manualShiftingListingPage\"]/div[1]")).getText();
		System.out.println(successMessage);

		if (successMessage.equals("Mail sent successfully")) {
			extenTest.info("Mail sent successfully");
			logger.info("Mail sent successfully for upreach programming passed");
			obj.SnapshotPass(driver, "Mail sent successfully for upreach programming");
			extenTest.pass("email verification" + " is verified",
					MediaEntityBuilder.createScreenCaptureFromPath(
							"./ScreenShotsPassCase/" + "Mail sent successfully for upreach programming nareen" + ".png")
							.build());
			logger.info("Mail sent successfully for upreach programming passed");
			System.out.println("Pass :" + successMessage);
		} else {
			extenTest.info("Mail not sent");
			obj.SnapshotPass(driver, "Mail not sent for upreach programming");

			extenTest.pass("email verification" + " is failed",
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									"./ScreenShotsPassCase/" + "Mail not sent for upreach programming" + ".png")
							.build());
		}
		Thread.sleep(3000);

		// then store all results which are

	}

	@Test(priority = 3, testName = "manual shifting upreach programmes decissions")
	public void upreach_programmes_decissions() throws Exception {

		extenTest = extent.createTest("manual shifting upreach programmes decissions");
		extenTest.info("upreach programmes decissions");
		driver.findElement(By.xpath("//tr[@draggable='false']//span[@class='fa fa-exchange']")).click();
		Thread.sleep(2000); //
		driver.findElement(By.xpath("//select[@id='decision']")).click();
		Thread.sleep(2000);
		WebElement developers_dropdown = driver.findElement(By.xpath("//select[@id='decision']"));
		Select objSelect = new Select(developers_dropdown);
		objSelect.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@id='manual-sifting-decision-form mb-0']//button[@type='button'][normalize-space()='Close']"))
				.click();
		Thread.sleep(2000);
		logger.info("decision for upreach programming passed");
	}

	@Test(priority = 4, testName = "smn associate info check")
	public void SMN() throws Exception {

		extenTest = extent.createTest("SMN manual shifting");
		driver.findElement(By.xpath("//div[@value='SMN']//span[@class='p-inputswitch-slider']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("social");
		System.out.println("before eye icon");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='fa fa-eye']")).click();
		System.out.println("eye button clicked for smn");
		Thread.sleep(2000);
		String smna = driver
				.findElement(By.xpath("//*[@id=\"manual-sifting-modal\"]/div/div/div[2]/table[1]/tbody/tr[1]/td[2]"))
				.getText();

		String smnb = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"))
				.getText();

		String smnc = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"))
				.getText();

		String smnd = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"))
				.getText();

		String smne = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"))
				.getText();

		String smnf = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(4) > td:nth-child(2)"))
				.getText();

		String smng = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"))
				.getText();

		String smnh = driver.findElement(By.cssSelector("tbody tr:nth-child(6) td:nth-child(2)")).getText();

		String smni = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)"))
				.getText();

		String smnj = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2)"))
				.getText();

		String smnk = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(2)"))
				.getText();

		String smnl = driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(23) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(2)"))
				.getText();

		String[] smnEligibilityRequirements1 = new String[] { smna, smnb, smnc, smnd, smne, smnf, smng, smnh, smni,
				smnj, smnk, smnl };

		String sl1 = (Arrays.toString(smnEligibilityRequirements1).trim());

		String sl2 = (Arrays.toString(smnEligibilityRequirements2).trim());

		if (sl1.equals(sl2)) {

			extenTest.info("smn associate info string check passed");
			obj.SnapshotPass(driver, "smn True string");
			logger.info("Smn associate info passed");
			extenTest.pass("smn text verification" + " is verified", MediaEntityBuilder
					.createScreenCaptureFromPath("./ScreenShotsPassCase/" + "smn True string" + ".png").build());

		} else {
			System.out.println("smn false string");
			extenTest.info("smn associate info string check failed");
			obj.SnapshotFail(driver, "false string");
			extenTest.fail("smn text verification" + " is verified", MediaEntityBuilder
					.createScreenCaptureFromPath("./ScreenShotsPassCase/" + "smn false string" + ".png").build());

		}

		/*
		 * 
		 * Thread.sleep(2000); String successMessage =
		 * driver.findElement(By.xpath("//div[@class='alert alert-success p-10']")).
		 * getText(); String failureMessage = driver.findElement(By.
		 * xpath("//form[@class='cmxform mb-0']//div[@class='alert alert-danger']")).
		 * getText();
		 * 
		 * System.out.println(successMessage); if
		 * (successMessage.equals("Mail sent successfully")) {
		 * System.out.println("Pass :" + successMessage); } else {
		 * System.out.println(failureMessage); logger.info("error message---" +
		 * failureMessage); } Thread.sleep(2000);
		 * 
		 * System.out.println(successMessage);
		 */

		// div[@class='alert alert-success p-10']
	}

	@Test(priority = 5, testName = "SMN programme decision")
	public void SMN_programme_decision() throws Exception {
		extenTest = extent.createTest("SMN programme decision");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tr[@draggable='false']//span[@class='fa fa-exchange']")).click();
		Thread.sleep(2000);
		WebElement developers_dropdown = driver.findElement(By.xpath("//select[@id='decision']"));
		Select objSelect = new Select(developers_dropdown);
		objSelect.selectByIndex(2);

		WebElement developers_dropdown2 = driver.findElement(By.xpath("//select[@id='reason']"));
		Select objSelect2 = new Select(developers_dropdown2);
		objSelect2.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div[id='manual-sifting-decision-form mb-0'] div[class='modal-footer'] button[type='button']")).click();

		logger.info("Smn associate programme decision passed");

	}

}
