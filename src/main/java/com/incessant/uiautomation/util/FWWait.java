package com.incessant.uiautomation.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FWWait {

	/** The amount of time to wait before giving up; the default is 30 seconds */
	public static final int DEFAULT_TIMEOUT = 30;

	/** The interval to pause between checking; the default is 5 seconds */
	public static final int DEFAULT_POLLING_INTERVAL = 5;

	public FWWait() {
	}

	String locatorValue = null;

	/*
	 * public WebElement findWebElement(WebDriver driver, final By locator) {
	 * //this.locatorValue = xPath; Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
	 * .pollingEvery(DEFAULT_POLLING_INTERVAL,
	 * TimeUnit.SECONDS).ignoring(NoSuchElementException.class); WebElement
	 * webElement = wait.until(new Function<WebDriver, WebElement>() { public
	 * WebElement apply(WebDriver driver) {
	 * //System.out.println("ID Locator value used is -> " + locatorValue); return
	 * driver.findElement(locator); } }); return webElement; }
	 */

	public WebElement findWebElementById(WebDriver driver, String xPath) {
		this.locatorValue = xPath;
		// Wait<WebDriver> wait = new
		// FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// System.out.println("ID Locator value used is -> " + locatorValue);
				return driver.findElement(By.id(FWWait.this.locatorValue));
			}
		});
		return webElement;
	}

	public WebElement findWebElementByXPath(WebDriver driver, String xPath) {
		this.locatorValue = xPath;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// System.out.println("XPath Locator value used is -> " + locatorValue);
				return driver.findElement(By.xpath(FWWait.this.locatorValue));
			}
		});
		return webElement;
	}

	public WebElement findWebElementByCssSelector(WebDriver driver, String cssSelector) {
		this.locatorValue = cssSelector;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// System.out.println("Css Selector Locator value used is -> " + locatorValue);
				return driver.findElement(By.cssSelector(FWWait.this.locatorValue));
			}
		});
		return webElement;
	}

	public WebElement findWebElementByLinkText(WebDriver driver, String linkText) {
		this.locatorValue = linkText;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(DEFAULT_POLLING_INTERVAL, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// System.out.println("LinkText ocator value used is -> " + locatorValue);
				return driver.findElement(By.linkText(FWWait.this.locatorValue));
			}
		});
		return webElement;
	}

}
