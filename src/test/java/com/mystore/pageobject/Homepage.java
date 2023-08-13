package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	//Create object of webdriver
	WebDriver ldriver;
	public Homepage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//identify webelements
	@FindBy(linkText ="Log in")
	WebElement Login;
	//identify register webelement
	@FindBy(linkText ="Register")
	WebElement UserRegister;
	@FindBy(linkText ="Log out")
	WebElement logout;
	@FindBy(id ="small-searchterms")
	WebElement searchtextbox;
	@FindBy(id="//ul[@id='ui-id-1']/li[1]/a") WebElement selectitem;
	@FindBy(xpath ="//input[@type='submit']")
	WebElement searchButton;
	//Click on register link
	public void clickOnRegisterlink()
	{
		UserRegister.click();
	}

	//click on login link
	public void clickOnLogin()
	{
		Login.click();
		
	}
	
	//Search the product
	public void TypeInField( String value) throws InterruptedException{
	    String val = value; 
	   // WebElement element = driver.findElement(By.xpath(xpath));
	    searchtextbox.clear();

	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        
	        searchtextbox.sendKeys(s);
	        Thread.sleep(2000);
	        //System.out.println(s);
	    }     
	    
	}
	
	public void clickOnSearch()
	{
		searchButton.click();
	}
	public String getLoginStatus()
	{
		String text=logout.getText();
		return text;
		
	}
	public void logout()
	{
		logout.click();
	}
	
	
	
}

