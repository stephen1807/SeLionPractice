package com.symbio.test;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.SeLionReporter;
import com.paypal.selion.testcomponents.HomePage;
import com.symbio.test.componentext.CarHomePageExt;
import com.symbio.test.componentext.CarSearchPageExt;

public class CarTestCase {

	private HomePage homePage = new HomePage();
	private CarHomePageExt carHomePage = new CarHomePageExt();
	private CarSearchPageExt carSearchPage = new CarSearchPageExt();

	private String flightLocation1String = "San Jose CA";
	private String flightLocation2String = "San Jose CA";

	/**
	 * Get the cheapest car
	 * 
	 * @throws ParseException
	 */
	@Test(groups = "carTest")
	@WebTest
	public void testCase1() throws ParseException {
		Grid.driver().get("http://www.expedia.com");
		Grid.driver().manage().window().maximize();

		// Wait until page is loaded
		WebDriverWaitUtils.waitUntilPageIsValidated(homePage);

		// If there is any redirect link, it means the site has been redirected
		// to HK site
		// Will click the link and go to US site
		if (homePage.getRedirectLink().isElementPresent()) {
			WebDriverWaitUtils.waitUntilElementIsVisible(homePage.getRedirectLink().getLocator());
			homePage.getRedirectLink().click(homePage);
		}

		// Go to car homepage
		homePage.getCarButton().click(carHomePage);

		// Insert destination and date, and then execute search
		carHomePage.insertPickupLocation(flightLocation1String);
		carHomePage.insertDates();
		carHomePage.clickCarSearchButton(carSearchPage);

		// Select the first car in the list
		carSearchPage.selectFirstAvailableCar();

		SeLionReporter.log(Grid.driver().getTitle(), true, true);

	}

	/**
	 * Get the cheapest SUV
	 * 
	 * @throws ParseException
	 */
	@Test(groups = "carTest")
	@WebTest
	public void testCase2() throws ParseException {
		Grid.driver().get("http://www.expedia.com");
		Grid.driver().manage().window().maximize();

		// Wait until page is loaded
		WebDriverWaitUtils.waitUntilPageIsValidated(homePage);

		// If there is any redirect link, it means the site has been redirected
		// to HK site
		// Will click the link and go to US site
		if (homePage.getRedirectLink().isElementPresent()) {
			WebDriverWaitUtils.waitUntilElementIsVisible(homePage.getRedirectLink().getLocator());
			homePage.getRedirectLink().click(homePage);
		}

		// Go to car homepage
		homePage.getCarButton().click(carHomePage);

		// Insert destination and date, and then execute search
		carHomePage.insertPickupLocation(flightLocation2String);
		carHomePage.insertDates();
		carHomePage.clickCarSearchButton(carSearchPage);

		// Filter cars for van type
		carSearchPage.clickAndWaitToReload(carSearchPage.getCarTypeSUVCheckBox());

		// Select the first car in the list
		carSearchPage.selectFirstAvailableCar();

		SeLionReporter.log(Grid.driver().getTitle(), true, true);

	}

	/**
	 * Get the cheapest Van , dependsOnGroups = { "flightTest" }
	 * 
	 * @throws ParseException
	 */
	@Test(groups = "carTest")
	@WebTest
	public void testCase3() throws ParseException {
		Grid.driver().get("http://www.expedia.com");
		Grid.driver().manage().window().maximize();

		// Wait until page is loaded
		WebDriverWaitUtils.waitUntilPageIsValidated(homePage);

		// If there is any redirect link, it means the site has been redirected
		// to HK site
		// Will click the link and go to US site
		if (homePage.getRedirectLink().isElementPresent()) {
			WebDriverWaitUtils.waitUntilElementIsVisible(homePage.getRedirectLink().getLocator());
			homePage.getRedirectLink().click(homePage);
		}

		// Go to car homepage
		homePage.getCarButton().click(carHomePage);

		// Insert destination and date, and then execute search
		carHomePage.insertPickupLocation(flightLocation2String);
		carHomePage.insertDates();
		carHomePage.clickCarSearchButton(carSearchPage);

		// Filter cars for van type
		carSearchPage.clickAndWaitToReload(carSearchPage.getCarTypeVanCheckBox());

		// Select the first car in the list
		carSearchPage.selectFirstAvailableCar();

		SeLionReporter.log(Grid.driver().getTitle(), true, true);

	}

	public void setFlightLocation1String(String flightLocation1String) {
		this.flightLocation1String = flightLocation1String;
	}

	public void setFlightLocation2String(String flightLocation2String) {
		this.flightLocation2String = flightLocation2String;
	}

}
