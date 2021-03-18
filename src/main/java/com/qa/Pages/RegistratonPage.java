package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Base.BasePage;
import com.qa.Utils.Constants;
import com.qa.Utils.ElementUtil;

public class RegistratonPage extends BasePage {
	
	public WebDriver driver;
	public ElementUtil elementutil;
//----------------------------------------------------------------//
	
	//1- create By locators for this page'
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");

	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value = 'Continue']");
	
	private By accountSuccessMessg = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	
//-------------------------------------------------------------------------------//	
	
	//2--Create the constructor for this page and set the driver and element utils//
	
	public RegistratonPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
		
	}
//-----------------------------------------------------------------------------------//
	//3--Create the page actions//
	
	public boolean accountRegistration(String firstname, String lastname, 
			String email, String telephone, String password,
			String subscribe) {
		
		
		
		elementutil.doSendKeys(this.firstname, firstname);
		elementutil.doSendKeys(this.lastname, lastname);
		elementutil.doSendKeys(this.email, email);//tom9898@gmail.com
		elementutil.doSendKeys(this.telephone, telephone);
		elementutil.doSendKeys(this.password, password);
		elementutil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equalsIgnoreCase("Yes"))
		{elementutil.doClick(subscribeYes);
		}else {
			elementutil.doClick(subscribeNo);
		}
		
		elementutil.doClick(agreeCheckbox);
		elementutil.doClick(continueButton);
		
		String text = elementutil.doGetText(accountSuccessMessg);
		if(text.contains(Constants.ACCOUNT_SUCCESS_MESSG)) {
			elementutil.doClick(logoutLink);
			elementutil.doClick(registerLink);

			return true;
		}
		return false;
		
		
		
		
		
		

	}

	
	
}
