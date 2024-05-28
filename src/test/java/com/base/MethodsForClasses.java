package com.base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutObject;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.reports.model.LayoutSection;
import com.galenframework.reports.model.LayoutSpec;

public class MethodsForClasses extends Base {

	/**
	 * Capture a screenshot for a failed test case
	 */
	public void SnapshotFail(WebDriver driver, String screenshotName) {
		// Create an instance to capture screenshots
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture the screenshot as a file
		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			// Define the destination file path for the screenshot
			File des = new File("./TestResults/ScreenShotsFailCase/" + screenshotName + ".png");

			// Copy the captured screenshot to the destination path
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// Handle any IOException that might occur during file copying
			e.getMessage();
		}
	}

	/**
	 * Capture a screenshot for a passed test case
	 */
	public void SnapshotPass(WebDriver driver, String screenshotName) {

		// Create an instance to capture screenshots using WebDriver
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture the screenshot as a file
		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			// Define the destination file path for the screenshot
			File des = new File("./TestResults/ScreenShotsPassCase/" + screenshotName + ".png");

			// Copy the captured screenshot to the destination path
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// Handle any IOException that might occur during file copying (e.g., log or
			// print the error)
			e.getMessage();
		}
	
	}
		
		
		public void setExtent() {
				// Iterate through the list of layout reports
							// name
							extenTest = extent.createTest("upreach","upreach");
			}
		 
		
	/**
	 * Attach Galen Report Results to Extent Report
	 */
}