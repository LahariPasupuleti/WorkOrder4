package com.incessant.uiautomation.util;

	import java.util.Map;
	import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
	import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.TestBaseCommon;
import com.incessant.uiautomation.ui.actions.ProcessFlowActions;
import com.incessant.uiautomation.util.ConfPropertyReader;
	import com.incessant.uiautomation.util.FWUtility;
	import com.incessant.uiautomation.util.FWWait;

	public class Customer_JohnDeere_URLS {
		  WebDriver driver=null;
     private static Logger logger = Logger.getLogger(Customer_JohnDeere_URLS.class);
    

		public   WebDriver Customer_URLS(WebDriver driver,String Country ) throws Exception {
			
			//Headlsee Mode 
			/*System.setProperty("webdriver.chrome.driver",
                    "D:\\Selenium\\LIB\\Chrome Driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--start-maximized");
			options.addArguments("--headless");
            driver = new ChromeDriver(options);*/
		System.setProperty("webdriver.chrome.driver", "D:\\JohnDeereAutomation\\resources\\Dirvers\\chromedriver.exe");
	    	driver=new ChromeDriver();
	    	driver.manage().window().maximize();
//	    	
	switch(Country){
		case "TechPubs": 
      driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=TechPubs");
      System.out.println("TechPubs Url opened successfully");
		ProcessFlowActions.TechPubs_Support(driver);
		break;
		case "Deere.com": 
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=Deere.com");
			Thread.sleep(6000);
			System.out.println("Deere.com Url opened successfully");
			ProcessFlowActions.Deere_Webform(driver);

		break;
		case "India": 
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=India");
			Thread.sleep(6000);
			System.out.println("India Url opened successfully");
			ProcessFlowActions.IndiaCountry(driver);
			driver.quit();
		break;
		case "GreenFleet": 
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=GreenFleet");
			Thread.sleep(6000);
			System.out.println("GreenFleet Url opened successfully");
		break;
		case "R4 Turf": 
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=R4+Turf");
			Thread.sleep(6000);
			System.out.println("R4 Turf Url opened successfully");
			ProcessFlowActions.R4Turf_tier1(driver);
		break;
		case "R4 AgCC":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=R4+AgCC");
			Thread.sleep(6000);
			System.out.println("R4 AgCC Url opend successfully");
			ProcessFlowActions.R4Agcc_Support(driver);
		break;
		case "Sub Sahara South Africa":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=Sub-Sahara+South+Africa");
			Thread.sleep(6000);
			System.out.println("Sub Sahara South Africa Url opend successfully");
			ProcessFlowActions.SaharaSouthAfrica(driver);
			
		break;
		case "South East Asia":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=South+East+Asia");
			Thread.sleep(6000);
			System.out.println("South East Asia Url opend successfully");
		break;
		case "JDParts":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-GSC.SnapStartCreateCase&MashUp=JDParts");
			Thread.sleep(6000);
			System.out.println("JDParts Url opend successfully");
			ProcessFlowActions.JDParts(driver);
			driver.quit();
		break;
		case "Agronomy":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-ISG.SnapStartCreateCase&MashUp=Agronomy");
			System.out.println("Agronomy Url opend successfully");
			ProcessFlowActions.AgronomyCountry(driver);
			driver.quit();
		break;
		case "JDLink":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-ISG.SnapStartCreateCase&MashUp=JDLink+Dashboard/Operation+Center");
			Thread.sleep(6000);
			System.out.println("JDLink Url opend successfully");
			ProcessFlowActions.JDLink_Webform(driver);
		break;
		case "Stellar_Support":
			driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-ISG.SnapStartCreateCase&MashUp=Stellar+Support");
			Thread.sleep(6000);
			System.out.println("Stellar Support Url opend successfully");
			ProcessFlowActions.Stellar_support(driver);
			
		break;
		default: //Default case
		System.out.println("Default case");
		break;
		            }
	
		
		
		//driver.quit();
	     return driver;
		
		}
		public Customer_JohnDeere_URLS(WebDriver driver) {
			this.driver = driver;
		}
		
	}