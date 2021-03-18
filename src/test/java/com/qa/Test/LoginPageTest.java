package com.qa.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.Utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test
	public void verifyLoginpagetitle() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("login pagin page title is :" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		}
    @Test
    public void verifyForgotPasswordLink() {
    	Assert.assertTrue(loginpage.isForgotPwdLinkExist());
    }
    @Test
    public void verifyLogin() {
    	loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    }
	

