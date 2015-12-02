package com.symbio.test.customelement;

import java.util.List;

import com.paypal.selion.platform.html.AbstractElement;
import com.paypal.selion.platform.html.Button;
import com.paypal.selion.platform.html.Container;
import com.paypal.selion.platform.html.Label;
import com.paypal.selion.platform.html.Link;
import com.paypal.selion.platform.html.ParentTraits;

public class ExpediaDatePicker extends AbstractElement {

	private Label currentCalendarLabel = new Label("css=.cal section:nth-child(2) > header > h2");
	private Button nextMonthButton = new Button("css=.cal .btn-paging.next");
	private Link dateContainer = new Link("css=.cal section:nth-child(2) .cal-dates > li");
	
	public ExpediaDatePicker(ParentTraits parent, String locator) {
		super(parent, locator);
	}

	public ExpediaDatePicker(String locator) {
		super(locator);
	}

	public ExpediaDatePicker(String locator, String controlName) {
		super(locator, controlName);
	}

	public ExpediaDatePicker(String locator, String controlName, ParentTraits parent) {
		super(locator, controlName, parent);
	}

}
