
	package com.incessant.uiautomation.ui.actions;

	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.io.FileWriter;
	import java.util.List;
	import java.util.Properties;
	import java.util.Scanner;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;

	import com.incessant.uiautomation.FwConstants;
	import com.incessant.uiautomation.util.ConfPropertyReader;
	import com.incessant.uiautomation.util.FWWait;
	import com.incessant.uiautomation.util.XLReader;

	public class JDParts_WebFormPage {
		WebDriver driver;
		
		//xpath for JD webform page.//
		
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
//		By JDPartsUsername=By.xpath(locators.getProperty("JDPartsUsername"));
//		By JDPartsSignIn= By.xpath(locators.getProperty("JDPartsSignIn"));
		By JDWebformClickOnCaseSearch=By.xpath(locators.getProperty("JDWebformClickOnCaseSearch"));
		By JDPartsWebFormFirstNameLastName=By.xpath(locators.getProperty("JDPartsWebFormFirstNameLastName"));
		By JDPartsWebFormSubmitButton=By.xpath(locators.getProperty("JDPartsWebFormSubmitButton"));
		By JDCaseSearch=By.xpath(locators.getProperty("JDCaseSearch"));
		By JDPartsName=By.xpath(locators.getProperty("JDPartsName"));
		By JDPartsEmail=By.xpath(locators.getProperty("JDPartsEmail"));
		By JDPartsComment=By.xpath(locators.getProperty("JDPartsComment"));
		By JDPartsMessage=By.xpath(locators.getProperty("JDPartsMessage"));
		By JDPartsAttachFile=By.xpath(locators.getProperty("JDPartsAttachFile"));
		By JDPartsMessageText=By.xpath(locators.getProperty("JDPartsMessageText"));
		By JD_Attach=By.xpath(locators.getProperty("JD_Attach"));
		By JDPartsSearchIcon=By.xpath(locators.getProperty("JDPartsSearchIcon"));
		By JDCaseIDLink=By.xpath(locators.getProperty("JDCaseIDLink"));
		By JDWorkbasket=By.xpath(locators.getProperty("JDWorkbasket"));
		

		
		


		List<String> inputData = null;
		
	
	
		public  String JDPartValidation(WebDriver driver) throws Exception
		    	{
		    	Thread.sleep(10000);
		    	//First name and last name to display
				 String firstname=driver.findElement(JDPartsWebFormFirstNameLastName).getText();
				 System.out.println("Customer name is:" +firstname);
				 
				 //Phone number to display
				 
				 Assert.assertTrue(driver.findElement(JDPartsName).isDisplayed(),"phone number is not diplayed");
				 System.out.println("Phone number is displayed");
				 
				 //Email to display.
				 Assert.assertTrue(driver.findElement(JDPartsEmail).isDisplayed(),"email is not diplayed");
				 System.out.println("Email is displayed");
				 
				
				 //Enter in comment section.
				 driver.findElement(JDPartsComment).sendKeys("abcdefghijkl");
				 System.out.println("enetered value in comment section");
				 
				 
				 //click on Add files
				 driver.findElement(JDPartsAttachFile).click();
				 System.out.println("done");
				 Thread.sleep(6000);
				
				 
				 Thread.sleep(6000);
				 WebElement click1 = driver.findElement(By.xpath("//*[@class=\"buttonLeftContent\"]"));
					
					new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf
							(driver.findElement(By.xpath("//*[@class=\"buttonLeftContent\"]"))));
					
					//Action class
					Actions builder = new Actions(driver);   
					builder.moveToElement(click1).click(click1).build().perform();
					Thread.sleep(70000);
					System.out.println("fileupload 'selectbutton' clicked successfully"); 
					
					/// Specify the file location with extension
					 StringSelection sel = new StringSelection("C:\\Users\\sandeepr\\Desktop\\JHD.PNG");
					 System.out.println("File uploaded successfully");
					 
					 
					  // Copy to clipboard
					 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
					 System.out.println("selection" +sel); 
					 Thread.sleep(10000);
				 
					Robot robot=new Robot();
					
					 robot.keyPress(KeyEvent.VK_ENTER);
					 
					// Release Enter
					 robot.keyRelease(KeyEvent.VK_ENTER);
					 
					  // Press CTRL+V
					 robot.keyPress(KeyEvent.VK_CONTROL);
					 robot.keyPress(KeyEvent.VK_V);
					 
					// Release CTRL+V
					 robot.keyRelease(KeyEvent.VK_CONTROL);
					 robot.keyRelease(KeyEvent.VK_V);
					 Thread.sleep(1000);
					        
					         //Press Enter 
					 robot.keyPress(KeyEvent.VK_ENTER);
					 robot.keyRelease(KeyEvent.VK_ENTER); 
					 
				//Click on Attach	 
				driver.findElement(JD_Attach).click();
				System.out.println("Attachment done successfully.");
				
			
				
				Thread.sleep(7000);
				//click on submit button
				driver.findElement(JDPartsWebFormSubmitButton).click();
				System.out.println("JD parts webform submit button clicked successfully");
				
				Thread.sleep(3000);
				 // Thanku message.		 
				 WebElement element=driver.findElement(By.xpath("JDPartsMessage"));
				 String Message=element.getText();
				 System.out.println("Thank you message should display"+ Message );
					 
				 // split the message and retrive the ID:
					 
				 String str=driver.findElement(By.xpath("//*[@data-test-id='2015012615503109611417']")).getText();
				 
								
					System.out.println(str);
					String[] strArr;
					String Case_ID;
					strArr=str.split(" ");
						
					Case_ID=strArr[8]; 
			     	System.out.println("CaseId is generated"+Case_ID);			
					
			     	FileWriter fw=new FileWriter(FwConstants.JDParts_CASEID_File);    
			        fw.write(Case_ID);    
			        fw.close();
					return Case_ID;
				  } 
		

		public JDParts_WebFormPage(WebDriver driver){
		this.driver = driver;
		} 
		public  void CaseSearcRouting(String Case_ID) throws Exception
		{
			        
			       
			    	//switch to frame
				    driver.switchTo().frame("PegaGadget0Ifr");
					 Thread.sleep(2000);
					 System.out.println("Switched to frame PegaGadget0Ifr ");
					 			   
			    //enter the Id in case search textbox
				   driver.findElement(By.xpath("JDCaseSearch")).sendKeys(Case_ID);
				   
				//click on search icon
				   driver.findElement(JDPartsSearchIcon).click();
				   
				   JE();
				 //click on caseIDLink:
				   driver.findElement(JDCaseIDLink).click();
				   
				 
				 //switch to default content  
				   driver.switchTo().defaultContent();
					 driver.switchTo().frame("PegaGadget1Ifr");
					
				 //Fetching workbasket details 
			     String workbasket =driver.findElement(JDWorkbasket).getText();
		  		 System.out.println(""+workbasket);
		  		
		}	
		public void JE() {
	        JavascriptExecutor js = (JavascriptExecutor)driver;  
	        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
	        
	 } 
}
