package com.incessant.uiautomation.ui.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.FWUtility;
import com.incessant.uiautomation.util.XLReader;

/**
 * 
 * 
 * @author varunp1
 *
 */
public class MenuActions {
	
	private static Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
	public static boolean isMenuExists(String menuName, WebDriver driver) {
		try {
			driver.findElement(By.linkText(menuName)).click();
			Reporter.log(menuName + " exists.");
		} catch(NoSuchElementException noElement) {
			Reporter.log(noElement.getLocalizedMessage());
			return false;
		}
		return true;
	}
	
	public boolean isMenuEnabled(String menuName, WebDriver driver) {
		
		return true;
		
	}
	
	public void clickOnDesignerStudio(WebDriver driver){
		
		driver.findElement(By.xpath(locators.getProperty("designerStudio")));
		
	}
	
	public static void compareWithExpectedMenuValues(WebDriver driver) {
		 Set<String> actualVisibleMenus = new HashSet<String>();
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			List<WebElement> menu = driver.findElements(By.cssSelector(locators.getProperty("menu_items")));
			for (WebElement name : menu) {
				String menuName = name.getText();
				if (!"".equals(menuName)) { // Avoiding empty element scopes
					actualVisibleMenus.add(menuName);
				} else {
					System.out.println("Menu Items - " + menuName);
				}
				System.out.println(menuName);
			}
			System.out.println(actualVisibleMenus.size());
			Set<String> expectedvalues = XLReader.getCellValues(FwConstants.ALL_DATA, "Menu Details");
			System.out.println(expectedvalues.size());

			if (actualVisibleMenus.size() == expectedvalues.size() && actualVisibleMenus.containsAll(expectedvalues)) {
				System.out.println("menu names are matching");
			} else {
				System.out.println("menu names are not matching");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getAllMenuNames(WebDriver driver) {
		List<String> actualmenuvalues = new ArrayList<String>();
		List<WebElement> menu = driver.findElements(By.xpath(locators.getProperty("menu_items")));
		System.out.println("Actual Menus size is -> " + menu.size());
		for (WebElement name : menu) {
			String menuName = name.getText();
			actualmenuvalues.add(menuName);
		}
		System.out.println("Actual Menu names are -> " + actualmenuvalues);
		return actualmenuvalues;

	}
	 public static void clickOnCaseSearch(WebDriver driver) throws InterruptedException{
	     try{
	              driver.findElement(By.xpath(locators.getProperty("CaseSearch"))).click();
	              Thread.sleep(5000);
	         }catch(NoSuchElementException noe)
	          {
	            noe.printStackTrace();
	          }
	     }//end of clickOnCaseSearch


	
	public static List<String> getAllMenuNamesOfAnApplication(WebDriver driver, String menusLocators) {
		List<String> actualmenuvalues = new ArrayList<String>();
		List<WebElement> menu = driver.findElements(By.xpath(menusLocators));
		System.out.println("Expected Menus size is -> " + menu.size());
		for (WebElement name : menu) {
			String menuName = name.getText();
			actualmenuvalues.add(menuName);
		}
		Reporter.log("Actual Menu names  are -> "+ actualmenuvalues);
		System.out.println("Actual Menu names are -> " + actualmenuvalues);
		return actualmenuvalues;

	}
	
	public static boolean compareMenuitems(WebDriver driver,String roleType){
		boolean isMenuitemsMatched = false;
				try{
				List<String> actualVisibleMenus = getAllMenuNames(driver);
				List<String> expectedvalues =FWUtility.parseMenusXml(roleType, FwConstants.Menus_Xml_File);
				System.out.println("Expected Menus size is -> "+ expectedvalues.size());
				System.out.println("Expected Menu names  are -> "+ expectedvalues);
				if (actualVisibleMenus.size() == expectedvalues.size() && actualVisibleMenus.containsAll(expectedvalues)) {
					isMenuitemsMatched = true;
					System.out.println("Menu names are Matching");
				} else {
					System.out.println("Menu names are Not Matching");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		return isMenuitemsMatched;
	}
	
	/*public static boolean compareMenuitemsOfAnApplication(WebDriver driver, List<String> testCaseData){
		boolean isMenuitemsMatched = false;
				try{
				List<String> actualVisibleMenus = getAllMenuNamesOfAnApplication(driver, testCaseData.get(3));
				List<String> expectedvalues = FWUtility.parseMenusXml(roleName, absolutePathOfXML)
				
				System.out.println("Expected Menus size is -> "+ expectedvalues.size());
				Reporter.log("Expected Menu names  are -> "+ expectedvalues);
				System.out.println("Expected Menu names  are -> "+ expectedvalues);
				if (actualVisibleMenus.size() == expectedvalues.size() && actualVisibleMenus.containsAll(expectedvalues)) {
					isMenuitemsMatched = true;
					System.out.println("Menu names are Matching");
				} else {
					System.out.println("Menu names are Not Matching");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		return isMenuitemsMatched;
	}*/
	
	public static void clickOnGSCCase(WebDriver driver){
		try{
		driver.findElement(By.xpath(locators.getProperty("CreateGSCCase"))).click();
		}catch(NoSuchElementException noe){
			noe.printStackTrace();
		}
		
	}
	
	public static void clickOnISGCase(WebDriver driver) throws InterruptedException{
		try{
		driver.findElement(By.xpath(locators.getProperty("CreateISGCase"))).click();
		Thread.sleep(10000);
		}catch(NoSuchElementException noe){
			noe.printStackTrace();
		}
	}
	public static void clickOnJDHome(WebDriver driver){
		try{
		driver.findElement(By.xpath(locators.getProperty("JDHome"))).click();
		}catch(NoSuchElementException noe){
			noe.printStackTrace();
		}
	}
}
