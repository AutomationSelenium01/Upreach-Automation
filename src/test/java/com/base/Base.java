package com.base;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static WebDriver driver;
	public static EdgeOptions options;
	public static String specFilePath;// Spec File Path
	public static String URL;
	public static ExtentTest extenTest;
	public static MethodsForClasses obj = new MethodsForClasses();// Create obj for MEthodsForClasses

	@BeforeSuite
	public void preConditionSetUp() throws Exception {

		// SetUp Chrome driver
		WebDriverManager.edgedriver().setup();
		// Creating an instance of the ChromeOptions class
		options = new EdgeOptions();
		// allows remote origins to access the browser
		options.addArguments("--remote-allow-origins=*");
		// options.addArguments("--headless");
		// Creating an instance of the ChromeDriver class
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// allows creation of tests, nodes, events and assignment of tags, devices,
		// authors, environment values
		extent = new ExtentReports();
		// Extent html Reporter
		spark = new ExtentSparkReporter("./TestResults/" + "Extent.html");
		// Change some configuration
		spark.config().setDocumentTitle("Upreach Report");
		spark.config().setReportName("Upreach Report");
		extent.attachReporter(spark);
		URL = "https://qa-enki.upreach.org.uk/login";
		String[] EligibilityRequirements = {
				"Eligibility Requirements:, Over 18, Attended UK state schools (only) since age 11 (or since age 14 if you were educated abroad before then), At least BBB at A-Level or equivalent (including Access to Higher Education courses) UCAS tariff, At least C in GCSE Maths and English, Household income below £42,620, Not studying social work or an NHS funded course (e.g. Nursing)" };

		String[] smnEligibilityRequirements2 = {
				"E, 1, Anglia Ruskin University, Cambridge, Completed, 2, A Level - NW64AA , GCSE Level - NW64AB, NIL, Male, SOCIAL MOBILITY NETWORK SOCIAL MOBILITY NETWORK, asdfghjk@ac.uk, asdfghjk@ac.uk, 09999999999" };

		// URL = "https://staging.web.platform.urbansdk.com/sign-in";
	}

}
