package com.vndly.utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {

		// In BeforeClass create a Extents report instance Set extents Reports
		// Configuration
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("Automation Reports");

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "VNDLY");
		extent.setSystemInfo("Organization", "Ablaye Thiam");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);

		return extent;
	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "VRDLY_TestReports" + "_" + d.toString().replaceAll(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

}
