package com.vndly.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {

	public Properties pro;

	public ReadConfiguration() {
		File src = new File("./configuration/data.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("url");
		return url;
	}

	public String getFirstName() {
		String firstName = pro.getProperty("firstName");
		return firstName;
	}
	
	public String getLastName() {
		String lastName = pro.getProperty("lastName");
		return lastName;
	}

	public String getEmail() {
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getMobile() {
		String mobile = pro.getProperty("mobile");
		return mobile;
	}
}
