package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Base.BasePage;
import com.qa.Utils.Constants;
import com.qa.Utils.ElementUtil;



public class LoginPage extends BasePage {
	
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	// 1. By Locators: OR
		private By emailId = By.id("input-email");
		private By password = By.id("input-password");
		private By loginButton = By.xpath("//input[@value='Login' and @type='submit']");
		private By forgotPwdLink = By.linkText("Forgotten Password");
		
		private By registerLink = By.linkText("Register");
		
		// 2. Constructor of the page class:

		public LoginPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(this.driver);
		}
		// 3. page actions: features(Behvaior) of the page in the form methods:
			
			
		public String getLoginPageTitle() {
			
			return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		}
			
		public boolean isForgotPwdLinkExist() {
			return elementUtil.doIsDisplayed(forgotPwdLink);
		}
			
		public AccountsPage doLogin(String un, String pwd) {
				System.out.println("Login with : " + un + " and " + pwd);
				elementUtil.doSendKeys(emailId, un);
				elementUtil.doSendKeys(password, pwd);
				elementUtil.doClick(loginButton);
				
				return new AccountsPage(driver);
			}
			
		public RegistratonPage  navigateToRegisterPage() {
				elementUtil.doClick(registerLink);
				return new RegistratonPage(driver);
				
			}

		}

	
	
	


