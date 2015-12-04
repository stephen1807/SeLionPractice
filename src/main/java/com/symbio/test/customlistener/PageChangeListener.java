package com.symbio.test.customlistener;

import com.paypal.selion.configuration.Config;
import com.paypal.selion.configuration.Config.ConfigProperty;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.support.events.AbstractElementEventListener;
import com.paypal.selion.platform.html.support.events.Checkable;
import com.paypal.selion.platform.html.support.events.Clickable;
import com.paypal.selion.platform.html.support.events.Selectable;
import com.paypal.selion.platform.html.support.events.Typeable;
import com.paypal.selion.reports.runtime.SeLionReporter;

public class PageChangeListener extends AbstractElementEventListener {

	private static ThreadLocal<Boolean> interactedWithPage = new ThreadLocal<Boolean>() {
		@Override
		protected Boolean initialValue() {
			return false;
		}
	};

	public PageChangeListener() {
		Config.setConfigProperty(ConfigProperty.AUTO_SCREEN_SHOT, "true");
	}

	/**
	 * This event will be fired before any click() action in ANY
	 * com.paypal.selion.platform.html element object.
	 * 
	 * @param target
	 *            The element target.
	 * @param expected
	 *            The expected conditions after the click.
	 */
	public void beforeClick(Clickable target, Object... expected) {

		// If an expected object is provided to the click method we take a
		// screenshot.
		if (expected != null && expected.length != 0 && interactedWithPage.get()) {
			SeLionReporter.log(Grid.driver().getTitle(), true, true);
		}
		
	}

	/**
	 * This event will be fired after any click() action in ANY
	 * com.paypal.selion.platform.html element object.
	 * 
	 * @param target
	 *            The element target.
	 * @param expected
	 *            The expected conditions after the click.
	 */
	public void afterClick(Clickable target, Object... expected) {
		if (expected != null && expected.length != 0) {
			reset();
		}
	}

	/**
	 * If anything is typed, it means page has been interacted
	 */
	public void afterType(Typeable target, String value) {
		interactedWithPage.set(true);
	}

	/**
	 * If anything is selected, it means page has been interacted
	 */
	public void afterSelect(Selectable target, String value) {
		interactedWithPage.set(true);
	}

	/**
	 * If anyting is checked, it means page has been interacted
	 */
	public void afterCheck(Checkable target, String expected) {
		interactedWithPage.set(true);
	}

	public static void reset() {
		interactedWithPage.set(false);
	}

}
