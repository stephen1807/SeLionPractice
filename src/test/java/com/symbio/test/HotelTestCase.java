package com.symbio.test;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.componentext.HotelDetailPageExt;
import com.symbio.test.componentext.HotelHomePageExt;
import com.symbio.test.componentext.HotelSearchPageExt;

public class HotelTestCase {

	private HomePage homePage = new HomePage();
	private HotelHomePageExt hotelHomePage = new HotelHomePageExt();
	private HotelSearchPageExt hotelSearchPage = new HotelSearchPageExt();
	private HotelDetailPageExt hotelDetailPage = new HotelDetailPageExt();

	/**
	 * Test case for the cheapest hotel, from next monday for 3 weeks
	 * 
	 * @param destinationName
	 *            City name where the hotel is
	 * @param hotelName
	 *            Name of the hotel
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "provideLocationNames")
	@WebTest
	public void testCase1(String destinationName, String hotelName) throws ParseException, InterruptedException {

		Grid.driver().get("http://www.expedia.com.hk");
		Grid.driver().manage().window().maximize();

		homePage.clickHotelButton(hotelHomePage);

		// Insert destination name
		hotelHomePage.insertDestination(destinationName);

		// Insert date, next monday and 3 weeks later
		hotelHomePage.insertDate();
		hotelHomePage.clickHotelSearchButton(hotelSearchPage);

		hotelSearchPage.clickAndWaitForReload(hotelSearchPage.getSortPriceButton());
		hotelSearchPage.clickFirstSearchResultLink();

		hotelDetailPage.clickFirstAvailableRoom();
	}

	/**
	 * Test case for the cheapest 4+ stars hotel, from next monday for 3 weeks
	 * 
	 * @param destinationName
	 *            City name where the hotel is
	 * @param hotelName
	 *            Name of the hotel
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "provideLocationNames")
	@WebTest
	public void testCase2(String destinationName, String hotelName) throws ParseException, InterruptedException {

		Grid.driver().get("http://www.expedia.com.hk");
		Grid.driver().manage().window().maximize();

		homePage.clickHotelButton(hotelHomePage);

		// Insert destination name
		hotelHomePage.getHotelDestinationTextField().type(destinationName);

		// Insert date, next monday and 3 weeks later
		hotelHomePage.insertDate();
		hotelHomePage.clickHotelSearchButton(hotelSearchPage);

		hotelSearchPage.filterHotelByMinimumFourStars();
		hotelSearchPage.clickAndWaitForReload(hotelSearchPage.getSortPriceButton());
		hotelSearchPage.clickFirstSearchResultLink();

		hotelDetailPage.clickFirstAvailableRoom();
	}

	/**
	 * Test case for the Extended Stay Downtown hotel, from next monday for 3
	 * weeks
	 * 
	 * @param destinationName
	 *            City name where the hotel is
	 * @param hotelName
	 *            Name of the hotel
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "provideLocationNames")
	@WebTest
	public void testCase3(String destinationName, String hotelName) throws ParseException, InterruptedException {

		Grid.driver().get("http://www.expedia.com.hk");
		Grid.driver().manage().window().maximize();

		homePage.clickHotelButton(hotelHomePage);

		// Insert destination name
		hotelHomePage.insertDestination(destinationName);

		// Insert date, next monday and 3 weeks later
		hotelHomePage.insertDate();
		hotelHomePage.clickHotelSearchButton(hotelSearchPage);

		hotelSearchPage.searchHotelName(hotelName);
		hotelSearchPage.clickFirstSearchResultLink();

		hotelDetailPage.clickFirstAvailableRoom();

	}

	/**
	 * Provide parameters for the test case. City name and hotel name
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] provideLocationNames() {
		return new Object[][] { { "San Jose", "Extended Stay Downtown" } };
	}
}
