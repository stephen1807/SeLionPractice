package com.symbio.test.componentext;

import java.text.ParseException;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.utility.Utility;


public class HomePageExt extends HomePage {

	private HomePage homepage = new HomePage();
	private DatePickerModuleExt datePicker = new DatePickerModuleExt();
	private Utility util = new Utility();

	public void selectFlight(){
		
		homepage.getFlightButton().click();
	}

	public void selectCity(String startCityName, String endCityName) {

		homepage.getStartCityTextField().type(startCityName);
		homepage.getEndCityTextField().click();
		homepage.getEndCityTextField().type(endCityName);
		WebDriverWaitUtils.waitUntilElementIsPresent(homepage.getDestinationSuggestionContainer().getLocator());
		homepage.getDestinationSuggestionContainer(0).getDestinationSuggestionLink().click();

	}

	public void selectDate() throws ParseException {

		homepage.getStartDateTextField().click();
		
		homepage.getStartDateTextField().click(util.getNextMonday());
		
		homepage.getEndDateTextField().click(datePicker.getCurrentCalendarLabel());		
		datePicker.clickDate(util.addWeekToDate(util.getNextMonday(), 3));

	}

	public void clickSearchButton() {

		homepage.getSearchButton().click();
	}

}
