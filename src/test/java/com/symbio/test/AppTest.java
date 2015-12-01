package com.symbio.test;

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
		Grid.open("http://www.expedia.com");
	}
}
