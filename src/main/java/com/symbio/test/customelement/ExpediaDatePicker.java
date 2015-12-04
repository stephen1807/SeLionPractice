package com.symbio.test.customelement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.AbstractElement;
import com.paypal.selion.platform.html.Button;
import com.paypal.selion.platform.html.Label;
import com.paypal.selion.platform.html.ParentTraits;

public class ExpediaDatePicker extends AbstractElement {

	private Label currentCalendarLabel = new Label("css=.cal section:nth-child(2) > header > h2");
	private Button nextMonthButton = new Button("css=.cal .btn-paging.next");
	private String dateLocator = ".cal section:nth-child(2) .cal-dates > li .cal-date";

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

	/**
	 * Click the targeted date in the date picker only the left section
	 * 
	 * @param targetDate
	 *            Desired date
	 * @throws ParseException
	 */
	public void clickDate(Date targetDate) throws ParseException {

		// Initialize calendar
		Calendar targetCalendar = new GregorianCalendar();
		Calendar currentCalendar = new GregorianCalendar();
		targetCalendar.setTime(targetDate);

		// Format the calendar into the same format as the label in calendar
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy", new Locale("English"));

		while (true) {

			currentCalendar.setTime(simpleDateFormat.parse(currentCalendarLabel.getText()));

			// Compare year
			if (currentCalendar.get(Calendar.YEAR) < targetCalendar.get(Calendar.YEAR)) {
				// If earlier than targeted year, click next month button
				nextMonthButton.click();
			} else {

				// Compare month
				if (currentCalendar.get(Calendar.MONTH) < targetCalendar.get(Calendar.MONTH)) {
					// If earlier than targeted month, click next month button
					nextMonthButton.click();
				} else {

					List<WebElement> dateLists = Grid.driver()
							.findElementsByCssSelector(dateLocator);

					// Loop through all dates in the current calendar
					for (int loopIndex = 0; loopIndex < dateLists.size(); loopIndex++) {
						// Compare the current date with targeted date
						if (dateLists.get(loopIndex).getText()
								.equals(String.valueOf(targetCalendar.get(Calendar.DAY_OF_MONTH)))) {
							// Click targeted date
							dateLists.get(loopIndex).click();
							return;
						}
					}
				}
			}
		}

	}

}
