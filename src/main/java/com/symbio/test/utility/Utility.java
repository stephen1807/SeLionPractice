package com.symbio.test.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

}