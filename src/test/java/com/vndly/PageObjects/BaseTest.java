package com.vndly.PageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.vndly.utilities.ReadConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public static Logger logger;
	ReadConfiguration readconfig = new ReadConfiguration();
	public String url = readconfig.getApplicationURL();

	public String firstName = readconfig.getFirstName();
	public String lastName = readconfig.getLastName();
	public String email = readconfig.getEmail();
	public String mobile = readconfig.getMobile();

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {

		logger = Logger.getLogger("com.vndlyForm"); // Added Logger
		PropertyConfigurator.configure("logs/log4j.properties"); // added logger
		

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
