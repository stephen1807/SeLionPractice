package com.symbio.test.componentext;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.FlightSearchPage;
import com.symbio.test.utility.Utility;

/**
 * Extension of FlightSearchPage class, adding new methods to the generated
 * .java file
 * 
 * @author Stephen Raharja
 *
 */
public class FlightSearchPageExt extends FlightSearchPage {

	private Utility util = new Utility();

	/**
	 * Pick a flight that has less flight time than limit
	 * 
	 * @param hour
	 *            Hour part of total flight time
	 * @param minute
	 *            Minute part of total flight time
	 */
	@SuppressWarnings("resource")
	public SearchResultContainer getFirstFlightUnderTime(int hourInteger, int minuteInteger) {

		// Loop through all containers
		for (int loopIndex = 0; loopIndex < this.getSearchResultContainer(loopIndex).size(); loopIndex++) {

			// Get the label containing the flight time in string
			String flightTimeString = this.getSearchResultContainer(loopIndex).getFlightLengthLabel().getText();

			// Parse the string into two integers, for hour and minute
			Scanner scanner = new Scanner(flightTimeString).useDelimiter("[^0-9]+");
			int currentFlightHourInteger = scanner.nextInt();
			int currentFlightMinuteInteger = scanner.nextInt();

			// If current flight is within the limit, return it
			if (currentFlightHourInteger <= hourInteger && currentFlightMinuteInteger < minuteInteger) {
				return this.getSearchResultContainer(loopIndex);
			}
		}
		return null;
	}

	/**
	 * Pick a flight that has less flight time than limit
	 * 
	 * @param hour
	 *            Hour part of total flight time
	 */
	public SearchResultContainer getFirstFlightUnderTime(int hourInteger) {
		return getFirstFlightUnderTime(hourInteger, 0);
	}

	/**
	 * Choose the sort by Duration (Shortest) in search result page
	 */
	public void sortSearchResultByDuration() {

		this.selectSearchSortOptionListByIndex(2);
	}

	/**
	 * Get the flight to destination city
	 */
	public void getGoAndReturnFlight() {

		// Get the go and return flight
		this.getSearchResultContainer(0).getSelectResultButton().click();

	}

	/**
	 * Check the no thanks window pop up or not
	 */
	public void checkWindow() {

		// Wait the no thanks link is show up
		WebDriverWaitUtils.waitUntilElementIsVisible(this.getNoThanksLink().getLocator());

		if (this.getNoThanksLink().isVisible()) {

			this.getNoThanksLink().click();
			util.switchToNewWindow();

			// WebDriverWaitUtils.waitUntilPageIsValidated(new
			// FlightConfirmationPageExt());
		}

	}

}
