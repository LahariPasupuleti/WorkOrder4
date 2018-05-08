package com.incessant.uiautomation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.ui.actions.ProcessFlowActions;

public class ISGReopen1 {
	private static Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
	//public static void main(String[] args) throws InterruptedException, IOException {
	@Test
	public void casereopen() throws InterruptedException{
	//WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32 (8)/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://ccmstal.tal.deere.com/prweb/PRServlet");
	driver.manage().window().maximize();
	//ProcessFlowActions.LoginJohnDeere(driver);
	
	
	/* Logging into application with valid credentials*/
	
	driver.findElement(By.xpath(locators.getProperty("username"))).click();
	driver.findElement(By.xpath(locators.getProperty("username"))).sendKeys("KM91738");
	driver.findElement(By.xpath(locators.getProperty("password"))).clear();
	driver.findElement(By.xpath(locators.getProperty("password"))).sendKeys("dear4343");
	driver.findElement(By.xpath(locators.getProperty("SignIn"))).click();
	driver.findElement(By.xpath(locators.getProperty("txtUserID"))).clear();
	driver.findElement(By.xpath(locators.getProperty("txtUserID"))).sendKeys("DM21388");
	driver.findElement(By.xpath(locators.getProperty("txtPassword"))).clear();
	driver.findElement(By.xpath(locators.getProperty("txtPassword"))).sendKeys("rules");
	driver.findElement(By.xpath(locators.getProperty("Loginbutton"))).click();
	
	
	/* Clicking on closeall */
	
	(new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locators.getProperty("Tabspan"))))).click();
	(new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locators.getProperty("Closeall"))))).click();
	(new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locators.getProperty("Casesearch"))))).click();
	
	ProcessFlowActions.switchToFrameToFindElelementById(driver, "//*[@id='pySearchText']");
	

	Thread.sleep(5000);
	/* Case search*/
	(new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locators.getProperty("Casesearchtext"))))).sendKeys("ISG-599");
	(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(locators.getProperty("image"))))).click();
	// Thread.sleep(4000);
	(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.linkText("ISG-599")))).click();
	// Thread.sleep(5000);
	// ProcessFlowActions.switchToFrameToFindElelement(driver, locator);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("PegaGadget1Ifr");
	(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.field-item.dataValueRead > button.Simple.pzhc")))).click();
	// Thread.sleep(3000);
	(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(locators.getProperty("workcase"))))).click();
	// Thread.sleep(5000);
	(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(locators.getProperty("close"))))).click();
	 Thread.sleep(5000);
	driver.findElement(By.cssSelector("div.field-item.dataValueRead >button.Simple.pzhc")).click();
	 //Thread.sleep(5000);
	/* Reopening the case*/
	(new WebDriverWait(driver, 300).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("Reopen"))))).click();
	//DeleteTempFiles.deleteTemp();
	//DeleteTempFiles.deleteCookies(driver);
	driver.quit();
	
	
	}
}
	
	
	
	
