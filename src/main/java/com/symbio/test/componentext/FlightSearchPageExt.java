package com.symbio.test.componentext;

import java.util.Scanner;

import com.paypal.selion.testcomponents.FlightSearchPage;

/**
 * Extension of FlightSearchPage class, adding new methods to the generated
 * .java file
 * 
 * @author Stephen Raharja
 *
 */
public class FlightSearchPageExt extends FlightSearchPage {

	/**
	 * Pick a flight that has less flight time than limit
	 * 
	 * @param hour
	 *            Hour part of total flight time
	 * @param minute
	 *            Minute part of total flight time
	 */
	public SearchResultContainer getFirstFlightUnderTime(int hourInteger, int minuteInteger) {
		
		//Loop through all containers
		for (int loopIndex = 0; loopIndex < this.getSearchResultContainer(loopIndex).size(); loopIndex++){
			
			//Get the label containing the flight time in string
			String flightTimeString = this.getSearchResultContainer(loopIndex).getFlightLengthLabel().getText();
			
			//Parse the string into two integers, for hour and minute
			Scanner scanner = new Scanner(flightTimeString).useDelimiter("[^0-9]+");
			int currentFlightHourInteger = scanner.nextInt();
			int currentFlightMinuteInteger = scanner.nextInt();
			
			//If current flight is within the limit, return it
			if (currentFlightHourInteger <= hourInteger && currentFlightMinuteInteger < minuteInteger){
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
	public SearchResultContainer getFirstFlightUnderTime(int hourInteger){
		return getFirstFlightUnderTime(hourInteger, 0);
	}
	
	/**
	 * Choose the sort by Price (Lowest) in search result page
	 */
	public void sortSearchResultByPriceAscending(){
		this.getSearchSortOptionList().selectByIndex(0);
	}
	
	/**
	 * Choose the sort by Duration (Shortest) in search result page
	 */
	public void sortSearchResultByDurationAscending(){
		this.getSearchSortOptionList().selectByIndex(2);
	}
}
