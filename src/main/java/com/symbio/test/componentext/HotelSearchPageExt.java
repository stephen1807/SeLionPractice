package com.symbio.test.componentext;

import com.paypal.selion.testcomponents.HotelSearchPage;

/**
 * Extension of the HotelSearchPage generated class
 * 
 * @author Stephen Raharja
 *
 */
public class HotelSearchPageExt extends HotelSearchPage {

	/**
	 * Get hotels that are 4 stars and above
	 */
	public void filterHotelByMinimumFour() {
		this.getFourStarsCheckBox().click(this.getSearchResultContainer());
		this.getFiveStarsCheckBox().click(this.getSearchResultContainer());
	}

}
