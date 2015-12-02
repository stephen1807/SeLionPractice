package com.symbio.test.componentext;

import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.HotelConfirmationPage;
import com.paypal.selion.testcomponents.HotelDetailPage;
import com.symbio.test.utility.Utility;

/**
 * Extension of HotelDetailPage generated class
 * 
 * @author Stephen Raharja
 *
 */
public class HotelDetailPageExt extends HotelDetailPage {

	private HotelConfirmationPage hotelConfirmationPage = new HotelConfirmationPage();
	
	/**
	 * Click on the first available room type
	 */
	public void clickFirstAvailableRoom() {
		this.getHotelRoomOptionsContainer(0).getBookRoomButton().click();
		
		if (this.getPayLaterButton().isVisible()){
			this.getPayLaterButton().click();
		}
		
		WebDriverWaitUtils.waitUntilPageIsValidated(hotelConfirmationPage);
	}
}
