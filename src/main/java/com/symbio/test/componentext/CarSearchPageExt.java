package com.symbio.test.componentext;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.AbstractElement;
import com.paypal.selion.platform.html.CheckBox;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.CarDetailPage;
import com.paypal.selion.testcomponents.CarSearchPage;
import com.symbio.test.utility.Utility;

/**
 * Extension of CarSearchPage generated class
 * 
 * @author Stephen Raharja
 *
 */
public class CarSearchPageExt extends CarSearchPage {

	private Utility utility = new Utility();

	/**
	 * Method used to click any filter / sort functions in the search page. It
	 * will wait for the result to be refreshed
	 * 
	 * @param webElement
	 *            Filtering element to be clicked (checkbox, sort button)
	 */
	@SuppressWarnings("resource")
	public void clickAndWaitToReload(AbstractElement webElement) {

		// Get the number of cars before click
		Scanner scanner = new Scanner(this.getSearchLegendLabel().getText()).useDelimiter("[^0-9]+");
		final int totalCarOriginalInteger = scanner.nextInt();

		// Wait until element is visible
		WebDriverWaitUtils.waitUntilElementIsVisible(webElement.getLocator());
		// Click the element
		webElement.click();

		// Wait until car search result is refreshed
		new WebDriverWait(Grid.driver(), 10).until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver input) {

				CarSearchPage carSearchPage = new CarSearchPage();

				Scanner scanner = new Scanner(carSearchPage.getSearchLegendLabel().getText()).useDelimiter("[^0-9]+");
				int totalCarInteger = scanner.nextInt();

				// Compare the int, if changed, end wait
				return totalCarOriginalInteger != totalCarInteger;
			}
		});

	}

	/**
	 * Click the first car in the search result and wait for the confirmation
	 * page
	 */
	public void selectFirstAvailableCar() {
		this.getSearchResultContainer(0).getSelectResultButton().click();
		utility.switchToNewWindow();
		WebDriverWaitUtils.waitUntilPageIsValidated(new CarDetailPage());
	}
}
