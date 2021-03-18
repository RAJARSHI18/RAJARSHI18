package com.qa.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.Pages.AccountsPage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.ProductInfoPage;
import com.qa.Pages.RegistratonPage;
import com.qa.Pages.ShoppingCartPage;

public class BaseTest{
	 
	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginpage;
	public AccountsPage accountsPage;
	public ProductInfoPage productinfopage;
	public ShoppingCartPage shoppingcartpage;
	public RegistratonPage registerPage;
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
		basepage =  new BasePage();
		prop = basepage.prop_init();
		String browser = prop.getProperty("browser");
	    driver = basepage.browser_init(browser);
		
		loginpage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		Thread.sleep(8000);
		
		
	}
		
		
	@AfterTest
	public void teardown() {
		driver.quit();
		
		
	}

}
