package com.incessant.uiautomation;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class DriverFactory {

	public static WebDriver localDriver(Capabilities capabilities) {

		String browserType = null != capabilities ? capabilities.getBrowserName() : "Unknown";
		if (browserType.equals(DriverType.FIREFOX.toString())) {
			/*
			 * if
			 * (Boolean.parseBoolean(ConfPropertyReader.getConfPropertyReader().getProperty(
			 * FwConstants.CONFFILEPATH, "CUSTOM_FIREFOX"))) {
			 */
			System.setProperty("webdriver.gecko.driver",
					"D:\\JohnDeereAutomation\\resources\\Dirvers\\geckodriver.exe");
			return new FirefoxDriver(capabilities);
			/*
			 * else { return new FirefoxDriver(capabilities); }
			 */
		} else if (browserType.equals(DriverType.IE.toString())) {
			System.setProperty("webdriver.ie.driver",
					"D:\\JohnDeereAutomation\\resources\\Dirvers\\IEDriverServer.exe");
			// obj= new InternetExplorerDriver(ieCaps);
			return new InternetExplorerDriver(capabilities);
		} else if (browserType.equals(DriverType.CHROME.toString())) {
			// For Chrome we may need to set absolute path of executable as System property.
			System.setProperty("webdriver.chrome.driver",
					"D:\\JohnDeereAutomation\\resources\\Dirvers\\chromedriver.exe");

			// driver= new ChromeDriver(chromeOptions);
			return new ChromeDriver(capabilities);
			/*
			 * } else if (browserType.equals(DriverType.PHANTOM.toString())) { return new
			 * PhantomJSDriver(capabilities);
			 */

		} else {
			throw new Error("Browser type Not supported : " + browserType);
		}
	}

}
