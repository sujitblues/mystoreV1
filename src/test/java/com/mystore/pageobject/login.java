package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	//Create object of webdriver
		WebDriver ldriver;
		public login(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		//identify webelements
		@FindBy(id ="Email")
		WebElement email;
		@FindBy(id="Password")WebElement password;
		@FindBy(xpath="//input[@class='button-1 login-button']") WebElement loginbutton;
		@FindBy(xpath="//input[@class='button-1 register-button']") WebElement registerbutton;
		public void enteEmailAddress(String emailadd) throws InterruptedException
		{
			Thread.sleep(3000);
			email.sendKeys(emailadd);
		}
		public void entePassword(String pwd) throws InterruptedException
		{
			Thread.sleep(3000);
			password.sendKeys(pwd);
		}

		//identify action on WebElement
		public void clickOnLoginButton() throws InterruptedException
		{
			Thread.sleep(3000);
			loginbutton.click();
		}
		public void clickOnRegisterButton()
		{
			registerbutton.click();
		}
		

}
