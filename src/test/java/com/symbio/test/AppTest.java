package com.symbio.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.grid.Grid;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	@Test
	@WebTest
	public void test() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy");
		Date date = new Date();
		try {
			date = simpleDateFormat.parse("DEC 2015");
		} catch (ParseException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		System.out.println(date);
	}
}
