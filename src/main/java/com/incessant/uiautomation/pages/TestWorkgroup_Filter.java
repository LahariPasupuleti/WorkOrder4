package com.incessant.uiautomation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestWorkgroup_Filter {
	static WebDriver driver;
	@Test
	public void workgroup_Filter() throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://ccmstal.tal.deere.com/prweb/PRServlet/KNVG0wEqb5bkSbyw_iI6Mw%5B%5B /!STANDARD?pzPostData=-2016800972");
	driver.findElement(By.id("username")).sendKeys("KM91738 ");
	driver.findElement(By.name("PASSWORD")).sendKeys("dear4343");
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div[5]/div/button")).click();
	waitFor(driver, 20, By.xpath("/html/body/form/div[1]/img"));// wait for Pega Login page
	driver.findElement(By.id("txtUserID")).sendKeys("DM21388");
	driver.findElement(By.id("txtPassword")).sendKeys("rules");
	driver.findElement(By.id("sub")).click();
	
//	waitFor(driver, 20, By.xpath(("//*[@id='RULE_KEY'])[6]")));
	driver.findElement(By.xpath("(//*[@id='RULE_KEY'])[6]")).click();
	driver.findElement(By.xpath("(//*[@data-test-id=\"201708231545550244393669\"])[1]")).click();
//	waitFor(driver, 20, By.xpath(("//*[@uniqueid=\"SID1522902081021\"]")));
//	driver.findElement(By.xpath("//*[@uniqueid='SID1522902081021']")).click();
	
	
	driver.findElement(By.xpath("//*[@name='$PpyDisplayHarness$pFilterOptList$gWG$pFilterOpt$l1$pPropertyName']")).sendKeys("AgCC");
	
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[text()='AgCC'])[1]")).click();
	
	Thread.sleep(2000);
//	WebElement sub_Group = driver.findElement(By.xpath("//*[@id=\"RULE_KEY\"]/fieldset/div/div[2]/div/div/div/div/div"));
//	new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(sub_Group));
	driver.findElement(By.xpath("//*[@id='RULE_KEY']/fieldset/div/div[2]/div/div/div/div/div")).click();
	
	
//	waitFor(driver, 20, By.xpath(("(//*[@name=\"$PpyDisplayHarness$pFilterOptList$gSWG$pFilterOpt$l2$pSelectCheckBox\"])[2]")));
	driver.findElement(By.xpath("(//*[@data-test-id=\"20180215124155099052369\"])[2]")).click();
	driver.findElement(By.xpath("(//*[@class='buttonTdButton'])[1]")).click();////subgroup submit

	driver.findElement(By.xpath("(//*[@id='SelectCheckBox4'])[2]")).click();//case type check
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@data-test-id='20141008160437053510472']")).click();//submit button
	
	}
	
	
	
	public void waitFor(WebDriver driver, long timeOutInSeconds, By by) {
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitThread(long TimeinSeconds) throws InterruptedException {
		Thread.sleep(TimeinSeconds);
	}

}
