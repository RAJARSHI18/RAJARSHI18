package com.qa.Pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Base.BasePage;
import com.qa.Utils.ElementUtil;

public class ProductInfoPage extends BasePage{

	//----------------------------------------------------------//
	private WebDriver driver;
	private ElementUtil elementutil;
	//------------------------------------------------------------//
	
	
	private By productNameHeader = By.cssSelector("div#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.xpath("//input[@id='input-quantity']");
	private By addToCartButton = By.id("button-cart");
	private By productImages = By.cssSelector(".thumbnails li img");
	private By acknowledgementmsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By checkkoutlink = By.xpath("//span[text()='Checkout']");
	
	//------------------------------------------------------------//
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}
	//----------------------------------------------------------------//
	
	public Map<String, String> getProductInformation() {
		
		Map<String,String> productInfoMap= new HashMap<>();
		
		productInfoMap.put("name", elementutil.doGetText(productNameHeader).trim());
		
		List<WebElement> productMetaDataList = elementutil.getElements(productMetaData);
		for (WebElement e :productMetaDataList ) {
		productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());

		}
		
		List<WebElement> productpriceList = elementutil.getElements(productPrice);
		productInfoMap.put("Price",productpriceList.get(0).getText().trim() );
		productInfoMap.put("exTaxPrice",productpriceList.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
		
		
		
	}
	
	public void selectProductquantity(String qty) {
		elementutil.doSendKeys(quantity, qty);
	}
	
	

	public void addToCart() {
		elementutil.doClick(addToCartButton);
		
	}

	public int getProductImages() {
		int imagesCount = elementutil.getElements(productImages).size();
		System.out.println("total images : " + imagesCount);
		return imagesCount;
	}
	
	public String getProductInfoPageTitle(String productName) {
		return elementutil.waitForTitlePresent(productName, 5);	
	}
	
	public String successfulAddtoCartMessage() {
		return elementutil.waitForElementToBeLocated(acknowledgementmsg, 10).getText();
		 
	}
	
	public ShoppingCartPage clickonCheckOutLink() {
		
		elementutil.doClick(checkkoutlink);
		return new ShoppingCartPage(driver) ;
	}
	
	


}
