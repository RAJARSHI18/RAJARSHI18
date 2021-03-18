package com.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

    private WebDriver driver;
    private Properties prop;
    
    public static ThreadLocal<WebDriver> tldriver =  new ThreadLocal<>();
    
    
    //Generic funtion to initialize the driver//
	
	public WebDriver browser_init(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
	       // driver = new ChromeDriver();
	        tldriver.set(new ChromeDriver());
		}
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
	        //driver = new FirefoxDriver();
	        tldriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value :"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		
		return getDriver();
		
	}
	//----------------------------------------------------------------------------------//
	
	//Create the getdriver method wth threadlocal object//
	
	public static synchronized WebDriver getDriver() {
	return tldriver.get();
	}
	
	//-----------------------------------------------------------------------------------//
	//Generic function to initialize the properties file//
	
	public Properties prop_init() {
		
		prop = new Properties();
		
		try {
			FileInputStream ip= new FileInputStream("C:\\Users\\RAJ\\eclipse-workspaceNEW\\EcommercePOMFramework\\src\\main\\java\\com\\qa\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------//	
	
	//This method will return the screenshot whenevr a test case is failed//
	
	public String getScreenshot() {
		
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() +".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}
		
		
	}
	
