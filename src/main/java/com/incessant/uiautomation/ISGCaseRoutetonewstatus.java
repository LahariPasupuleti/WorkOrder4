package com.incessant.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ISGCaseRoutetonewstatus {
	@Test
	public void caseISG() throws InterruptedException{
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
	driver.findElement(By.xpath("//*[@id='RULE_KEY']/tbody/tr/td[2]")).click();
	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div[3]/div/div/div[2]/div/div/div/div/span/button")).click();
	Thread.sleep(100);
	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/span/i")).click();
	driver.findElement(By.xpath(".//*[@id='SearchContactFirstName']")).sendKeys("TYLER");
	driver.findElement(By.xpath(".//*[@id='ContactSearchLastName']")).sendKeys("POWELL");
	new Select(driver.findElement(By.xpath(".//*[@id='CustomerSearchCountryCode']"))).selectByVisibleText("US");
	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/div/div/span/button")).click();
	driver.findElement(By.xpath(".//*[@id='DefaultAG']")).click();
	driver.findElement(By.xpath(".//*[@id='ModalButtonSubmit']")).click();
	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div[1]/div/div/div[1]/div/div/span/i")).click();
	new Select(driver.findElement(By.xpath(".//*[@id='DecalModel']"))).selectByVisibleText("2020A/ProGator Gas/Utility Vehicles");
	driver.switchTo().activeElement().sendKeys(Keys.TAB);
	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/div/div/div/div/div/span/button")).click();
	driver.findElement(By.xpath(".//*[@id='FUNC_AREA_NM']")).sendKeys("CCE DLR");
	driver.switchTo().activeElement().sendKeys(Keys.TAB);
	driver.findElement(By.xpath(".//*[@id='FUNC_CODE_NM']")).sendKeys("No Interest");
	driver.switchTo().activeElement().sendKeys(Keys.TAB);
	new Select(driver.findElement(By.xpath(".//*[@id='FunctionalIssue']"))).selectByVisibleText("Activate");
	 new Select(driver.findElement(By.xpath(".//*[@id='CasePriority']"))).selectByVisibleText("1-Tech in Field - Urgent");
	 new Select(driver.findElement(By.xpath(".//*[@id='Origin']"))).selectByVisibleText("Email");
	 driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div/div/div/input")).sendKeys("DM");
	 driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/div/div/div[3]/span/button")).click();
	
	}
}
