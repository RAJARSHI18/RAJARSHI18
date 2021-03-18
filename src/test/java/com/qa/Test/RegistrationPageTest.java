package com.qa.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.Utils.Constants;
import com.qa.Utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void registerPageSetUp() {
		registerPage = loginpage.navigateToRegisterPage();
	}
	
	@DataProvider
	public  Object[][] getRegisterData() {
		
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
		
	}
	
	@Test(dataProvider ="getRegisterData")
	public void verify_UserAccRegistration(String firstname ,String lastname,String email,String telephone,String password,String subscribe) {
		
		
		registerPage.accountRegistration(firstname, lastname, email, telephone, password, subscribe);
	}
	
	

}
