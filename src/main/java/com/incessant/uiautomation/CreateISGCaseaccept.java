package com.incessant.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.incessant.uiautomation.ui.actions.ProcessFlowActions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateISGCaseaccept {
	@Test
	public void caseISG() throws InterruptedException{
	//WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32 (8)/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://ccmstal.tal.deere.com/prweb/PRServlet");
	driver.manage().window().maximize();
	//ProcessFlowActions.LoginJohnDeere(driver);
	
	/* Logging with valid credentials*/
	
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
    Thread.sleep(1000);
    driver.findElement(By.xpath("//label[contains(text(),'Home')]")).click();
    
    /* Creating ISG Case*/
    
    driver.findElement(By.xpath("//button[contains(text(),'Create ISG Case')]")).click();
    // driver.switchTo().defaultContent();
     Thread.sleep(9000);
     ProcessFlowActions.switchToFrameToFindElelement(driver, "(//i[@class='icons JD JD-JDAddSecondary'])[1]");
     //driver.switchTo().defaultContent();
      driver.switchTo().frame("PegaGadget2Ifr");
      Thread.sleep(4000);
     (new WebDriverWait(driver, 60)
     .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='icons JD JD-JDAddSecondary'])[1]")))).click();
    /*driver.findElement(By.xpath("//table[@id=\"RULE_KEY\"][@aria-label=\"Home\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/div[3]/div/div/div[2]/div/div/div/div/span/button")).click();
	Thread.sleep(5000);
	new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	Thread.sleep(5000);
WebElement addAccount = driver.findElement(By.xpath("(//i[@data-test-id='201512210438090148308293'])[1]"));
	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addAccount));
	addAccount.click();
	Thread.sleep(5000);*/
     driver.switchTo().defaultContent();
     
     /* Add Customer Information*/
     
	driver.findElement(By.xpath("//*[@id=\"SearchContactUserName\"]")).sendKeys("TYLER"); 
     driver.findElement(By.xpath(".//*[@id='ContactSearchLastName']")).sendKeys("POWELL");
 	new Select(driver.findElement(By.xpath(".//*[@id='CustomerSearchCountryCode']"))).selectByVisibleText("US");
 	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[2]/div/div/div/div/span/button")).click();
 	driver.findElement(By.xpath(".//*[@id='DefaultAG']")).click();
 	driver.findElement(By.xpath(".//*[@id='ModalButtonSubmit']")).click();
 	
 	/* Adding product info*/
 	
 	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div[1]/div/div/div[1]/div/div/span/i")).click();
 	new Select(driver.findElement(By.xpath(".//*[@id='DecalModel']"))).selectByVisibleText("2020A/ProGator Gas/Utility Vehicles");
 	driver.switchTo().activeElement().sendKeys(Keys.TAB);
 	driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/div/div/div/div/div/span/button")).click();
 	
 	/* Entering case coding*/
 	
 	driver.findElement(By.xpath(".//*[@id='FUNC_AREA_NM']")).sendKeys("CCE DLR");
 	driver.switchTo().activeElement().sendKeys(Keys.TAB);
 	driver.findElement(By.xpath(".//*[@id='FUNC_CODE_NM']")).sendKeys("No Interest");
 	driver.switchTo().activeElement().sendKeys(Keys.TAB);
 	
 	/* Case information entry*/
 	
 	new Select(driver.findElement(By.xpath(".//*[@id='FunctionalIssue']"))).selectByVisibleText("Activate");
 	 new Select(driver.findElement(By.xpath(".//*[@id='CasePriority']"))).selectByVisibleText("1-Tech in Field - Urgent");
 	 new Select(driver.findElement(By.xpath(".//*[@id='Origin']"))).selectByVisibleText("Email");
 	 driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div/div/div/input")).sendKeys("DM");
 	 
 	 /* Accepting the case*/
 	 driver.findElement(By.xpath(".//*[@id='RULE_KEY']/div/div/div/div[1]/div/div/div/div/div[1]/span/button")).click();
}
}