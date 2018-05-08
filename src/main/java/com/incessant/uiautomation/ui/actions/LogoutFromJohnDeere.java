package com.incessant.uiautomation.ui.actions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.FWWait;

public class LogoutFromJohnDeere {

	private static Logger logger = Logger.getLogger(LogoutFromJohnDeere.class);

	public static void logOut(WebDriver driver) {
		try {
			Properties props = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath(props.getProperty("JohnDeereUserLink"))).click();
			FWWait wait=new FWWait();
			wait.findWebElementByXPath(driver, props.getProperty("JohnDeereLogout"));
			driver.findElement(By.xpath(props.getProperty("JohnDeereLogout"))).click();
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {
			logger.error("Error in Logout " + e.getLocalizedMessage());
		} catch (InterruptedException e) {
			logger.error("Error in Logout " + e.getLocalizedMessage());
		} catch (Exception e) {
			logger.error("Error in Logout " + e.getLocalizedMessage());
		}
	}
}