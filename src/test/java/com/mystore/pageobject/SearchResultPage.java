package com.mystore.pageobject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.testcases.BaseClass;

public class SearchResultPage extends BaseClass{
	//Create object of webdriver
	WebDriver ldriver;
	public SearchResultPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1") 
	WebElement searchresultproduct;
	@FindBy(id="addtocart_31_EnteredQuantity") 
	WebElement quantity;
	@FindBy(id="add-to-cart-button-31") 
	WebElement addtocart;
	//@FindBy(xpath="//span[contains(text(),'Shopping cart']") 
	//WebElement shoopingcart;
	@FindBy(xpath="//*[@id='topcartlink']/a/span[1]") 
		WebElement shoopingcart;
	
	@FindBy(id="flyout-cart") WebElement tooltip;
	@FindBy(xpath="//input[@value='Go to cart']") WebElement gotocart;
	@FindBy(id="//*[@id='bar-notification']/p/text()") WebElement successtext;
	public String getSearchResultProductName()
	{
		return(searchresultproduct.getText());
	}
public void enterQuantity()
{
	quantity.clear();
	quantity.sendKeys("2");
}
public void clickOnAddCart()
{
	addtocart.click();
}
public String getItemAddSuccessfulText()
{
	return successtext.getText();
}
public void mosueHoverOnCart() throws InterruptedException
{
	Actions act=new Actions(driver);
	act.moveToElement(shoopingcart).build().perform();
}
public void clickOnGoToCart()
{
	Actions act=new Actions(driver);
	act.moveToElement(gotocart).click().build().perform();
	}
public void clickOnShoppingCart()
{
	System.out.println(shoopingcart.getText());
	shoopingcart.click();
	
}
}
