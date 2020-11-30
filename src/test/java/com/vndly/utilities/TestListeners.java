package com.vndly.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.vndly.PageObjects.BaseTest;// Import the path of the class listener


public class TestListeners implements ITestListener {
	//In that scenario, we should create a BaseTest Class and then use that.
	//All Test Classes should inherit BaseTest Class.

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Success</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);

	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color = red >Exception occured, click to see details:"
				+ "<font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>\n");

		// Take Screen shot of results test
         WebDriver driver = ((BaseTest)result.getInstance()).driver; // replace this line with baseclass
		String path = takeScreenshot(driver,result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font color=red>" + "ScreenShot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (IOException e) {
			extentTest.get().fail("Test Failed, can not attach screenshot");
		}

		String logText = "<b>Test Method " + methodName + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}

	}

	public String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("*****************************");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("*****************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replaceAll(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

}
