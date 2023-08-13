package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUser {
	//Create object of webdriver
			WebDriver ldriver;
			public RegisterUser(WebDriver rdriver)
			{
				ldriver=rdriver;
				PageFactory.initElements(rdriver, this);
			}

			@FindBy(id="gender-male") WebElement male;
			@FindBy(id="gender-female") WebElement female;
			@FindBy(id="FirstName") WebElement fname;
			@FindBy(id="LastName") WebElement lname;
			@FindBy(id="Email") WebElement email;
			@FindBy(id="Password") WebElement pwd;
			@FindBy(id="register-button") WebElement registerbutton;
			public void clickOnRegister()
			{
				registerbutton.click();
			}
			/*
			public String getUserName()
			{
				String text=
				return text;
				
			}
			*/
}
