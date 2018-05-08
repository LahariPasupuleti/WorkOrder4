package com.incessant.uiautomation.ui.actions;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.FWUtility;
import com.incessant.uiautomation.util.FWWait;
import com.incessant.uiautomation.util.PALFileReader;
import com.incessant.uiautomation.util.SleepHelper;
import com.incessant.uiautomation.util.XLReader;

public class ProcessFlowActions {

	static WebDriver driver;
	String mainwindowtitle;
	
	private static Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);

	public static boolean capturePALReadings(WebDriver driver, String testCaseId) {
		boolean captureSuccess = true;
		try {
			driver.findElement(By.xpath(locators.getProperty("designerStudio"))).click();
			WebElement system = driver.findElement(By.xpath(locators.getProperty("system")));
			Actions a = new Actions(driver);
			a.moveToElement(system).moveToElement(driver.findElement(By.xpath(locators.getProperty("performance"))))
					.moveToElement(driver.findElement(By.xpath(locators.getProperty("pal")))).click().build().perform();
			Thread.sleep(3000);
			switchToFrameToFindElelement(driver,
					"html/body/div[3]/form/div[3]/div/table/tbody/tr/td/div/div/span[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr[1]/td/span/div/table/tbody/tr/td/div/div[1]/div[2]/table/tbody/tr/td/div/table[1]/tbody/tr[2]/td[2]/nobr/span/button");
			Thread.sleep(2000);
			String mainwin = driver.getWindowHandle();
			driver.switchTo().window(mainwin);
			ProcessFlowActions.launchCaseWorker(driver);
			NewGSCCaseCreationPage nep = new NewGSCCaseCreationPage(driver);

			// nep.clickOnSubmitt(driver);
			Thread.sleep(1000);
			driver.switchTo().window(mainwin);
			Thread.sleep(2000);
			switchToFrameToFindElelement(driver,
					"html/body/div[3]/form/div[3]/div/table/tbody/tr/td/div/div/span[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr[1]/td/span/div/table/tbody/tr/td/div/div[1]/div[2]/table/tbody/tr/td/div/table[1]/tbody/tr[2]/td[2]/nobr/span/button");
			Thread.sleep(3000);
			driver.findElement(By.xpath(locators.getProperty("delta"))).click();
			ProcessFlowActions.savePALReadingsToFile(driver);
		} catch (StaleElementReferenceException se) {
			se.printStackTrace();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 5; i++) {
				try {
					driver.findElement(By.xpath(locators.getProperty("delta"))).click();
					System.out.println("Clicked on Details button");
					break;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			captureSuccess = false;
			e.printStackTrace();
		}
		return captureSuccess;
	}

	public static String openPALReadingsWindow(WebDriver driver) {
		String mainwinName = null;
		try {
			driver.findElement(By.xpath(locators.getProperty("designerStudio"))).click();
			WebElement system = driver.findElement(By.xpath(locators.getProperty("system")));
			Actions a = new Actions(driver);
			a.moveToElement(system).moveToElement(driver.findElement(By.xpath(locators.getProperty("performance"))))
					.moveToElement(driver.findElement(By.xpath(locators.getProperty("pal")))).click().build().perform();
			Thread.sleep(3000);
			switchToFrameToFindElelement(driver,
					"(//button[starts-with(@name,'pzRequestorPerformanceAnalyzer_pyLanding')])[3]"); // Reset button
			driver.findElement(By.xpath(
					"html/body/div[3]/form/div[3]/div/table/tbody/tr/td/div/div/span[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr[1]/td/span/div/table/tbody/tr/td/div/div[1]/div[2]/table/tbody/tr/td/div/table[1]/tbody/tr[2]/td[2]/nobr/span/button"))
					.click();
			mainwinName = driver.getWindowHandle();
			driver.switchTo().window(mainwinName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainwinName;
	}

	public static boolean capturePALReading(WebDriver driver, String winName) {
		boolean captureSuccess = false;
		try {
			driver.switchTo().window(winName);
			Thread.sleep(2000);
			switchToFrameToFindElelement(driver,
					"html/body/div[3]/form/div[3]/div/table/tbody/tr/td/div/div/span[2]/div/div/div[2]/div[1]/div/span/table/tbody/tr[1]/td/span/div/table/tbody/tr/td/div/div[1]/div[2]/table/tbody/tr/td/div/table[1]/tbody/tr[2]/td[2]/nobr/span/button");
			Thread.sleep(3000);
			driver.findElement(By.xpath(locators.getProperty("delta"))).click();
			ProcessFlowActions.savePALReadingsToFile(driver);
			List<String> rowData = XLReader.getXLReader().getExcelDataByRuleType("Total Elapsed Time",
					FwConstants.ALL_DATA, FwConstants.Sheet_GSC_ProductInfo_Model);
			if (rowData.get(0).equals(FwConstants.OPERATOR_LESSTHAN)) {
				float actualCount = PALFileReader.getCount(FwConstants.TOTAL_ELAPSED_TIME);
				System.out.println("Actaul data -> " + actualCount);
				Reporter.log("Actual no of connectots executed are : " + actualCount);
				int expectedCount = Integer.parseInt(rowData.get(1));
				System.out.println("Expected data -> " + expectedCount);
				Reporter.log("Expected no of connectots executed are : " + expectedCount);
				Assert.assertEquals(actualCount, expectedCount, "Count matches");
				System.out.println("End of the test case  testConnectorsExecutedFromPALReadings");
			}
		} catch (InterruptedException e) {
			captureSuccess = false;
			e.printStackTrace();
		}
		return captureSuccess;
	}

	/**
	 * 
	 * @param driver
	 */
	public static void savePALReadingsToFile(WebDriver driver) {
		BufferedWriter bw = null;
		try {
			Reporter.log("Saving the PAL readings");
			File f = new File(FwConstants.PAL_Data_File);
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			for (String popupwindow : driver.getWindowHandles()) {
				driver.switchTo().window(popupwindow);
				String windowTiltle = driver.getTitle();
				if (windowTiltle.contains("pzPerformanceDetails")) {
					System.out.println("Switching to window and title is " + windowTiltle);
					System.out.println("Switch to " + driver.getTitle() + "Popwindow");
					Thread.sleep(3000);
					WebElement table = driver.findElement(By.xpath(locators.getProperty("table")));
					List<WebElement> rows = table.findElements(By.tagName("tr"));
					String colData = "";
					for (WebElement rowdata : rows) {
						List<WebElement> celldata = rowdata.findElements(By.tagName("td"));
						for (WebElement c : celldata) {
							colData = colData + c.getText() + ":";
						}
						bw.write(colData);
						bw.newLine();
						colData = "";
					}
				}
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 */
	public static void switchToFrameToFindElelementById(WebDriver driver, String locator) {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("frame")));
		System.out.println("--------frame size" + frames.size());
		for (int i = 0; i < frames.size(); i++) {
			// System.out.println("frame name is-> "+frames.get(i).getAttribute("name"));
			try {
				driver.switchTo().frame(i);
				System.out.println("frame name is-> " + frames.get(i).getAttribute("name"));
				WebElement Element = driver.findElement(By.id(locator));
				if (Element.isDisplayed()) {

					Thread.sleep(1000);
					Element.click();
					Thread.sleep(2000);
					Reporter.log("Successfully found element by id and switched to frame ");
					break;
				}
			} catch (Exception e) {
				// Reporter.log("Error in switchToFrameToFindElelement action " +
				// e.getMessage());
				// e.printStackTrace();
				System.out.println("Error in finding checkbox.");
			}
		}
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static String getCaseId(WebDriver driver) {
		String caseId = null;
		try {
			caseId = driver.findElement(By.xpath(locators.getProperty("caseid"))).getText();
			caseId = caseId.substring(caseId.indexOf('(') + 1, caseId.indexOf(')'));
			System.out.println("Case id -> " + caseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return caseId;
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 */
	public static void switchToFrameToFindElelement(WebDriver driver, String locator) {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("frame")));
		System.out.println(
				"Size of the frame is -> " + frames.size() + " Name is -> " + frames.get(0).getAttribute("name"));
		for (int i = 0; i < frames.size(); i++) {
			try {
				// System.out.println(" Name is -> " + frames.get(0).getAttribute("name"));
				driver.switchTo().defaultContent();
				driver.switchTo().frame(i);
				WebElement openBtnElement = driver.findElement(By.xpath(locator));
				if (openBtnElement.isDisplayed()) {
					openBtnElement.click();
					Thread.sleep(2000);
					Reporter.log("Successfully found element by xpath and switched to frame ");
					break;
				}
			} catch (Exception e) {
				Reporter.log("Error in switchToFrameToFindElelement action " + e.getMessage());
				e.printStackTrace();
			}
		}

	}
	public static String Stellar_support(WebDriver driver) {
		
		
		
//		Map<String, String> userjd = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_JD,
//				FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_JD_SHEET_NAME);
		
		
			
		
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Password ");
		
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("successfully login ");
		String Case_id=null;
		try {
			
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);


			Stellar_US31540 Stl = new Stellar_US31540(driver);

				try {

					Stl.webform_US31540();
						
									
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Case_id;
		
			 }
	public static String R4Agcc_Support(WebDriver driver) {
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("successfully login ");
		String Case_id=null;
		try {
			
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);


			R4Agcc_US31547 Stl = new R4Agcc_US31547(driver);

				try {

					Stl.webform_US31547();
						
									
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Case_id;
		
			 }
	
	
	
	public static void R4Agcc_CountryCaseIDSearchInCCMS(WebDriver driver) throws InterruptedException, FileNotFoundException {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		Thread.sleep(1000);
		
		
		Scanner myScanner = new Scanner(new File(FwConstants.R4Agcc_CaseID));
		String caseid = null;
		while (myScanner.hasNextLine()) {
			caseid = myScanner.nextLine();
			R4Agcc_US31547 casesearch=new R4Agcc_US31547(driver);
			casesearch.case_search_isg(caseid);
		}
	}

	
	public static String TechPubs_Support(WebDriver driver) {
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("successfully login ");
		String Case_id=null;
		try {
			
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);


			Techpubs_US31550 tech = new Techpubs_US31550(driver);

				try {

					tech.webform_US31550();
						
									
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Case_id;
		
			 }
			
			 
	public static void TechPubs_CountryCaseIDSearchInCCMS(WebDriver driver) throws InterruptedException, FileNotFoundException {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		Thread.sleep(1000);
		
	
		Scanner myScanner = new Scanner(new File(FwConstants.Techpubs_CaseID));
		String caseid = null;
		while (myScanner.hasNextLine()) {
			caseid = myScanner.nextLine();
			Techpubs_US31550 casesearch=new Techpubs_US31550(driver);
			casesearch.case_search_isg(caseid);
		}
	}

	
	
	public static void AgronomyCountry(WebDriver driver) throws Exception 
	{
		
		
		Thread.sleep(6000);
		//Username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		Thread.sleep(1000);
		//Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		Thread.sleep(1000);
		//SignIn Button
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("click on  signIn Button ");
		Thread.sleep(6000);
		
	 AgronomyCountry_WebFormPage ag=new AgronomyCountry_WebFormPage(driver);
				//driver.quit();
				ag.AgronomyCountry_WebFormsSubmit(driver);
				
			
		}
	public static void Agronomy_CaseIDSearchInCCMS(WebDriver driver) throws Exception  {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		AgronomyCountry_WebFormPage Ag=new AgronomyCountry_WebFormPage(driver);
		Ag.AgronomyCountry_CaseIDRouting(driver);
	}
	public static void IndiaCountry(WebDriver driver) throws Exception 
	{
		
		
		Thread.sleep(6000);
		//Username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		Thread.sleep(1000);
		//Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		Thread.sleep(1000);
		//SignIn Button
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("click on  signIn Button ");
		Thread.sleep(6000);
		
		IndiaCountry_WebFormPage IW=new IndiaCountry_WebFormPage(driver);
				
		IW.IndiaCountry_WebFormsSubmit(driver);
				
			
		}
	public static void India_CaseIDSearchInCCMS(WebDriver driver) throws Exception  {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		IndiaCountry_WebFormPage IW=new IndiaCountry_WebFormPage(driver);
		IW.IndiaCountry_CaseIDRouting(driver);
	}
	
	
	
	public static void Stellarsupport_CountryCaseIDSearchInCCMS(WebDriver driver) throws Exception {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		Thread.sleep(1000);
		
		
		Scanner myScanner = new Scanner(new File(FwConstants.StellarSupport_CaseID));
		String caseid = null;
		while (myScanner.hasNextLine()) {
			caseid = myScanner.nextLine();
			Stellar_US31540 casesearch=new Stellar_US31540(driver);
			casesearch.case_search_isg(caseid);
			
	}
		
		
	}
public static void Deere_Webform(WebDriver driver) throws AWTException, InterruptedException {
	Thread.sleep(6000);
	//Username
	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
	System.out.println("Entered UserName ");
	Thread.sleep(1000);
	//Password
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
	System.out.println("Entered Pasword ");
	Thread.sleep(1000);
	//SignIn Button
	driver.findElement(By.className("cta_btn")).click();
	System.out.println("click on  signIn Button ");
	Thread.sleep(6000);
		
		Deerecom_US31551 obj = new Deerecom_US31551();
		obj.webform_US31551(driver);
		obj.JE(driver);
		

	}
public static void casesearch_Deere(WebDriver driver) throws InterruptedException, FileNotFoundException {
	Scanner myScanner = new Scanner(new File(FwConstants.Deere_CaseID));
	String caseid = null;
	while (myScanner.hasNextLine()) {
		caseid = myScanner.nextLine();
		Stellar_US31540 casesearch=new Stellar_US31540(driver);
		casesearch.case_search_isg(caseid);
		Deerecom_US31551 obj = new Deerecom_US31551();
	obj.case_search_GSC(driver);
	}
}
	

	public static void Gsc_Isg_Assertions(WebDriver driver) {
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			FWWait wait = new FWWait();
			wait.findWebElementByXPath(driver, locators.getProperty("JDHome"));
			MenuActions.clickOnJDHome(driver);
			System.out.println("Clicked on Home page");
			wait.findWebElementByXPath(driver, locators.getProperty("CreateISGCase"));
			MenuActions.clickOnISGCase(driver);
			System.out.println("Clicked on ISG case Button");
			
			Gsc_Isg_Assertions Assert = new Gsc_Isg_Assertions(driver);
			List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("iframe")));
			
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(0);
					System.out.println("Switched to frame");
					WebElement Element = driver.findElement(By.xpath(locators.getProperty("AddCustomerInfo")));
					Element.click();
					

				if (Element.isDisplayed()) {
					Assert.ISG_CustInfo_check(); // Moving to customer info entry
					// driver.switchTo().parentFrame();
					Thread.sleep(6000);
					

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
			
			 }
		
public static void JE() {
    JavascriptExecutor js = (JavascriptExecutor)driver;  
    js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
    
}

		
		
		
		
	

	
	/**
	 * Kasoju
	 **/
	public static void createGSCCaseByUser(WebDriver driver) {
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			FWWait wait = new FWWait();
			wait.findWebElementByXPath(driver, locators.getProperty("JDHome"));
			MenuActions.clickOnJDHome(driver);
			System.out.println("Clicked on Home page");
			wait.findWebElementByXPath(driver, locators.getProperty("CreateGSCCase"));
			MenuActions.clickOnGSCCase(driver);
			System.out.println("Clicked on GSc case Button");
			Thread.sleep(3000);
			NewGSCCaseCreationPage ne = new NewGSCCaseCreationPage(driver);
			List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("iframe")));
			//for (int f = 0; f < frames.size(); f++) {
				try {
					//driver.switchTo().defaultContent();
					driver.switchTo().frame(0);
					System.out.println("Switched to frame");
					WebElement Element = driver.findElement(By.xpath(locators.getProperty("AddCustomerInfo")));
					Element.click();
					if (Element.isDisplayed()) {
						ne.AddCustomerInfo(); // Moving to customer info entry
						driver.switchTo().parentFrame();
						Thread.sleep(6000);
						ne.AddProductInfo();
						ne.enterFunAreaCode(driver);
						ne.enterFunCode(driver);
						ne.selectPriority(driver);
						ne.selectLanguage(driver);
						ne.selectCaseOrigin(driver);
						ne.selectWorkBasket(driver);
						Thread.sleep(2000);
						ne.AddSummary(driver);
						ne.WB_Details();
						ne.GSC_Addcomment();
						ne.clickOnGSCAccept();
						assertTrue(driver.findElement(By.xpath("(//div[@class='field-item dataValueRead'])[3]"))
								.isDisplayed());

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sandeep & Lahari
	 **/
public static void RoutingRules_for_GSC(WebDriver driver) {
		
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			FWWait wait = new FWWait();
			wait.findWebElementByXPath(driver, locators.getProperty("JDHome"));
			MenuActions.clickOnJDHome(driver);
			wait.findWebElementByXPath(driver, locators.getProperty("CreateGSCCase"));
			MenuActions.clickOnGSCCase(driver);

			RoutingforGSC_Page RS = new RoutingforGSC_Page(driver);
			List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("iframe")));
			
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(0);
					
//					RS.ISG_Actions_NewDraft();
					
					WebElement Element = driver.findElement(By.xpath(locators.getProperty("AddCustomerInfo")));
					Element.click();

				if (Element.isDisplayed()) {
					
					RS.AddCustomerInfo(); // Moving to customer info entry

					Thread.sleep(6000);
					RS.AddProductInfo();
					RS.enterFunAreaCode(driver);
//					RS.enterFunCode(driver);
					RS.selectPriority(driver);
					RS.selectLanguage(driver);
					RS.selectCaseOrigin(driver);
//					// isg.selectWorkBasket(driver);
					Thread.sleep(2000);
					RS.AddSummary(driver);

					Thread.sleep(3000);
					RS.selectWorkBasket(driver);
					RS.clickOnGSCRoute(driver);
					Thread.sleep(3000);
					RS.GSC_Actions_NewDraft();
					Thread.sleep(3000);
					RS.GSC_Accept();
					
					Thread.sleep(3000);
					RS.clickOnGSC_Action();
				   	Thread.sleep(3000);
				   	RS.GSC_Actions_Owned();
					
					assertTrue(driver.findElement(By.xpath("(//div[@class='field-item dataValueRead'])[3]"))
						.isDisplayed());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		}
/**
 * Sandeep
 **/
	public static void createISGCaseByUser(WebDriver driver) {
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			FWWait wait = new FWWait();
			wait.findWebElementByXPath(driver, locators.getProperty("JDHome"));
			MenuActions.clickOnJDHome(driver);
			wait.findWebElementByXPath(driver, locators.getProperty("CreateISGCase"));
			MenuActions.clickOnISGCase(driver);

			NewISGCaseCreationPage isg = new NewISGCaseCreationPage(driver);
			List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("iframe")));
			
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(0);
					WebElement Element = driver.findElement(By.xpath(locators.getProperty("AddCustomerInfo")));
					Element.click();

				if (Element.isDisplayed()) {
					isg.AddCustomerInfo(); // Moving to customer info entry
					// driver.switchTo().parentFrame();
					Thread.sleep(6000);
					isg.AddProductInfo();
					isg.enterFunAreaCode(driver);
					isg.enterFunCode(driver);
					isg.selectPriority(driver);
					isg.selectLanguage(driver);
					isg.selectCaseOrigin(driver);
					// isg.selectWorkBasket(driver);
					Thread.sleep(2000);
					isg.AddSummary(driver);
					isg.clickOnISGAccept();
					Thread.sleep(5000);
					assertTrue(driver.findElement(By.xpath("(//div[@class='field-item dataValueRead'])[3]"))
						.isDisplayed());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
			
			 }
	
	
	
	public static void JDLink_Webform(WebDriver driver) throws AWTException, InterruptedException {
		
		Thread.sleep(10000);
		System.out.println("Entered ");
		//Username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		Thread.sleep(1000);
		//Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		Thread.sleep(1000);
		//SignIn Button
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("click on  signIn Button ");
		Thread.sleep(6000);
		JDLink_Dashboard_US31545 obj = new JDLink_Dashboard_US31545();
		obj.webform_US31545(driver);
		obj.JE(driver);
	}
	
	public static void casesearch_JDLink(WebDriver driver) throws FileNotFoundException {
		Scanner myScanner = new Scanner(new File(FwConstants.JDLink_CaseID));
		String caseid = null;
		while (myScanner.hasNextLine()) {
			caseid = myScanner.nextLine();
		
		
		JDLink_Dashboard_US31545 obj = new JDLink_Dashboard_US31545();
		obj.case_search_isg(driver);
		}
	}
	
	/**
	 * Sandeep
	 **/
	
	
	public static void UI_Actions_Availability(WebDriver driver) {
	
	try {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		FWWait wait = new FWWait();
		wait.findWebElementByXPath(driver, locators.getProperty("JDHome"));
		MenuActions.clickOnJDHome(driver);
		wait.findWebElementByXPath(driver, locators.getProperty("CreateISGCase"));
		MenuActions.clickOnISGCase(driver);

		UI_Actions_Availability_Checkpage Act = new UI_Actions_Availability_Checkpage(driver);
		List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("iframe")));
		
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(0);
				
				Act.ISG_Actions_NewDraft();
				
				WebElement Element = driver.findElement(By.xpath(locators.getProperty("AddCustomerInfo")));
				Element.click();

			if (Element.isDisplayed()) {
				
				Act.AddCustomerInfo(); // Moving to customer info entry

				Thread.sleep(6000);
				Act.AddProductInfo();
				Act.enterFunAreaCode(driver);
				Act.enterFunCode(driver);
				Act.selectPriority(driver);
				Act.selectLanguage(driver);
				Act.selectCaseOrigin(driver);
				// isg.selectWorkBasket(driver);
				Thread.sleep(2000);
				Act.AddSummary(driver);

				Thread.sleep(3000);
				Act.clickOnISGRoute();
				Thread.sleep(3000);
				Act.ISG_Actions_New();
				
				Thread.sleep(3000);
			   	Act.clickOnISGAccept();
			   	Thread.sleep(3000);
				Act.ISG_Actions_Owned();
				Thread.sleep(3000);
				Act.clickOnISGClose();
				Thread.sleep(3000);
				Act.ISG_Actions_Resolved();				
				Thread.sleep(5000);
				Act.ISG_Actions_Reopened();
				
//				assertTrue(driver.findElement(By.xpath("(//div[@class='field-item dataValueRead'])[3]"))
//					.isDisplayed());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public static void openTheCaseFromWB(WebDriver driver, String caseid) {
		try {
			switchToFrameToFindElelement(driver, locators.getProperty("incessworkbasket"));
			Thread.sleep(2000);
			driver.findElement(By.xpath(locators.getProperty("caseid_filter"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(locators.getProperty("search"))).sendKeys(caseid);
			driver.findElement(By.xpath(locators.getProperty("applybutton"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(locators.getProperty("required_caseid"))).click();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean routingTheCase(WebDriver driver, String operator, String testCaseId) {
		boolean iscaseTransfered = false;
		try {
			String caseId = ConfPropertyReader.getConfPropertyReader().getProperty(FwConstants.CASEID_PROPERTIES_FILE,
					"caseid");
			openTheCaseFromWB(driver, caseId);
			driver.findElement(By.xpath(locators.getProperty("routing_checkbox"))).click();
			Thread.sleep(1000);
			new Select(driver.findElement(By.id(locators.getProperty("transferto_dropdown"))))
					.selectByVisibleText(operator);
			Thread.sleep(2000);
			driver.switchTo().activeElement().sendKeys(Keys.TAB);
			Thread.sleep(1000);
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);
			iscaseTransfered = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return iscaseTransfered;
	}

	public static boolean approveCaseByManager(WebDriver driver, String caseId, String testCaseId) {
		boolean isCaseApproved = false;
		try {
			List<String> inputData = XLReader.getXLReader().getExcelDataByTestCaseId(testCaseId, FwConstants.ALL_DATA,
					FwConstants.GSC_Test_data);
			openTheCaseFromWB(driver, caseId);
			Thread.sleep(2000);
			(new WebDriverWait(driver, 10).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(locators.getProperty("approve_button")))))
							.click();
			// driver.findElement(By.xpath(locators.getProperty("approve_button"))).click();
			driver.findElement(By.id(locators.getProperty("amount_to_be_granted"))).sendKeys(inputData.get(0));
			driver.findElement(By.id(locators.getProperty("rate_of_interest"))).sendKeys(inputData.get(1));
			driver.findElement(By.id(locators.getProperty("tenure"))).sendKeys(inputData.get(2));
			driver.findElement(By.xpath(locators.getProperty("approve_submitt_button"))).click();
			Thread.sleep(1000);

			isCaseApproved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isCaseApproved;
	}

	public static boolean rejectTheCase(WebDriver driver) {
		boolean iscaserejected = false;
		try {
			driver.findElement(By.xpath(locators.getProperty("reject_button"))).click();
			iscaserejected = true;
		} catch (NoSuchElementException noe) {
			noe.printStackTrace();
		}
		return iscaserejected;

	}

	/**
	 * 
	 * @param driver
	 * @param Type
	 * @param caseId
	 * @param filepath
	 * @return
	 */
	public static boolean attachment(WebDriver driver, String attachmentType, String caseId, String filepath,
			String userType) {
		boolean isAttachmentOk = false;
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			ProcessFlowActions.search(driver, userType, caseId);
			if (userType.equals(FwConstants.ROLE_MANAGER)) {
				driver.switchTo().frame(1);
				driver.findElement(By.xpath(locators.getProperty("attachment_link"))).click();
				Thread.sleep(1000);
				if (attachmentType.equals("File from device")) {
					driver.findElement(By.xpath(locators.getProperty("attachment_type_file"))).click();
					driver.findElement(By.id(locators.getProperty("attachment_selectfile_button"))).click();
					Thread.sleep(1000);
					StringSelection file = new StringSelection(filepath);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyRelease(KeyEvent.VK_V);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					System.out.println("File uploaded sucessfully");
					Thread.sleep(2000);
					driver.findElement(By.id(locators.getProperty("attachment_submitt_button"))).click();
				} else {
					driver.findElement(By.xpath(locators.getProperty("attachment_type_url"))).click();
					Thread.sleep(2000);
					driver.findElement(By.id(locators.getProperty("attach_link_subject"))).sendKeys("gjhff");
					driver.findElement(By.id(locators.getProperty("attachment_url_field"))).sendKeys("www.jabanga.com");
					new Select(driver.findElement(By.id(locators.getProperty("attachment_category"))))
							.selectByVisibleText("URL");
					Thread.sleep(1000);
					driver.findElement(By.id(locators.getProperty("attachment_submitt_button"))).click();
				}
			} else {
				driver.findElement(By.xpath(locators.getProperty("attachment_link"))).click();
				Thread.sleep(1000);
				if (attachmentType.equals("File from device")) {
					driver.findElement(By.xpath(locators.getProperty("attachment_type_file_user"))).click();
					driver.findElement(By.id(locators.getProperty("attachment_selectfile_button"))).click();
					Thread.sleep(1000);
					StringSelection file = new StringSelection(filepath);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_CONTROL);
					r.keyRelease(KeyEvent.VK_V);
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);
					driver.findElement(By.id(locators.getProperty("attachment_submitt_button"))).click();
				}

			}
			isAttachmentOk = true;
		} catch (NoSuchElementException noe) {
			noe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isAttachmentOk;
	}

	/**
	 * 
	 * @param driver
	 * @param UserType
	 * @param CaseId
	 * @return
	 */
	public static boolean search(WebDriver driver, String UserType, String CaseId) {
		boolean isSearchOk = false;
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			driver.findElement(By.id(locators.getProperty("search_field"))).sendKeys(CaseId);

			if (UserType.equals("Manager")) {
				driver.findElement(By.xpath(locators.getProperty("search_symbol"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(locators.getProperty("search_id_filter"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(locators.getProperty("search_text_field"))).sendKeys(CaseId);
				driver.findElement(By.xpath(locators.getProperty("apply_button"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(locators.getProperty("search_caseid"))).click();
				Thread.sleep(3000);
			} else {
				driver.findElement(By.xpath(locators.getProperty("search_symbol_user"))).click();
				driver.findElement(By.xpath(locators.getProperty("search_id_filter"))).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(locators.getProperty("search_text_field_user"))).sendKeys(CaseId);
				driver.findElement(By.xpath(locators.getProperty("apply_button"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(locators.getProperty("search_caseid_user"))).click();
				Thread.sleep(3000);
			}

			isSearchOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSearchOk;
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static int fetchCurrentCaseSizeAndVerifyWithExpectedValues(WebDriver driver) {
		int pyWorkPageSize = 0;
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			Thread.sleep(3000);
			for (String win : driver.getWindowHandles()) {
				driver.switchTo().window(win);
				String name = driver.getTitle();
				System.out.println("win name -> " + name);
				if (name.equals("Pega Designer Studio")) {
					driver.findElement(By.xpath(locators.getProperty("clipboard"))).click();
					WindowHandle(driver);
					driver.manage().window().maximize();
					Thread.sleep(3000);
					driver.findElement(
							By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/div/div/div/div/div/span/a/i"))
							.click(); // Tools
					Thread.sleep(2000);
					driver.findElement(By.xpath(".//*[@id='pyNavigation1480620344117']/li[1]/a")).click(); // Analyse
																											// Click
					Thread.sleep(5000);
					break;
				}
			}
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath(locators.getProperty("settings_symbol")));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(3000);
			driver.findElement(By.xpath(locators.getProperty("analyze"))).click();
			WindowHandle(driver);
			String pyworkpage_count = driver.findElement(By.xpath(locators.getProperty("pyworkpage_celllocator")))
					.getText();
			System.out.println("PyWorkPage size is -> " + pyworkpage_count + "KB");
			pyWorkPageSize = Integer.parseInt(pyworkpage_count);
			List<String> rowData = XLReader.getXLReader().getExcelDataByRuleType(FwConstants.PYWORKPAGE_SIZE_STRING,
					FwConstants.ALL_DATA, FwConstants.Sheet_GSC_ProductInfo_Model);
			if (rowData.get(0).equals(FwConstants.OPERATOR_BETWEEN)) {
				String[] limits = rowData.get(1).split("to");
				boolean isSizeInLimits = FWUtility.checkPyWorkPageSizeLimits(pyWorkPageSize, limits);
				Assert.assertTrue(isSizeInLimits, " pyWorkPage size is in limits");
				// isVerifyWorkpagesize = true;
				System.out.println("End of the test case  testVerifypyWorkpageSizeFromClipboard");
				Reporter.log("Case size is within the limits and size is " + pyWorkPageSize);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pyWorkPageSize;
	}

	/**
	 * 
	 * @param driver
	 */
	public static void launchCaseWorker(WebDriver driver) {
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			driver.findElement(By.xpath(locators.getProperty("launch"))).click();
			Thread.sleep(3000);
			// driver.findElement(By.xpath(locators.getProperty("caseworker"))).click();
			driver.findElement(By.xpath("//span[contains(text(),'Case Worker')] ")).click();
			String mainwindowtitle = driver.getTitle();
			for (String popupwindow : driver.getWindowHandles()) {
				driver.switchTo().window(popupwindow);
				String windowTiltle = driver.getTitle();
				if (mainwindowtitle.equals(windowTiltle)) {
					// System.out.println("Switch to main window");
				} else {
					// System.out.println("Switch to childwindow");
					driver.manage().window().maximize();
					Thread.sleep(1000);
					WebElement new_element = driver.findElement(By.xpath(locators.getProperty("designerstudio_new")));
					new_element.click();
					driver.findElement(By.xpath(locators.getProperty("designerstudio_enrollment"))).click();
				}
			}
		} catch (NoSuchElementException noe) {
			noe.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public static void clickOnAnalyze(WebDriver driver) {

		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			Thread.sleep(3000);
			for (String win : driver.getWindowHandles()) {
				driver.switchTo().window(win);
				String name = driver.getTitle();
				System.out.println("win name -> " + name);
				if (name.equals("Pega Designer Studio")) {
					driver.findElement(By.xpath(locators.getProperty("clipboard"))).click();
					WindowHandle(driver);
					driver.manage().window().maximize();
					Thread.sleep(2000);
					driver.findElement(
							By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/div/div/div/div/div/span/a/i"))
							.click(); // Tools
					Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@id='pyNavigation1480620344117']/li[1]/a")).click(); // Analyse
																											// Click
					Thread.sleep(5000);
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public static void getAttachmentCount(WebDriver driver) {
		try {
			Thread.sleep(4000);
			driver.findElement(By.xpath(
					"html/body/div[3]/aside/div[1]/div/table[1]/tbody/tr/td/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/div/ul/li[2]/ul[2]/li[27]/ul/li[1]/div/div[1]/a"))
					.click();
			Thread.sleep(4000);
			// click on PyAttachments link
			driver.findElement(By.xpath(
					"html/body/div[3]/aside/div[1]/div/table[1]/tbody/tr/td/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/div/ul/li[2]/ul[2]/li[27]/ul[2]/li[7]/ul/li[1]/div/div[1]/a"))
					.click();
			Thread.sleep(2000);
			/*
			 * WebElement ele =
			 * driver.findElement(By.linkText("pyWorkPage (NIIT-FW-iTest-Work-Enrollment)"))
			 * ; //(new
			 * WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By
			 * .linkText("pyWorkPage (NIIT-FW-iTest-Work-Enrollment)")))).click();
			 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
			 * Thread.sleep(1000); driver.findElement(By.
			 * linkText("pyAttachments [Refers to D_AttachmentList_pa525064221348984pz.pxResults]"
			 * )).click(); Thread.sleep(2000);
			 */
			List<WebElement> attachment = driver.findElements(By.xpath(
					"//li[starts-with(@id,'$PClipboardPages$ppzClipboardPage$l1$ppzClipboardPage$l28$ppzClipboardPage$l7$ppzClipboardPage$')]"));
			System.out.println("------count of attachmnet -> " + attachment.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 * @param Type
	 * @param caseId
	 * @param filepath
	 */
	public static void attachfilefromDesignerStudio(WebDriver driver, String Type, String caseId, String filepath) {
		try {
			driver.findElement(By.xpath(locators.getProperty("attachment_link"))).click();
			driver.findElement(By.linkText("File from device")).click();
			driver.findElement(By.id(locators.getProperty("attachment_selectfile_button"))).click();
			Thread.sleep(1000);
			StringSelection file = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			driver.findElement(By.id(locators.getProperty("attachment_submitt_button"))).click();
			System.out.println("File is attached");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param driver
	 */
	public static void WindowHandle(WebDriver driver) {
		try {
			String parentwindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> I1 = s1.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parentwindow.equals(child_window)) {
					driver.switchTo().window(child_window);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(5000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public static void switchToWindow(WebDriver driver) {
		try {
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> I1 = s1.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (child_window.equals("Pega Designer Studio")) {
					driver.switchTo().window(child_window);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// System.out.println("----------win name -> "+driver.getTitle());
					Thread.sleep(5000);
					break;
				} else if (child_window.contains("Clipboard Viewer")) {
					driver.switchTo().window(child_window);
					// System.out.println("Window name -> "+driver.getTitle());
				} else if (child_window.contains("Enrollment")) {
					driver.switchTo().window(child_window);
					// System.out.println("Window name -> "+driver.getTitle());
				} else if (child_window.contains("pzPerformanceDeatils")) {
					driver.switchTo().window(child_window);
					// System.out.println("Window name -> "+driver.getTitle());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 * @param caseId
	 * @return
	 */
	public static Map<String, String> executePegaActivity(WebDriver driver, String caseId) {
		Map<String, String> activityOp = new HashMap<String, String>();
		try {
			WebElement search = driver.findElement(By.name(locators.getProperty("designerstudio_search_filed")));
			search.sendKeys(locators.getProperty("search_text"));
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(locators.getProperty("name_fetchrulecount"))).click();
			Thread.sleep(1000);
			ProcessFlowActions.switchToFrameToFindElelement(driver, locators.getProperty("designerstudio_actions"));
			driver.findElement(By.xpath(locators.getProperty("designerstudio_run"))).click();
			String maintitle = driver.getTitle();
			for (String cwin : driver.getWindowHandles()) {
				driver.switchTo().window(cwin);
				String ctitle = driver.getTitle();
				if (!ctitle.equals(maintitle)) {
					driver.findElement(By.id(locators.getProperty("run_caseid"))).sendKeys(caseId);
					driver.findElement(By.name(locators.getProperty("run"))).click();
					Thread.sleep(1000);
					break;
				}
			}
			for (String childwin : driver.getWindowHandles()) {
				driver.switchTo().window(childwin);
				String curl = driver.getCurrentUrl();
				String expectedurl = locators.getProperty("expectedURL");
				if (curl.equals(expectedurl)) {
					System.out.println("Switch to required window ");
					String noOfAssignments = driver.findElement(By.xpath(locators.getProperty("no_of_assignments")))
							.getText();
					Thread.sleep(1000);
					String noOfAttachments = driver.findElement(By.xpath(locators.getProperty("no_of_attachments")))
							.getText();
					Thread.sleep(1000);
					String noOfSLAs = driver.findElement(By.xpath(locators.getProperty("no_of_servicelevelagreements")))
							.getText();
					Thread.sleep(1000);
					activityOp.put(FwConstants.ASSIGNMENTS_COUNT, noOfAssignments);
					activityOp.put(FwConstants.ATTACHMENTS_COUNT, noOfAttachments);
					activityOp.put(FwConstants.SLA_COUNT, noOfSLAs);
					System.out.println("Number of Assignments count--> " + noOfAssignments
							+ " Number of Attachments count --> " + noOfAttachments);
					break;
				} else {
					System.out.println("Frame switching didn't work !!!!");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return activityOp;
		}
		return activityOp;
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static String getAttachmentCountFromUI(WebDriver driver) {
		String attachment_Count = null;
		try {
			attachment_Count = driver.findElement(By.xpath(locators.getProperty("Attachment_count_UI"))).getText();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return attachment_Count;
	}

	/**
	 * 
	 * @param driver
	 * @return
	 */
	public static boolean checkIfInitiateCaseExists(WebDriver driver, String userType) {
		boolean exists = false;
		try {
			String newBtnLocator = locators.getProperty("new_menu_item");
			String enrollBtn = locators.getProperty("enrollment");
			driver.findElement(By.xpath(newBtnLocator)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(enrollBtn)).click();
			exists = true;
		} catch (Exception eee) {
			System.out.println("Hello exception");
			eee.printStackTrace();
		}
		return exists;
	}

	public static int getComplianceScore(WebDriver driver) {
		int weighted_score = 0;
		try {
			driver.findElement(By.xpath(locators.getProperty("designerStudio"))).click();
			WebElement application = driver.findElement(By.xpath(locators.getProperty("application")));
			Actions a = new Actions(driver);
			a.moveToElement(application).moveToElement(driver.findElement(By.xpath(locators.getProperty("guardrails"))))
					.moveToElement(driver.findElement(By.xpath(locators.getProperty("complaince_score")))).click()
					.build().perform();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget0Ifr");
			String score = driver.findElement(By.xpath(locators.getProperty("score"))).getText();
			weighted_score = Integer.parseInt(score);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weighted_score;
	}

	public static String getRuleContentAndCount(WebDriver driver, String type) {
		String ruleContent = null;
		try {
			driver.findElement(By.xpath(locators.getProperty("designerStudio"))).click();

			WebElement security = driver.findElement(By.xpath(locators.getProperty("organdsecurity")));
			Actions a = new Actions(driver);
			a.moveToElement(security).moveToElement(driver.findElement(By.xpath(locators.getProperty("tools"))))
					.moveToElement(driver.findElement(By.xpath(locators.getProperty("security"))))
					.moveToElement(driver.findElement(By.xpath(locators.getProperty("rulesecurityanalyzer")))).click()
					.build().perform();
			Thread.sleep(3000);
			WindowHandle(driver);
			driver.manage().window().maximize();
			String popUpWindow = driver.getTitle();
			System.out.println("PopUpWindow title is -> " + popUpWindow);
			Thread.sleep(1000);
			driver.findElement(By.xpath(locators.getProperty("itest_checkbox"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(locators.getProperty("rulesetversion_radiobutton"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(locators.getProperty("section_checkbox"))).click();
			Thread.sleep(1000);
			driver.findElement(By.id(locators.getProperty("expression"))).sendKeys(type);
			Thread.sleep(1000);
			driver.findElement(By.id(locators.getProperty("run_button"))).click();
			Thread.sleep(1000);
			String ruleSearch_count = driver.findElement(By.xpath(locators.getProperty("numberofrules_searched")))
					.getText();
			System.out.println("Number of Rules Searched Count is -> " + ruleSearch_count);
			String rules_withexpression = driver
					.findElement(By.xpath(locators.getProperty("numberofrules_withexpression"))).getText();
			System.out.println("Number of Rules With Expression count is  -> " + rules_withexpression);
			Thread.sleep(4000);
			driver.findElement(By.xpath(locators.getProperty("rule_html_section"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(locators.getProperty("rulesecurity_analyzer"))).click();
			Thread.sleep(1000);
			ruleContent = driver.findElement(By.xpath(locators.getProperty("ruleset"))).getText();
			System.out.println("Required Rule Content is -> " + ruleContent);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ruleContent;
	}

	public static List<String> getReports(WebDriver driver) {
		List<String> reportName = new ArrayList<String>();
		try {
			boolean isReportsExist = MenuActions.isMenuExists(FwConstants.MENU_REPORTS, driver);
			if (isReportsExist) {
				driver.switchTo().frame(1);
				Thread.sleep(1000);
				driver.findElement(By.xpath(locators.getProperty("Allreports"))).click();
				List<WebElement> values = driver.findElements(By.xpath(locators.getProperty("reports_name")));
				for (WebElement report : values) {
					String report_name = report.getText();
					reportName.add(report_name);
				}
			} else {
				System.out.println("User doesnt have reports option");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportName;
	}
	public static void ValidateCustomerInfo(WebDriver driver) {
		try {
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		FWWait wait = new FWWait();
		wait.findWebElementByXPath(driver, locators.getProperty("CaseSearch"));
		MenuActions.clickOnCaseSearch(driver);
		Thread.sleep(10000);
		switchToFrameToFindElelement(driver, locators.getProperty("Searchbox"));
		NewValidateCustomerInfo Val = new NewValidateCustomerInfo(driver);
		Val.InputCaseId(driver);
		Val.clickOnSearch(driver);
		Val.ClickCaseId(driver);
		Val.SwitchToDef(driver);
		//switchToFrameToFindElelement(driver, locators.getProperty("Assert_FirstName"));
		SwitchToFrame(driver);
		Val.AssertInfo(driver);
		}catch (Exception e) {
		e.printStackTrace();}
		}


			
			public static boolean ValidateModelParameterMandatoryField(WebDriver driver)
			{
				
				boolean isValidated=false;
				return isValidated;
			}
			
			
	public static void SwitchToFrame(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(4000);
		driver.switchTo().frame("PegaGadget1Ifr");
	}//End of Method 


	public static boolean comparreports(WebDriver driver, String userType) {
		boolean isReportsMatched = false;
		try {
			List<String> actualValues = ProcessFlowActions.getReports(driver);
			List<String> expectedValues = XLReader.getXLReader().getExcelDataByUserType(userType, FwConstants.ALL_DATA,
					FwConstants.Sheet_Report_Names);
			System.out.println("Actual Reports size is -> " + actualValues.size());
			System.out.println("Expected Reports size is -> " + expectedValues.size());
			System.out.println("Expected Reports names  are -> " + expectedValues);
			if (actualValues.size() == expectedValues.size() && actualValues.containsAll(expectedValues)) {
				isReportsMatched = true;
				System.out.println("Report names are Matching");
			} else {
				System.out.println("Report names are Not Matching");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isReportsMatched;
	}
	
	
	public static void R4Turf_tier1(WebDriver driver) throws Exception
	{
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("successfully login ");
		
		NewValidateCustomerInfo val=new NewValidateCustomerInfo(driver);
		
		val.R4TurfTier(driver);
		Thread.sleep(3000);
		
	}
	
	
	public static void SaharaSouthAfrica(WebDriver driver) throws InterruptedException
	{

			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
			System.out.println("Entered UserName ");
			
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
			System.out.println("Entered Pasword ");
			
			driver.findElement(By.className("cta_btn")).click();
			System.out.println("successfully login ");
			
			NewValidateCustomerInfo val=new NewValidateCustomerInfo(driver);
			
			val.validateEnglishLanguage(driver);
			val.validatePortuguesLanguage(driver);
			val.validateFranceLanguage(driver);
			val.fillSaharaSouthAfricaForm(driver);
			
			
			
		
	}//end of SouthAfrica

	public static void validateCustomerWorkBasketSA(WebDriver driver)
	{
		try
		{
	//	String path="D:\\JohnDeereAutomation\\resources\\conf\\SACaseid.txt";	
		
		NewValidateCustomerInfo val = new NewValidateCustomerInfo(driver);
		
	//	String Case_ID=val.readFromFile(path);
	//	val.caseSearch_Menu(driver, Case_ID);
		
		val.caseSearch_Menu_SA(driver);
		Thread.sleep(3000);
		
		val.GetWorkBasket(driver);
		
			}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}//South Africa

	public static void validateCustomerWorkBasketR4(WebDriver driver)
	{
		try
		{
	//	String path="D:\\JohnDeereAutomation\\resources\\conf\\SACaseid.txt";	
		
		NewValidateCustomerInfo val = new NewValidateCustomerInfo(driver);
		
	//	String Case_ID=val.readFromFile(path);
	//	val.caseSearch_Menu(driver, Case_ID);
		
		val.caseSearch_Menu_R4(driver);
		Thread.sleep(3000);
		
		val.GetWorkBasket(driver);
		
			}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}//South Africa
	public static void WebformJDPartsCCMsDetails(WebDriver driver)
	   {
		   try {
			   Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
				FWWait wait = new FWWait();
				wait.findWebElementByXPath(driver, locators.getProperty("JDWebformClickOnCaseSearch"));
				System.out.println("Loading page for case search to display");
				MenuActions.clickOnCaseSearch(driver);
				System.out.println("click on case search");
				
					Scanner in= new Scanner(new File(FwConstants.JDParts_CASEID_File));
			       String Case_ID=null;
			       while (in.hasNextLine()) {
			       Case_ID = in.nextLine(); 
			       JDParts_WebFormPage JD = new JDParts_WebFormPage(driver);
			       JD.CaseSearcRouting(Case_ID);
			
		       
		    
			   	       }}catch(Exception e) {
			   e.printStackTrace();
		   }
	   } 
	public static void JDParts(WebDriver driver) throws Exception
	{
		Thread.sleep(10000);
		//enter the username
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("KM91738");
		System.out.println("Entered UserName ");
		Thread.sleep(1000);
		
		//enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dear4343");
		System.out.println("Entered Pasword ");
		Thread.sleep(1000);
		
		//enter the signIn Button
		driver.findElement(By.className("cta_btn")).click();
		System.out.println("click on  signIn Button ");
		Thread.sleep(6000);
		
	     JDParts_WebFormPage ag=new JDParts_WebFormPage(driver);
				//driver.quit();
				ag.JDPartValidation(driver);
	} 
	
	public static void SendcaseEmail(WebDriver driver) {
		try {
			Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
			FWWait wait = new FWWait();
			wait.findWebElementByXPath(driver, locators.getProperty("JDHome"));
			MenuActions.clickOnJDHome(driver);
			wait.findWebElementByXPath(driver, locators.getProperty("CreateISGCase"));
			MenuActions.clickOnISGCase(driver);

			AuditTrainsPage AH = new AuditTrainsPage(driver);
			List<WebElement> frames = driver.findElements(By.xpath(locators.getProperty("iframe")));
			
			
				try {
						driver.switchTo().defaultContent();
						driver.switchTo().frame(0);
						
						//RS.ISG_Actions_NewDraft();
						
						WebElement Element = driver.findElement(By.xpath(locators.getProperty("AddCustomerInfo")));
						Element.click();
						System.out.println("");

					if (Element.isDisplayed()) {
						
						AH.AddCustomerInfo(); // Moving to customer info entry

						Thread.sleep(6000);
						AH.AddProductInfo();
						AH.enterFunAreaCode(driver);
						AH.enterFunCode(driver);
						AH.selectPriority(driver);
						AH.selectLanguage(driver);
						AH.selectCaseOrigin(driver);
						// isg.selectWorkBasket(driver);
						Thread.sleep(2000);
						AH.AddSummary(driver); 
			 
			
						AH.clickOnISGRoute();
						Thread.sleep(3000);
						AH.sendCaseEmail();
						Thread.sleep(6000);
						//AH.ISG_Actions_NewDraft();
						//AH.ClickOnAudit_Button();
						

				}
					}catch (Exception e) {
					e.printStackTrace();
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
				} 
			 

			
	public static void validateAutoEmail(WebDriver driver) throws Exception 
	{

			NewValidateCustomerInfo val=new NewValidateCustomerInfo(driver);
			
			val.validateEmailFunctionality(driver);
			
		}
	
	}//end of method

	

	
