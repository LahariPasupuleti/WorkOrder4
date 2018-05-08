package com.incessant.uiautomation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Sample_US31540 {

	static WebDriver driver;
	@Test
	public void m1() throws AWTException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://ccmstal.tal.deere.com/prweb/MyJohnDeereAuth?pyActivity=Deere-CCMS-Case-CM-Work-ISG.SnapStartCreateCase&MashUp=Stellar+Support");
	driver.findElement(By.id("userName")).sendKeys("KM91738");
	driver.findElement(By.name("password")).sendKeys("dear4343");
	driver.findElement(By.xpath("//input[@class=\"cta_btn\"]")).click();
	
	//customer name 
	String cust_name=driver.findElement(By.xpath("//div[@class=\"content-item content-field item-1 flex flex-row dataValueRead\"]")).getText();
	System.out.println("" +cust_name);
	//mobile number
	String mob_num=driver.findElement(By.xpath("//div[@class='content-item content-field item-5 flex flex-row dataValueRead']")).getText();
	System.out.println("" +mob_num);
	//email id
	String email_id=driver.findElement(By.xpath("//div[@class=\"content-item content-field item-6 flex flex-row dataValueRead\"]")).getText();
	System.out.println("" +email_id);
	//Display message
	String Disp_msg=driver.findElement(By.xpath("//div[@class=\"content-item content-label item-1 flex flex-row dataLabelWrite\"]")).getText();
	System.out.println("" +Disp_msg);
	
	//Comments/questions
	driver.findElement(By.xpath("//textarea[@id=\"WebformComment\"]")).sendKeys("This is Sample Stellar Support ISG");
	
	
	//Dealer name
	driver.findElement(By.xpath("//input[@name=\"$PpyWorkPage$pDealerName\"]")).sendKeys("ABC1");
	System.out.println("Dealer name entered");
	//Dealer city
	driver.findElement(By.xpath("//input[@name=\"$PpyWorkPage$pDealerCity\"]")).sendKeys("California");
	System.out.println("Dealer City entered");
	//Dealer state
	driver.findElement(By.xpath("//input[@name=\"$PpyWorkPage$pDealerState\"]")).sendKeys("US");
	System.out.println("Dealer State entered");
	JE();
	
	//Adding files 
	driver.findElement(By.xpath("//img[@name=\"MKTCaseAttachments_pyWorkPage_3\"]")).click();
	JE();
	//clicking on slect button
	WebElement Browse = driver.findElement(By.xpath("//button[@id=\"Browsefiles\"]"));
	
	
     Actions builder = new Actions(driver);
     builder.moveToElement(Browse).click(Browse).build().perform();
     JE();		
	StringSelection sel=new StringSelection("C:\\Users\\sandeepr\\Desktop\\JHD.PNG");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	
	
	Robot rob=new Robot();
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	
	rob.keyPress(KeyEvent.VK_CONTROL);
	rob.keyPress(KeyEvent.VK_V);
	rob.keyRelease(KeyEvent.VK_V);
	rob.keyRelease(KeyEvent.VK_CONTROL);
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("file uploaded");
	Thread.sleep(6000);
	//Entering the name 
	driver.findElement(By.xpath("//input[@id=\"pyNote1\"]")).sendKeys("Johndeere_ISG");
	//getting the text of uploaded file
	String file_name=driver.findElement(By.xpath("//span[@data-test-id=\"20170905142532037720244\"]")).getText();
	System.out.println(""+file_name);
	
	//selecting the drop down category
	new Select(driver.findElement(By.xpath("//select[@name=\"$PdragDropFileUpload$ppxResults$l1$ppyCategory\"]"))).selectByVisibleText("File");
	//selecting the attachement category
	new Select(driver.findElement(By.xpath("//select[@name=\"$PdragDropFileUpload$ppxResults$l1$pAttachmentCategory\"]"))).selectByVisibleText("External");
	//clicking on attach button
	driver.findElement(By.xpath("//button[@data-test-id=\"20140919030420037410647\"]")).click();
	//validating the attched file
	String Val_attach=driver.findElement(By.xpath("//div[@class=\"content-item content-layout item-1 remove-top-spacing remove-bottom-spacing float-left set-width-auto   \"]")).getText();
	System.out.println(""+Val_attach);
	
	JE();
	//clicking on submit button
	//driver.findElement(By.xpath("//button[@name=\"WebformButtons_pyWorkPage_1\"]")).click();
	
	driver.findElement(By.xpath("//button[@data-test-id=\"2018032009190808106446\"]")).click();
	
	
	
}
	public static void JE() {
	    JavascriptExecutor js = (JavascriptExecutor)driver;  
	    js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
	    
	}

}