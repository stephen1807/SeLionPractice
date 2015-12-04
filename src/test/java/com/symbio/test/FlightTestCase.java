package com.symbio.test;

import java.text.ParseException;
import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.FlightHomePage;
import com.paypal.selion.testcomponents.FlightSearchPage;
import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.componentext.FlightConfirmationPageExt;
import com.symbio.test.componentext.FlightHomePageExt;
import com.symbio.test.componentext.FlightSearchPageExt;
import com.symbio.test.componentext.HotelHomePageExt;
import com.symbio.test.utility.Utility;

public class FlightTestCase {

	private FlightHomePageExt flightHomePageExt = new FlightHomePageExt();
	private FlightHomePage flightHomePage = new FlightHomePage();
	private Utility util = new Utility();
	private FlightSearchPageExt flightSearchPageExt = new FlightSearchPageExt();
	private FlightSearchPage flightSearchPage = new FlightSearchPage();
	private FlightConfirmationPageExt flightConfirmationPageExt = new FlightConfirmationPageExt();

	@DataProvider
	public Object[][] data() {
		return new Object[][] { { "Beijing", "San Francisco" } };
	}

	/**
	 * Test case for the shortest flight, from next monday for three weeks
	 * 
	 * @param startCityName
	 *            The start city name
	 * @param endCityName
	 *            The destination city name
	 * @throws ParseException
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "data")
	@WebTest
	public void testShorest(String startCityName, String endCityName) throws ParseException, InterruptedException {

		// Open the expedia url
		Grid.driver().get("https://www.expedia.com");
		Grid.driver().manage().window().maximize();

		WebDriverWaitUtils.waitUntilPageIsValidated(new HomePage());

		// Go to the US site
		if (flightHomePageExt.getRedirectLink().isElementPresent()) {
			flightHomePageExt.clickRedirectLink(new FlightHomePageExt());
		}

		flightHomePageExt.clickFlightLink(flightHomePageExt);

		flightHomePageExt.enterCity(startCityName, endCityName);

		flightHomePageExt.selectDate();

		flightHomePage.clickSearchButton();

		// Wait the search result show up
		flightSearchPage.clickCompleteTripLink(flightSearchPage.getSearchResultContainer().getLocator());

		flightSearchPageExt.sortSearchResultByDuration();

		WebDriverWaitUtils.waitUntilElementIsInvisible(flightSearchPage.getSearchResultContainer().getLocator());

		WebDriverWaitUtils.waitUntilElementIsVisible(flightSearchPage.getSearchResultContainer().getLocator());

		flightSearchPageExt.getGoAndReturnFlight();

		// Switch to the review trip page
		flightSearchPageExt.checkWindow();

	}

	/**
	 * Test case for the cheapest flight, from next monday for three weeks
	 * 
	 * @param startCityName
	 *            The start city name
	 * @param endCityName
	 *            The destination city name
	 * @throws ParseException
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "data")
	@WebTest
	public void testCheapest(String startCityName, String endCityName) throws ParseException, InterruptedException {

		// Open the expedia url
		Grid.driver().get("https://www.expedia.com");
		Grid.driver().manage().window().maximize();

		WebDriverWaitUtils.waitUntilPageIsValidated(new HomePage());

		// Go to the US site
		if (flightHomePageExt.getRedirectLink().isElementPresent()) {
			flightHomePageExt.clickRedirectLink(new FlightHomePageExt());
		}

		flightHomePageExt.clickFlightLink(flightHomePageExt);

		flightHomePageExt.enterCity(startCityName, endCityName);

		flightHomePageExt.selectDate();

		flightHomePage.clickSearchButton();

		// Wait the search result show up
		WebDriverWaitUtils.waitUntilElementIsVisible(flightSearchPage.getSearchResultContainer().getLocator());

		flightSearchPage.clickCompleteTripLink();

		WebDriverWaitUtils.waitUntilElementIsInvisible(flightSearchPage.getSearchResultContainer().getLocator());

		WebDriverWaitUtils.waitUntilElementIsVisible(flightSearchPage.getSearchResultContainer().getLocator());

		flightSearchPageExt.getGoAndReturnFlight();

		// Switch to the review trip page
		flightSearchPageExt.checkWindow();

	}

	/**
	 * Test case for the cheapest and the time under 15h flight, from next
	 * monday for three weeks
	 * 
	 * @param startCityName
	 *            The start city name
	 * @param endCityName
	 *            The destination city name
	 * @throws ParseException
	 * @throws InterruptedException
	 */

	@Test(dataProvider = "data")
	@WebTest
	public void testCheapestAndTimeLimit(String startCityName, String endCityName)
			throws ParseException, InterruptedException {

		// Open the expedia url
		Grid.driver().get("https://www.expedia.com");
		Grid.driver().manage().window().maximize();

		WebDriverWaitUtils.waitUntilPageIsValidated(new HomePage());

		// Go to the US site
		if (flightHomePageExt.getRedirectLink().isElementPresent()) {
			flightHomePageExt.clickRedirectLink(new FlightHomePageExt());
		}

		flightHomePageExt.clickFlightLink(flightHomePageExt);

		flightHomePageExt.enterCity(startCityName, endCityName);

		flightHomePageExt.selectDate();

		flightHomePage.clickSearchButton();

		// Wait the search result show up
		WebDriverWaitUtils.waitUntilElementIsVisible(flightSearchPage.getSearchResultContainer().getLocator());

		flightSearchPage.clickCompleteTripLink();

		WebDriverWaitUtils.waitUntilElementIsInvisible(flightSearchPage.getSearchResultContainer().getLocator());

		WebDriverWaitUtils.waitUntilElementIsVisible(flightSearchPage.getSearchResultContainer().getLocator());

		flightSearchPageExt.getFirstFlightUnderTime(15, 0).getSelectResultButton().click();

		flightSearchPageExt.getGoAndReturnFlight();

		// Switch to the review trip page
		flightSearchPageExt.checkWindow();

	}

}
