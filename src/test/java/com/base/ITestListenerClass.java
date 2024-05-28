package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ITestListenerClass extends Base implements ITestListener {
	// Create an instance of the MethodsForClasses class
	MethodsForClasses obj = new MethodsForClasses();

	// This method is invoked when a TestNG test suite starts
	@Override
	public void onStart(ITestContext context) {
		// Check if there are any passed tests in the test context
		if (context.getPassedTests() != null) {
			// Print the name of the test context
			System.out.println((context.getName()));
			// Print a message indicating that the onStart method is invoked
			System.out.println("On Start method invoked....");
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// This method is invoked when the TestNG test suite finishes
		System.out.println("On Finished method invoked....");

		// Set the extent report
		//obj.setExtent();
		extenTest.info("on finished method");
		// Flush the extent report
		extent.flush(); // Use extent from GalenBase
		driver.close();
		try {
			// Open the generated extent report in the default web browser
			Desktop.getDesktop().browse(new File("TestResults/Extent.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// This method is invoked when a test case starts
		//extenTest = extent.createTest(result.getName()).assignCategory("CssProperties").assignDevice("Chrome");
		//extenTest.info("Name of the started test : " + result.getName());
		System.out.println((result.getName()));
		System.out.println("On TestStart method invoked....");

		// Capture a snapshot of the test case at the start
		//obj.SnapshotPass(driver, result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// This method is invoked when a test case passes
		extenTest.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
		System.out.println("Name of the test method Passed" + result.getName());

		// Capture a snapshot of the test case on success
		obj.SnapshotPass(driver, result.getName());

		// Attach the captured screenshot to the extent report
		extenTest.pass(result.getName() + " is verified", MediaEntityBuilder
				.createScreenCaptureFromPath("./ScreenShotsPassCase/" + result.getName() + ".png").build());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// This method is invoked when a test case fails
		System.out.println("Name of test method failed:" + result.getName());

		// Log the failure in the extent report
		extenTest.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
		extenTest.fail(result.getThrowable());

		// Capture a snapshot of the test case on failure
		obj.SnapshotFail(driver, result.getName());

		// Attach the captured screenshot to the extent report
		extenTest.fail(result.getName() + " is not verified", MediaEntityBuilder
				.createScreenCaptureFromPath("./ScreenShotsFailCase/" + result.getName() + ".png").build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// This method is invoked when a test case is skipped
		ITestListener.super.onTestSkipped(result);
	}
}
