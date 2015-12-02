package com.symbio.test.componentext;

import com.paypal.selion.platform.html.AbstractElement;
import com.paypal.selion.platform.html.Link;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.HotelSearchPage;
import com.symbio.test.utility.Utility;

/**
 * Extension of the HotelSearchPage generated class
 * 
 * @author Stephen Raharja
 *
 */
public class HotelSearchPageExt extends HotelSearchPage {

	private Utility utility = new Utility();

	/**
	 * Get hotels that are 4 stars and above
	 */
	public void filterHotelByMinimumFourStars() {
		clickAndWaitForReload(this.getFourStarsCheckBox());
		clickAndWaitForReload(this.getFiveStarsCheckBox());
	}

	/**
	 * Click element and wait for the result to reload
	 */
	public void clickAndWaitForReload(AbstractElement webElement) {
		webElement.click(!this.getLoaderPopupLabel().isVisible());
	}

	/**
	 * Click the first result and go to the new window
	 */
	public void clickFirstSearchResultLink() {
		// Click the first hotel in list
		this.getSearchResultContainer(0).getHotelNameLink().click();

		// Switch window
		utility.switchToNewWindow();

		// Wait until page is loaded
		WebDriverWaitUtils.waitUntilPageIsValidated(new HotelDetailPageExt());

	}
	
	/**
	 * Search for a hotel name
	 */
	public void searchHotelName(String hotelName){
		//Type into the search textfield
		utility.simulateTypingToTextField(hotelName, this.getHotelNameSearchTextField());
		
		//Wait until the suggestion pop-up appears
		WebDriverWaitUtils.waitUntilElementIsVisible(this.getHotelNameSuggestionContainer().getLocator());
		
		//Choose the first suggestion
		this.getHotelNameSuggestionContainer(0).click();
		
		//Click the search button and wait for the hotel list to reload
		this.clickAndWaitForReload(this.getHotelNameSearchButton());
	}

}
