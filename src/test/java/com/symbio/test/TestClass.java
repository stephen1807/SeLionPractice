package com.symbio.test;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.HomePage;


public class TestClass {
	
	@DataProvider
	public Object[][] data() {
		return new Object[][] { { "Beijing", "San Fra" } };
	}
	
	@Test(dataProvider="data")
	@WebTest
	public void test(String startCityName,String endCityName) throws ParseException{
		
		Common common=new Common();
		HomePage homePage=new HomePage();
		
		Grid.driver().get("https://www.expedia.com.hk");
//		WebDriverWaitUtils.waitUntilElementIsVisible(homePage.getChangeLanguageLink().getLocator());
//		homePage.clickChangeLanguageLink();
		
		homePage.getFlightButton().click();
//	
//		common.selectCity(startCityName, endCityName);
		
		common.selectDate();
		
		homePage.clickSearchButton();
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
