package com.symbio.test.componentext;

import java.text.ParseException;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.FlightHomePage;
import com.symbio.test.utility.Utility;

public class FlightHomePageExt extends FlightHomePage {

	FlightHomePage flightHomePage = new FlightHomePage();
	Utility util = new Utility();
	DatePickerModuleExt datePicker = new DatePickerModuleExt();

	/**
	 * Enter the city name where I am going
	 * 
	 * @param startCityName
	 *            The start city name
	 * @throws endCityName
	 *             The destination city name
	 */
	public void enterCity(String startCityName, String endCityName) throws InterruptedException {

		// Select the start city
		for (int i = 0; i < startCityName.length(); i++) {

			flightHomePage.getStartCityTextField().type(startCityName);

			flightHomePage.getStartCityTextField().type(String.valueOf(startCityName.charAt(i)), true);

			WebDriverWaitUtils.waitUntilElementIsClickable(flightHomePage.getStartCitySuggestionContainer().getLocator());

			flightHomePage.getStartCitySuggestionContainer(0).getStratCitySuggestionLink().click();
		}

		// Select the destination city
		for (int i = 0; i < endCityName.length(); i++) {

			flightHomePage.getDestinationCityTextField().type(endCityName);

			flightHomePage.getDestinationCityTextField().type(String.valueOf(endCityName.charAt(i)), true);

			WebDriverWaitUtils.waitUntilElementIsClickable(flightHomePage.getDestinationSuggestionContainer().getLocator());

			flightHomePage.getDestinationSuggestionContainer(0).getDestinationSuggestionLink().click();

		}

	}

	/**
	 * Enter the date from next monday to after three weeks
	 * 
	 */
	public void selectDate() throws ParseException {

		WebDriverWaitUtils.waitUntilElementIsClickable(flightHomePage.getStartDateTextField().getLocator());

		// Click the next monday
		flightHomePage.getStartDateTextField().click();
		datePicker.clickDate(util.getNextMonday());

		// Click the monday after three weeks
		flightHomePage.getEndDateTextField().click();
		datePicker.clickDate(util.addWeekToDate(util.getNextMonday(), 3));
	}

}
