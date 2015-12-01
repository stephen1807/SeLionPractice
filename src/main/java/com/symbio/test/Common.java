package com.symbio.test;

import java.text.ParseException;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.componentext.DatePickerModuleExt;
import com.symbio.test.utility.Utility;

public class Common {

	private HomePage homePage;

	public Common() {
		homePage = new HomePage();
	}

	Utility util = new Utility();
	DatePickerModuleExt datePicker = new DatePickerModuleExt();

	public void selectCity(String startCityName, String endCityName) {

		homePage.getStartCityTextField().type(startCityName);
		homePage.getEndCityTextField().type(endCityName);
		WebDriverWaitUtils.waitUntilElementIsPresent(homePage.getDestinationSuggestionContainer().getLocator());
		homePage.getDestinationSuggestionContainer(0).getDestinationSuggestionLink().click();

	}

	public void selectDate() throws ParseException {

		homePage.getStartDateTextField().click();
		datePicker.clickDate(util.getNextMonday());

		homePage.getEndDateTextField().click();
		datePicker.clickDate(util.addWeekToDate(util.getNextMonday(), 3));
	}
}
