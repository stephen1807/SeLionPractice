package com.symbio.test.componentext;

import java.text.ParseException;
import java.util.Date;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.CarHomePage;
import com.symbio.test.utility.Utility;

/**
 * Extension of the CarHomePage generated class
 * 
 * @author Stephen Raharja
 *
 */
public class CarHomePageExt extends CarHomePage {

	private Utility utility = new Utility();

	/**
	 * Insert location into the textfield, and then pick the first suggested
	 * location
	 * 
	 * @param locationString
	 *            Name of the location
	 */
	public void insertPickupLocation(String locationString) {
		// Slowly type in the location into the textfield
		utility.simulateTypingToTextField(locationString, this.getCarPickUpPlaceTextField());

		// Wait for the suggestion to appear
		WebDriverWaitUtils.waitUntilElementIsVisible(this.getCarPlaceSuggestionContainer().getLocator());

		// Click the first suggestion
		this.getCarPlaceSuggestionContainer(0).click();
	}

	/**
	 * Insert the dates into the pickup and dropoff date textfield. Will enter
	 * the next monday for the pickup, and 3 weeks later of the next monday in
	 * the dropoff.
	 * @throws ParseException 
	 */
	public void insertDates() throws ParseException {

		DatePickerModuleExt datePickerModule = new DatePickerModuleExt();

		//Get the date of next available monday
		Date nextMondayDate = utility.getNextMonday();
		
		//Click the textfield and wait for the date picker to appear
		this.getCarPickUpDateTextField().click(datePickerModule);
		
		//Click the targeted date
		datePickerModule.clickDate(nextMondayDate);
		
		//Click the textfield and wait for the date picker to appear
		this.getCarDropOffDateTextField().click(datePickerModule);
		
		//Calculate the 3 weeks later date and then click the targeted date
		datePickerModule.clickDate(utility.addWeekToDate(nextMondayDate, 3));
		
	}
}
