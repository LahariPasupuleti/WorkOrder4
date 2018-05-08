package com.incessant.uiautomation.ui.actions;

	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.io.File;
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
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.incessant.uiautomation.FwConstants;
	import com.incessant.uiautomation.util.ConfPropertyReader;


	public class IndiaCountry_WebFormPage {

		
		
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		By AgronomyUsername=By.xpath(locators.getProperty("AgronomyUsername"));
		By AgronomyPassword=By.xpath(locators.getProperty("AgronomyPassword"));
		By AgronomySignInButton=By.className(locators.getProperty("AgronomySignInButton"));
		By Agronomyheader=By.xpath(locators.getProperty("Agronomyheader"));
		By AgronomyComments = By.xpath(locators.getProperty("AgronomyComments"));
		By Agronomyclicktoaddfilesbutton = By.xpath(locators.getProperty("Agronomyclicktoaddfilesbutton"));
		By Agronomyuplodedfile = By.xpath(locators.getProperty("Agronomyuplodedfile"));
//		By ISGCustInfoRadioButton=By.xpath(locators.getProperty("ISGCustomer_RadioButton"));
//		By ISGCustSubmitButton=By.id(locators.getProperty("ISGSubmitButton"));
//		By ISGAct_Button=By.xpath(locators.getProperty("ISGAct_Button"));
//		By ISGAccept_Button=By.xpath(locators.getProperty("ISGAccept_Button"));
//		By ISGAction_TWB=By.xpath(locators.getProperty("ISGAction_TWB"));
//		By ISG_TransferButton=By.xpath(locators.getProperty("ISG_TransferButton"));
		By Agronomyattachbutton=By.xpath(locators.getProperty("Agronomyattachbutton"));
		By Agronomyattachedfiledetails=By.xpath(locators.getProperty("Agronomyattachedfiledetails"));
		By Agronomysubmitbutton=By.xpath(locators.getProperty("Agronomysubmitbutton"));
		By Agronomythankumessage=By.xpath(locators.getProperty("Agronomythankumessage"));
		By AgroniomyCase_Id=By.xpath(locators.getProperty("AgroniomyCase_Id"));
		By AgronomySearchbox=By.xpath(locators.getProperty("AgronomySearchbox"));
		By ArronomySearchimage=By.xpath(locators.getProperty("ArronomySearchimage"));
		By caseidclick=By.xpath(locators.getProperty("caseidclick"));
		By workbasketinfo=By.xpath(locators.getProperty("workbasketinfo"));
		
		List<String> inputData = null;
		public WebDriver driver;

		
		/**
		 * 
		 * @param testCaseId
		 * @throws InterruptedException 
		 */
		public void IndiaCountry_WebFormsSubmit(WebDriver driver) throws Exception {
			
			
//			driver.findElement(AgronomyUsername).sendKeys("KM91738");
//			System.out.println("Entered UserName ");
//			Thread.sleep(1000);
//			driver.findElement(AgronomyPassword).sendKeys("dear4343");
//			System.out.println("Entered Pasword ");
//			Thread.sleep(1000);
//			driver.findElement(AgronomySignInButton).click();
//			System.out.println("click on  signIn Button ");
			Thread.sleep(8000);
			
			String Header=driver.findElement(Agronomyheader).getText();
			System.out.println(Header);
			
			driver.findElement(AgronomyComments).sendKeys("creating sample ISG Case ");
			System.out.println("Entered data in comments section");
			Thread.sleep(3000);
			
			driver.findElement(Agronomyclicktoaddfilesbutton).click();
			Thread.sleep(6000);
			System.out.println("clicktoaddfiles button  clicked successfully");
			WebElement click1 = driver.findElement(By.xpath("//*[@class=\"buttonLeftContent\"]"));
			
			new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath("//*[@class=\"buttonLeftContent\"]"))));
			
			
			
			Actions builder = new Actions(driver);   
			builder.moveToElement(click1).click(click1).build().perform();
			Thread.sleep(60000);
			System.out.println("fileupload 'selectbutton' clicked successfully");
			
			// Specify the file location with extension
			StringSelection sel = new StringSelection("C:\\Users\\sandeepr\\Desktop\\JHD.PNG");
					 
					   // Copy to clipboard
					 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
					 //System.out.println("selection" +sel);
					
			 // Create object of Robot class
			 Robot robot = new Robot();
			 Thread.sleep(1000);
			      
			  // Press Enter
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
			 
			//Thread.sleep(10000);
			System.out.println("File uploded  successfully");

			Thread.sleep(10000);
			
			String tabledata=driver.findElement(Agronomyuplodedfile).getText();
			
			
			System.out.println("Please find the below uploaded file details :");
			System.out.println("----------------------------------------------");
			System.out.println("" +"\n" +tabledata);
			
			driver.findElement(Agronomyattachbutton).click();
			System.out.println("clicked on  'Attach' button");
			Thread.sleep(60000);
			String Attachedfile=driver.findElement(Agronomyattachedfiledetails).getText();
			System.out.println("Attachedfile Details" +"\n" +Attachedfile);
			
			driver.findElement(Agronomysubmitbutton).click();
			System.out.println("click on 'Submit' Button");
			Thread.sleep(3000);
			String thankuMessage=driver.findElement(Agronomythankumessage).getText();
			System.out.println(" "+thankuMessage);
			
			
			String[] strArr = thankuMessage.split(" ");
			
			String Case_ID = strArr[8];
			
			System.out.println(""+Case_ID);  
			
			FileWriter fw=new FileWriter(FwConstants.India_CaseID);    
	        fw.write(Case_ID);    
	        fw.close();  
			
		}
		public void IndiaCountry_CaseIDRouting(WebDriver driver) throws Exception {
		Thread.sleep(1000);
		
//		String filepath="FwConstant.Agronomy_CaseID";
		Scanner myScanner = new Scanner(new File(FwConstants.India_CaseID));
		String caseid = null;
		while (myScanner.hasNextLine()) {
			caseid = myScanner.nextLine();
	}
		
		driver.findElement(AgroniomyCase_Id).click();
		 Thread.sleep(4000);
		 
		 System.out.println("Clicked on Case Search");
		 
	     driver.switchTo().frame("PegaGadget0Ifr");
		 Thread.sleep(2000);
		 System.out.println("Switched to frame PegaGadget0Ifr ");
		 
		 
		 driver.findElement(AgronomySearchbox).sendKeys(caseid);
		 System.out.println("Entered Case Value into search box");
		 Thread.sleep(3000);

		 
		 driver.findElement(ArronomySearchimage).click();
		 System.out.println("Clicked on Search img button");
		 
		 Thread.sleep(3000);
		 driver.findElement(caseidclick).click();
		 System.out.println("Clicked on Case ID Link");
		 Thread.sleep(3000);
		 
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("PegaGadget1Ifr");
		 
		 //Fetching workbasket Info
		String workbasket =driver.findElement(workbasketinfo).getText();
	   System.out.println(""+workbasket);
		
		}

		public IndiaCountry_WebFormPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void JE() {
	        JavascriptExecutor js = (JavascriptExecutor)driver;  
	        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
	        
	 }

	}


