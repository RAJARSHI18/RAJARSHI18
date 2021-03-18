package com.qa.Test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.Utils.Constants;

public class ProductInfoPageTest extends BaseTest{
	
	
@BeforeClass
public void productinfoPageSetUp() {
	accountsPage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
}

@Test
public void verify_ProductInfoPageTitle() {
	accountsPage.doSearch("iMac") ;
	productinfopage = accountsPage.selectProductFromResults("iMac");
	Assert.assertEquals(productinfopage.getProductInfoPageTitle("iMac"),"iMac");
	productinfopage.selectProductquantity("2");
	
}
  @Test
   public void verify_ProductInformationDetails_Macbook() {
	
	accountsPage.doSearch("Macbook");//search the product in account page//
	productinfopage = accountsPage.selectProductFromResults("MacBook Pro");//from the different search results click the exact product //
	Assert.assertTrue(productinfopage.getProductImages() == 4);//check the product images count//

	Map<String, String> productInfoMap = productinfopage.getProductInformation();//store the productinfo inthe hashmap//
	System.out.println(productInfoMap);//print the hashmap//
	
//	{Brand=Apple,
//	Availability=Out Of Stock, 
//	Price=$2,000.00, 
//	name=MacBook Pro,
//	Product Code=Product 18, 
//	Reward Points=800, 
//	exTaxPrice=$2,000.00}
	
	//Assert.assertEquals(actual, expected);
	
	Assert.assertEquals(productInfoMap.get("name"),"MacBook Pro");//assert with actual vs expected//to retrive actual use the hashmap.get
	Assert.assertEquals(productInfoMap.get("Price"),"$2,000.00");
	Assert.assertEquals(productInfoMap.get("Brand"),"Apple");
	Assert.assertEquals(productInfoMap.get("Product Code"),"Product 18");
	Assert.assertEquals(productInfoMap.get("exTaxPrice"),"$2,000.00");
}


 
    @Test
    public void verify_ProductIsAddedtoCart()   {
    	accountsPage.doSearch("iMac") ;
    	productinfopage = accountsPage.selectProductFromResults("iMac");
    	
    	productinfopage.selectProductquantity("2");
    	productinfopage.addToCart();
    	String actualmsg = productinfopage.successfulAddtoCartMessage();
    	System.out.println(actualmsg);
    	Assert.assertEquals(actualmsg, Constants.ACK_MSG);
    }
  


}
