package com.symbio.test.componentext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.paypal.selion.testcomponents.DatePickerModule;

/**
 * Extension of the DatePickerModule generated class
 * 
 * @author Stephen Raharja
 *
 */
public class DatePickerModuleExt extends DatePickerModule {

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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy");

		while (true) {
			currentCalendar.setTime(simpleDateFormat.parse(this.getCurrentCalendarLabel().getText()));

			// Compare year
			if (currentCalendar.get(Calendar.YEAR) < targetCalendar.get(Calendar.YEAR)) {
				// If earlier than targeted year, click next month button
				this.getNextMonthButton().click();
			} else {
				
				//Compare month
				if (currentCalendar.get(Calendar.MONTH) < targetCalendar.get(Calendar.MONTH)) {
					//If earlier than targeted month, click next month button
					this.getNextMonthButton().click();
				} else {
					// Loop through all dates in the current calendar
					for (int loopIndex = 0; loopIndex < this.getDateContainer().size(); loopIndex++) {
						
						// Compare the current date with targeted date
						if (this.getDateContainer(loopIndex)
								.equals(String.valueOf(targetCalendar.get(Calendar.DAY_OF_MONTH)))) {
							//Click targeted date
							this.getDateContainer(loopIndex).click();
							return;
						}
					}
				}
			}
		}
	}

}
