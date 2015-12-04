package com.symbio.test.utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.TextField;

/**
 * Utility class containing methods used in other methods
 * 
 * @author Stephen Raharja
 *
 */
public class Utility {

	/**
	 * Calculate the date of the next Monday. Will return next week's Monday if
	 * today is Monday
	 * 
	 * @return Date of next available Monday
	 */
	public Date getNextMonday() {

		// Initialize date
		Calendar currentCalendar = new GregorianCalendar();
		currentCalendar.setTime(new Date());

		// Calculate number of days required to add
		int daysToAddInteger = Calendar.MONDAY - currentCalendar.get(Calendar.DAY_OF_WEEK);

		// Adjust calendar to the next Monday
		// If adjustment is negative, add 7 for getting next week's
		currentCalendar.add(Calendar.DAY_OF_YEAR, (daysToAddInteger <= 0) ? daysToAddInteger + 7 : daysToAddInteger);

		return currentCalendar.getTime();
	}

	/**
	 * Add a number of weeks into the input date
	 * 
	 * @param inputDate
	 *            Base date
	 * @param numberOfWeeksInteger
	 *            Number of weeks to add
	 * @return Resulted date after addition
	 */
	public Date addWeekToDate(Date inputDate, int numberOfWeeksInteger) {

		Calendar currentCalendar = new GregorianCalendar();
		currentCalendar.setTime(inputDate);

		currentCalendar.add(Calendar.DAY_OF_YEAR, 7 * numberOfWeeksInteger);

		return currentCalendar.getTime();
	}

	/**
	 * Switch to the new window
	 * 
	 * @param existedHandles
	 *            The set of handles before the new handle come up
	 * 
	 */
	public void switchToNewWindow(List<String> existedHandles) {

		Set<String> handles = Grid.driver().getWindowHandles();
		String currentHandle = Grid.driver().getWindowHandle();
		for (String newHandle : handles) {
			if (!newHandle.equals(currentHandle) && !existedHandles.contains(newHandle)) {
				Grid.driver().switchTo().window(newHandle);
			}
		}
	}

	/**
	 * Switch to the new window
	 * 
	 * @param existedHandles
	 *            The set of handles before the new handle come up
	 * 
	 */
	public void switchToNewWindow(Set<String> existedHandles) {

		this.switchToNewWindow(new ArrayList<String>(existedHandles));
	}

	/**
	 * Switch to the new window
	 * 
	 */
	public void switchToNewWindow() {
		this.switchToNewWindow(new ArrayList<String>());
	}

	/**
	 * Type a string as each character with small pause between
	 * 
	 * @param inputString
	 *            String to input
	 * @param targetTextField
	 *            Target textfield
	 */
	public void simulateTypingToTextField(String inputString, TextField targetTextField) {

		// Loop through all characters in a string
		for (int loopIndex = 0; loopIndex < inputString.length(); loopIndex++) {
			targetTextField.type(String.valueOf(inputString.charAt(loopIndex)), true);

			// Small pause between each character
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}