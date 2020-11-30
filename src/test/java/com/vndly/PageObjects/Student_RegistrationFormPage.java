package com.vndly.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Student_RegistrationFormPage {

	WebDriver driver;

	public Student_RegistrationFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "firstName")
	WebElement firstName;

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	@FindBy(id = "lastName")
	WebElement lasttName;

	public void setLastName(String lname) {
		lasttName.sendKeys(lname);
	}

	@FindBy(id = "userEmail")
	WebElement email;

	public void setEmail(String em) {
		email.sendKeys(em);
	}

	@FindBy(xpath = "//label[contains(text(),'Male')]")
	WebElement checkboxGender;

	public void setGender() {
		checkboxGender.click();
	}

	@FindBy(id = "userNumber")
	WebElement mobilephone;

	public void setMobile(String mob) {
		mobilephone.sendKeys(mob);
	}

	@FindBy(id = "dateOfBirthInput")
	WebElement dateofbirths;

	public void getDateOfBirth(String date) {
		dateofbirths.sendKeys(date);
	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[6]/div[2]/div[1]/div[1]/div[1]")
	WebElement subjectsElements;

	public void getSubjects(String subs) {
		subjectsElements.sendKeys(subs);
	}

	@FindBy(xpath = "//label[contains(text(),'Sports')]")
	WebElement selectSports;

	public void getSports() {
		selectSports.click();
	}

	@FindBy(id = "currentAddress")
	WebElement currentsAddress;

	public void getCurrentAddress(String addr) {
		currentsAddress.sendKeys(addr);
	}

	@FindBy(xpath = "//button[@id='submit']")
	WebElement submitForm;

	public void setSubmitForm() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", submitForm);
	}
	
	@FindBy(xpath = "//button[@id='closeLargeModal']")
	WebElement closebtn;

	public void getCloseButton() {
		closebtn.click();
	}

}
