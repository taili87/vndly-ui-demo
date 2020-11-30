package com.vndly.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vndly.PageObjects.BaseTest;
import com.vndly.PageObjects.Student_RegistrationFormPage;

public class TC001_Student_RegistrationForm extends BaseTest {

	@Test(priority = 1)
	void TC_fill_Student_RegistrationForm(){
		Student_RegistrationFormPage psr = new Student_RegistrationFormPage(driver);
		logger.info("Enter First Name");
		psr.setFirstName(firstName);
		logger.info("Enter Last Name");
		psr.setLastName(lastName);
		logger.info("Enter Email Address");
		psr.setEmail(email);
		logger.info("Select Gender: Male, Female or Others");
		psr.setGender();
		logger.info("Enter Mobile Phone Number");
		psr.setMobile(mobile);
		logger.info("Submit the form");
		psr.setSubmitForm();
		logger.info("Close Browser");

		/*
		 * Navigate to https://demoqa.com/automation-practice-form Complete and submit
		 * the form. The minimum required fields for form submission are: First Name,
		 * Last Name, Email, Gender, and Mobile. Any additional fields you complete are
		 * a plus. Assert the title of the modal that says
		 * "Thanks for submitting the form" Capture a screenshot
		 */

	}

	@Test(priority = 2)
	public void validateText() {
		// Validating the actual and expcted text
		String expectedText = "Thanks for submitting the form";
		WebElement actualtexts = driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]"));
		String actualtext = actualtexts.getText();
		logger.info(actualtext);
		Assert.assertEquals(actualtext, expectedText);
		
		
		/*String text=driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]")).getText();
		
		
		
		if(text.contains("Thanks for submitting the form"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"TC_fill_Student_RegistrationForm");
			Assert.assertTrue(false);
		}*/

	}
	
	@Test(priority = 3)
	public void unValidedText_Capture_A_Screenshot() {
		// Validating the actual and expected text
		String expectedText = "Thanks for submitting the formA";
		WebElement actualtexts = driver.findElement(By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]"));
		String actualtext = actualtexts.getText();
		logger.info("This is the message = "+actualtext);
		Assert.assertEquals(actualtext, expectedText);
	}

}
