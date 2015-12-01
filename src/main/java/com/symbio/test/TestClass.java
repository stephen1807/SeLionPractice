package com.symbio.test;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import com.symbio.test.componentext.HomePageExt;

public class TestClass {
	
	@DataProvider
	public Object[][] data() {
		return new Object[][] { { "Beijing", "San Fran" } };
	}
	
	@Test(dataProvider="data")
	@WebTest
	public void test(String startCityName,String endCityName) throws ParseException{
		
		Grid.driver().get("https://www.expedia.com.hk");
		HomePageExt homepage=new HomePageExt();
		
		homepage.selectFlight();
		
		homepage.selectCity(startCityName, endCityName);
		
		homepage.selectDate();
		
		homepage.clickSearchButton();
		
	}
}
