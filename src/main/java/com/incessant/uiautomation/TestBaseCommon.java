package com.incessant.uiautomation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.FWUtility;
import com.incessant.uiautomation.util.XLReader;

public class TestBaseCommon {
	
	private static String curUserName;
	
	/**
	 * 
	 * @return
	 */
	public static WebDriver getDriver(String browserType) {
		WebDriver driver = DriverFactory.localDriver(getDefaultCapabilities(browserType));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	
	/**
	 * 
	 * 
	 * @param caps
	 * @return
	 */
	public WebDriver getDriver(Capabilities caps) {
		WebDriver driver = DriverFactory.localDriver(caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getConfiguredBrowserType() {
		String configuredBrowserType = ConfPropertyReader.getConfPropertyReader().getProperty(FwConstants.CONFFILEPATH, "BROWSER_TYPE");
		if(!FWUtility.isEmpty(configuredBrowserType)) {
			return configuredBrowserType;
		} else {
			return DriverType.FIREFOX.toString();
		}
	}
	public static String Cust_getConfiguredBrowserType() {
		String configuredBrowserType = ConfPropertyReader.getConfPropertyReader().getProperty(FwConstants.CONFFILEPATH, "BROWSER_TYPE");
		if(!FWUtility.isEmpty(configuredBrowserType)) {
			return configuredBrowserType;
		} else {
			return DriverType.FIREFOX.toString();
		}
	}
	
	/**
	 * 
	 * @param browserType
	 * @return
	 */
	private static Capabilities getDefaultCapabilities(String browserType) {
		 if(null == browserType || "".equals(browserType)) {
			 System.out.println("BROWSER TYPE CAN'T BE NULL OR EMPTY");
			 System.exit(1);
		 }
		 
		 DesiredCapabilities desisedCaps = new DesiredCapabilities();
		
		 if(browserType.equals(DriverType.FIREFOX.toString())) {
			 desisedCaps.setBrowserName(browserType);
			 desisedCaps.setCapability("locationContextEnabled", false);
		 } else if(browserType.equals(DriverType.CHROME.toString())) {
			 desisedCaps.setBrowserName(browserType);
			 System.setProperty("webdriver.chrome.driver", FwConstants.CHROME_EXE_PATH);
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
             ChromeOptions options = new ChromeOptions();
             options.addArguments("disable-extensions");
             options.addArguments("--start-maximized");
             capabilities.setCapability(ChromeOptions.CAPABILITY, options);
             capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		 } else if(browserType.equals(DriverType.IE.toString())) {
			 desisedCaps.setBrowserName(browserType);
		 } else if(browserType.equals(DriverType.PHANTOM.toString())) {
			 desisedCaps.setBrowserName(DriverType.PHANTOM.toString());
			 DesiredCapabilities caps = new DesiredCapabilities();
             caps.setJavascriptEnabled(true); /// not really needed: JS enabled by default
             caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
             System.setProperty(
             PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\varunp1\\Documents\\My Received Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		 } else {
			 //Future use.
		 }
		 
		 return desisedCaps;
	}
	
	/**
	 * 
	 * @param driver
	 */
	public static void closeBrowser(WebDriver driver) { 
		try {
			driver.quit();
		} catch(Exception eee) {
			System.out.println("---------------------------------------------------------");
			System.out.println("**************** Error while perfoming driver quit *********************");
			System.out.println("---------------------------------------------------------");
			eee.printStackTrace();
		}
	}
	

	/**
	 * 
	 * @param map
	 * @return
	 *//*
	public boolean login(List<Map<String, String>> users, WebDriver driver) {
		String currentUserName = users.get(0).get(FwConstants.HEADER_NAME_USERNAME);
		String password = users.get(0).get(FwConstants.HEADER_NAME_PASSWORD);
		curUserName = currentUserName;
		return Login.login(currentUserName, password, driver);
	}
	
	*//**
	 * 
	 * @param users
	 * @param driver
	 * @return
	 *//*
	public boolean nonSsoLogin(List<Map<String, String>> users, WebDriver driver){
		String currentUserName = users.get(0).get(FwConstants.HEADER_NAME_USERNAME);
		String password = users.get(0).get(FwConstants.HEADER_NAME_PASSWORD);
		curUserName = currentUserName;
		return Login.nonSsoLogin(currentUserName, password, driver);
		
	}
	
	*//**
	 * 
	 * @param map
	 * @return
	 *//*
	public boolean login(Map<String, String> user, WebDriver driver) {
		String currentUserName = user.get(FwConstants.HEADER_NAME_USERNAME);
		String password = user.get(FwConstants.HEADER_NAME_PASSWORD);
		curUserName = currentUserName;
		Reporter.log("Logging in as " + user.get(FwConstants.HEADER_NAME_USERTYPE));
		return Login.login(currentUserName, password, driver);
	}
	
	
	public boolean nonSsoLogin(Map<String, String> user, WebDriver driver) {
		String currentUserName = user.get(FwConstants.HEADER_NAME_USERNAME);
		String password = user.get(FwConstants.HEADER_NAME_PASSWORD);
		curUserName = currentUserName;
		Reporter.log("Logging in as " + user.get(FwConstants.HEADER_NAME_USERTYPE));
		return Login.nonSsoLogin(currentUserName, password, driver);
	}
	
	*//**
	 * 
	 * @return
	 *//*
	public static String getCurrentUser() {
		return curUserName;
	}
	
	*//**
	 * 
	 * @param data
	 * @return
	 *//*
	
	public boolean getActualValue(String caseId) {
		return null != caseId && !"".equals(caseId) &&  !" ".equals(caseId) ? true : false;
	}
	
	
	*/
	public static void initializeLogger() {
		PropertyConfigurator.configure(FwConstants.Log4j_Properties_File);
	}
	
	/**
	 * 
	 * @param testName
	 */
	public static void printTestCaseStartMsg(String testName) {
		System.out.println("Starting the test case ->  " + testName);
	}
	
	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param testName
	 */
	public static void printTestCaseResult(boolean actual, boolean expected, String testName) {
		if(actual == expected) {
			System.out.print(testName + "	--------> Pass");
			System.out.print("\n");
		} else {
			System.out.print(testName + "	--------> Fail");
			System.out.print("\n");
		}
	}

}
