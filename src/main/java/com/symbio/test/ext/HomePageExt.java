package com.symbio.test.ext;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.DateCommon;

@Test
public class HomePageExt extends HomePage{
	
	HomePage homepage = new HomePage();
	DateCommon date=new DateCommon();
	
	@DataProvider
	public Object[][] data(){
		return new Object[][]{
			{"Beijing (and vicinity), China",
			 "San Francisco (and vicinity), California, United States of America"
			 }
	};
}
		
	
	public void enterStartCity(String startCityName,String endCityName){
		
		homepage.getStartCityTextField().type(startCityName);
		homepage.getEndCityTextField().type(endCityName);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		homepage.getStartDateTextField().type(simpleDateFormat.format(date.getNextMonday()));
		homepage.getReturnDateTextField().type(date.addWeekToDate(startDate, 3));

	}
	
	
	

}
