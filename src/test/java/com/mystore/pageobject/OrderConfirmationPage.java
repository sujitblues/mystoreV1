package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	WebDriver ldriver;
	public OrderConfirmationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//strong[contains(text(),'Your order has been')]") 
	WebElement ordersuccesstext;
	@FindBy(xpath="//li[contains(text(),'Order number: ')]") 
	WebElement ordernumber;
	public String getdOrderNumber()
	{
		String s=ordernumber.getText();
		s=s.replaceAll("[^0-9]", "");
		//System.out.println(s);
		return s;

	}
public String getOrdrSucessText()
{
	String ordersucesstextAcutual=ordersuccesstext.getText();
	return ordersucesstextAcutual;
}
}
