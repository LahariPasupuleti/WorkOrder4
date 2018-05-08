package com.johndeere.automation;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.ui.actions.LoginToJohnDeere;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.FWUtility;
import com.incessant.uiautomation.util.FWWait;

public class JohnDeereLogin {

private static Logger logger = Logger.getLogger(LoginToJohnDeere.class);
	

	public static boolean login(String userName, String password, WebDriver driver) {
		Reporter.log("Logging in as : " + userName);
		logger.debug("Logging in as --> " + userName);
		boolean isLoginSuccess = true;
		driver.get(ConfPropertyReader.getConfPropertyReader().getProperty(FwConstants.CONFFILEPATH,"URL"));
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		FWUtility.turnOffImplicitWait(driver);
		FWWait wait = new FWWait();
		wait.findWebElementById(driver, locators.getProperty("JohnDeereuserName")).sendKeys(userName);
		wait.findWebElementById(driver, locators.getProperty("JohnDeerepassWord")).sendKeys(password);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		wait.findWebElementById(driver, locators.getProperty("JohnDeereSubmitButton")).click();
		FWUtility.turnOnImplicitWait(driver);
		if(LoginToJohnDeere.isCredentilasValid(driver)) {
			Reporter.log("Login successful for user " + userName);
		} else {
			isLoginSuccess = false;
			Reporter.log("Login not successful. Please verify the credentials for user " + userName);
		}
		
		return isLoginSuccess;
	}
	
	
	
}
