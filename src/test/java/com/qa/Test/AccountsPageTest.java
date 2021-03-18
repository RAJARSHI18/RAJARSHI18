package com.qa.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.Utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void AccountsPageSetUp() {
		accountsPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2)
	public void accountsPageTitleTest() {
		String title = accountsPage.getAccountPagePagetitle();
		System.out.println("accounts page title is : " + title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

	
	@Test(priority = 1)
	public void verifyAccountsPageHeaderTest() {
		String headerValue = accountsPage.getHeaderValue();
		System.out.println("accounts page header is : " + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}


	@Test(priority = 3)
	public void verifyMyAccountSectionsCountTest() {
		Assert.assertTrue(accountsPage.getAccountSectionsCount() == Constants.ACCOUNTS_SECTIONS);
	}

	
	@Test(priority = 4)
	public void verifyMyAccountSectionsListTest() {
		Assert.assertEquals(accountsPage.getAccountSectionsList(), Constants.getAccountSectionsList());
	}

	@Test(priority = 5)
	public void searchTest() {
		Assert.assertTrue(accountsPage.doSearch("iMac"));
	}

}



