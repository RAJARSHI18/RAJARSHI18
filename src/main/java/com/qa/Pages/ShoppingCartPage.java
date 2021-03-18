package com.qa.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.Base.BasePage;
import com.qa.Utils.ElementUtil;

public class ShoppingCartPage extends BasePage {
	
	public WebDriver driver;
	public ElementUtil elementutil;
//--------------------------------------------------------//
	
	
	
	
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver =driver;
		elementutil= new ElementUtil(this.driver);
		
	}

	
	
}
