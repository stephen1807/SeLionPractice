package com.symbio.test.componentext;

import java.text.ParseException;
import java.util.Date;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.HotelHomePage;
import com.symbio.test.utility.Utility;

/**
 * Extension of the HotelHomePage generated class
 * 
 * @author Stephen Raharja
 *
 */
public class HotelHomePageExt extends HotelHomePage {

	private Utility utility = new Utility();

	/**
	 * Insert date into the hotel homepage
	 * 
	 * @throws ParseException
	 *             Parse exception from the date picker
	 */
	public void insertDate() throws ParseException {

		// Initialize variables
		DatePickerModuleExt datePicker = new DatePickerModuleExt();
		Date nextMondayDate = utility.getNextMonday();

		// Click date to the checkin textfield
		this.getCheckinDateTextField().click(datePicker);
		datePicker.clickDate(nextMondayDate);

		// Click date to the checkout textfield
		this.getCheckoutDateTextField().click(datePicker);
		datePicker.clickDate(utility.addWeekToDate(nextMondayDate, 3));
	}

	/**
	 * Insert city name into the destination text field and click the first
	 * suggestion
	 * 
	 * @param destinationString
	 *            Destination name
	 */
	public void insertDestination(String destinationString) {

		//Input string as sequence of chars
		utility.simulateTypingToTextField(destinationString, this.getHotelDestinationTextField());
		
		//Wait until suggestion list appears
		WebDriverWaitUtils.waitUntilElementIsVisible(this.getDestinationSuggestionContainer(0).getLocator());
		
		//Click the first one
		this.getDestinationSuggestionContainer(0).click();
	}
}
