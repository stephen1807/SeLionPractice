package com.symbio.test.componentext;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.testcomponents.FlightConfirmationPage;

public class FlightConfirmationPageExt extends FlightConfirmationPage{
	

	public void check(){
		
		System.out.println(this.getFirstToLabel().getValue());
		
		System.out.println(this.getSecondToLabel().getValue());
		
		Grid.driver().close();
	}

}
