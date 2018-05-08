package com.incessant.uiautomation.ui.actions;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.FWUtility;
import com.incessant.uiautomation.util.FWWait;

public class LoginToJohnDeere {

	private static Logger logger = Logger.getLogger(LoginToJohnDeere.class);

	public static boolean logintoJohndeere(String userName, String password, WebDriver driver) {
		Reporter.log("Logging in as : " + userName);
		logger.debug("Logging in as --> " + userName);
		boolean isLoginSuccess = true;
		driver.get(ConfPropertyReader.getConfPropertyReader().getProperty(FwConstants.CONFFILEPATH, "URL"));
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		FWUtility.turnOffImplicitWait(driver);
		FWWait wait = new FWWait();
		wait.findWebElementByXPath(driver, locators.getProperty("JohnDeereuserName")).sendKeys(userName);
		wait.findWebElementByXPath(driver, locators.getProperty("JohnDeerepassWord")).sendKeys(password);
		wait.findWebElementByXPath(driver, locators.getProperty("JohnDeereSubmitButton")).click();
		FWUtility.turnOnImplicitWait(driver);
		if (LoginToJohnDeere.isCredentilasValid(driver)) {
			Reporter.log("Login successful for user " + userName);
		} else {
			isLoginSuccess = false;
			Reporter.log("Login not successful. Please verify the credentials for user " + userName);
		}

		return isLoginSuccess;
	}
	public static boolean Customer_logintoJohndeere(String userName, String password, WebDriver driver) {
		Reporter.log("Logging in as : " + userName);
		logger.debug("Logging in as --> " + userName);
		boolean isLoginSuccess = true;
		driver.get(ConfPropertyReader.getConfPropertyReader().getProperty(FwConstants.CONFFILEPATH, "URL_Cus"));
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		FWUtility.turnOffImplicitWait(driver);
		FWWait wait = new FWWait();
		wait.findWebElementByCssSelector(driver, locators.getProperty("CustomeruserName")).sendKeys(userName);
		wait.findWebElementByCssSelector(driver, locators.getProperty("CustomerpassWord")).sendKeys(password);
		wait.findWebElementByXPath(driver, locators.getProperty("CustomerSubmitButton")).click();
		FWUtility.turnOnImplicitWait(driver);
		if (LoginToJohnDeere.isCredentilasValid(driver)) {
			Reporter.log("Login successful for user " + userName);
		} else {
			isLoginSuccess = false;
			Reporter.log("Login not successful. Please verify the credentials for user " + userName);
		}

		return isLoginSuccess;
	}
	public static boolean loginToPega(String userName, String password, WebDriver driver) {

		Reporter.log("Logging in as : " + userName);
		logger.debug("Logging in as --> " + userName);
		boolean isLoginSuccess = true;
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		FWUtility.turnOffImplicitWait(driver);
		FWWait wait = new FWWait();
		wait.findWebElementById(driver, locators.getProperty("PegaUserName")).sendKeys(userName);
		wait.findWebElementById(driver, locators.getProperty("PegaPassWord")).sendKeys(password);
		wait.findWebElementById(driver, locators.getProperty("PegaSubmitButton")).click();
		FWUtility.turnOnImplicitWait(driver);
		if (LoginToJohnDeere.isCredentilasValid(driver)) {
			Reporter.log("Login successful for user " + userName);
		} else {
			isLoginSuccess = false;
			Reporter.log("Login not successful. Please verify the credentials for user " + userName);
		}

		return isLoginSuccess;
	}

	public static boolean isCredentilasValid(WebDriver driver) {
		boolean isValidCred = true;
		try {
			WebElement loginFailureElement = driver.findElement(By.id(ConfPropertyReader.getConfPropertyReader()
					.getProperties(FwConstants.LOCATORS).getProperty("JDLoginErrorMessage")));
			if (loginFailureElement != null) {
				return false;
			}
		} catch (NoSuchElementException noElement) {
			isValidCred = true;
		}

		return isValidCred;

	}

}
