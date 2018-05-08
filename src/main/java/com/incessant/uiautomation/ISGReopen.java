package com.incessant.uiautomation;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import com.incessant.uiautomation.ui.actions.DeleteTempFiles;
import com.incessant.uiautomation.ui.actions.ProcessFlowActions;

public class ISGReopen extends DeleteTempFiles {
	
	
	
	//public static void main(String[] args) throws InterruptedException, IOException {
		@Test
		public void casereopen() throws InterruptedException{
		//WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32 (8)/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://ccmstal.tal.deere.com/prweb/PRServlet");
		driver.manage().window().maximize();
		//ProcessFlowActions.LoginJohnDeere(driver);
		
	driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("KM91738");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).clear();
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("dear4343");
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@id='txtUserID']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("DM21388");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules");
		driver.findElement(By.className("loginButton")).click();
		(new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='TABSPAN']/span/span")))).click();
		(new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@id='/contextMenu/CloseAll']/td[2]")))).click();
		(new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Case Search']")))).click();
		// Thread.sleep(5000);
		ProcessFlowActions.switchToFrameToFindElelementById(driver, "//*[@id='pySearchText']");
		(new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='pySearchText']")))).sendKeys("ISG-596");
		(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@role='link']")))).click();
		// Thread.sleep(4000);
		(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.linkText("ISG-596")))).click();
		// Thread.sleep(5000);
		// ProcessFlowActions.switchToFrameToFindElelement(driver, locator);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget1Ifr");
		(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.field-item.dataValueRead > button.Simple.pzhc")))).click();
		// Thread.sleep(3000);
		(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Work Case')]")))).click();
		// Thread.sleep(5000);
		(new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Close')]")))).click();
		 Thread.sleep(5000);
		driver.findElement(By.cssSelector("div.field-item.dataValueRead >button.Simple.pzhc")).click();
		 //Thread.sleep(5000);
		(new WebDriverWait(driver, 200).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Reopen')]")))).click();
		//DeleteTempFiles.deleteTemp();
		//DeleteTempFiles.deleteCookies(driver);
		driver.quit();

	}
}