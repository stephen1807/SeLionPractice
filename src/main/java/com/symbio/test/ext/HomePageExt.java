package com.symbio.test.ext;

import java.text.SimpleDateFormat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.utility.Utility;

@Test
public class HomePageExt extends HomePage{
	
	HomePage homepage = new HomePage();
	Utility util=new Utility();
	
	@DataProvider
	public Object[][] data(){
		return new Object[][]{
			{"Beijing (and vicinity), China",
			 "San Francisco USA"
			 }
	};
}
		
	
	public void selectCity(String startCityName,String endCityName){
		
		homepage.getStartCityTextField().type(startCityName);
		homepage.getEndCityTextField().click();
		homepage.getSearchResultContainer();
		homep
	}
	
	public void selectDate(){
		
		homepage.getStartDateTextField().click();
		homepage.getFirstDateTable()
		util.getNextMonday(
	}
	
	public void clickSearchButtion(){
		
		homepage.getSearchButton().click();
	}

}
