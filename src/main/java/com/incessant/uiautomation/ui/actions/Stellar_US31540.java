package com.incessant.uiautomation.ui.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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
import com.incessant.uiautomation.util.DriverActions;
import com.incessant.uiautomation.util.XLReader;



public class Stellar_US31540{
	
		
		static WebDriver driver = null;
		Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
		By ISGCaseCreation=By.xpath(locators.getProperty("ISGCaseCreation"));
		By ISGAddCust_Button=By.xpath(locators.getProperty("ISGAddCust_Button"));
		//customer info
		By Country_Code=By.id(locators.getProperty("ISGCountry_code"));
		By CountryCode_Select=By.xpath(locators.getProperty("ISGCountrycode_Click"));
		By FirstName = By.xpath(locators.getProperty("ISGAddCustFirstName"));
		By LastName = By.xpath(locators.getProperty("ISGAddCustLastname"));
		By SearchCustomers = By.xpath(locators.getProperty("ISGCustomer_SearchButton"));
		By ISGCustInfoRadioButton=By.xpath(locators.getProperty("ISGCustomer_RadioButton"));
		By ISGCustSubmitButton=By.id(locators.getProperty("ISGSubmitButton"));
		//Product info
		By ISGProductinfo_Button=By.xpath(locators.getProperty("ISGProductinfo_Button"));
		By ISGModelDialog= By.xpath(locators.getProperty("ISGModeldialog"));
		//By ISGModelDialog_Select= By.xpath(locators.getProperty("ISGModelDialog_Select"));
		By ISGModelSubmit=By.xpath(locators.getProperty("ISGModelSubmit"));
		
		//Case Coding
		By ISGFunctionalArea=By.id(locators.getProperty("ISGFunctionalArea"));
		By ISGFunctionalArea_Select=By.xpath(locators.getProperty("ISGFunctionalArea_Select"));
		By ISGFunctionalCode=By.xpath(locators.getProperty("ISGFunctionalCode"));
		By ISGFunctionalCode_Select=By.xpath(locators.getProperty("ISGFunctionalCode_Select"));
		By ISGFunctionalIssue=By.id(locators.getProperty("ISGFunctionalIssue"));
		//Case Info
		By ISGCase_Priority=By.id(locators.getProperty("ISGCase_Priority"));
		By ISGCaselanguagecode=By.id(locators.getProperty("ISGCaselanguagecode"));
		By ISGCase_Origin=By.id(locators.getProperty("ISGCase_Origin"));
		//Problem details
		By ISGSummary=By.xpath(locators.getProperty("ISGSummary"));
		
		//Buttons
		By ISGAccept_Button=By.xpath(locators.getProperty("ISGAccept_Button"));
		By ISGRoute_Button=By.xpath(locators.getProperty("ISGRoute_Button"));
		By ISGClose_Button=By.xpath(locators.getProperty("ISGClose_Button"));
		
		By ISG_NewDraft= By.xpath(locators.getProperty("ISG_NewDraft"));
		By ISG_New1= By.xpath(locators.getProperty("ISG_New1"));
		By ISG_Owned= By.xpath(locators.getProperty("ISG_Owned"));
		By ISG_Resolve_completed= By.xpath(locators.getProperty("ISG_Resolve_completed"));
//		By ISG_Action=By.xpath(locators.getProperty("ISG_Action"));
		By ISGAction_DP=By.xpath(locators.getProperty("ISGAction_DP"));
		By ISGAction_frame=By.xpath(locators.getProperty("ISGAction_frame"));
		By ISGAction_framelist=By.xpath(locators.getProperty("ISGAction_framelist"));
		By ISGNewText=By.xpath(locators.getProperty("ISGNewText"));
		By ISGwork_Case=By.xpath(locators.getProperty("ISGwork_Case"));
		By ISG_Actions_Reopened=By.xpath(locators.getProperty("ISG_Actions_Reopened"));
		
		//Stellar_paths
		By Stellar_Custname=By.xpath(locators.getProperty("Stellar_Custname"));
		By Stellar_Custmobnum=By.xpath(locators.getProperty("Stellar_Custmobnum"));
		By Stellar_Custemail=By.xpath(locators.getProperty("Stellar_Custemail"));
		By Stellar_Dispmsg=By.xpath(locators.getProperty("Steallr_Dispmsg"));
		By Stellar_Comment=By.xpath(locators.getProperty("Stellar_Comment"));
		By Stellar_Dealername=By.xpath(locators.getProperty("Stellar_Dealername"));
		By Stellar_Dealercity=By.xpath(locators.getProperty("Stellar_Dealercity"));
		By Stellar_Dealerstate=By.xpath(locators.getProperty("Stellar_Dealerstate"));
		By Stellar_AttachButton=By.xpath(locators.getProperty("Stellar_AttachButton"));
		By Stellar_SelectButton=By.xpath(locators.getProperty("Stellar_SelectButton"));
		By Stellar_Attachfiletxt=By.xpath(locators.getProperty("Stellar_Attachfiletxt"));
		By Stellar_Attachfilename=By.xpath(locators.getProperty("Stellar_Attachfilename"));
		By Stellar_AttachdropdownCategory=By.xpath(locators.getProperty("Stellar_AttachdropdownCategory"));
		By Stellar_AttachCategory=By.xpath(locators.getProperty("Stellar_AttachCategory"));
		By Stellar_AttachSubmitButton=By.xpath(locators.getProperty("Stellar_AttachSubmitButton"));
		By Stellar_Validating_file=By.xpath(locators.getProperty("Stellar_Validating_file"));
		By Stellar_SubmitButton=By.xpath(locators.getProperty("Stellar_SubmitButton"));
		By Final_msg=By.xpath(locators.getProperty("Final_msg"));
		
		//case search
		By CCMS_Casesearch=By.xpath(locators.getProperty("CCMS_Casesearch"));
		By CaseSearch_frame=By.xpath(locators.getProperty("CaseSearch_frame"));
		By search_coloumn=By.xpath(locators.getProperty("search_coloumn"));
		By Search_click=By.xpath(locators.getProperty("Search_click"));
		By case_selection=By.xpath(locators.getProperty("case_selection"));
		
		
		
		  String strArr[];
		 String Case_ID;
		
		
		
		

		List<String> inputData = null;

		/**
		 * 
		 * @param testCaseId
		 * @throws AWTException 
		 * @throws InterruptedException 
		 * @throws IOException 
		 */
		
		public String webform_US31540() throws AWTException, InterruptedException, IOException {
			
			
			Thread.sleep(5000);
			
			
			//customer name 
			String cust_name=driver.findElement(Stellar_Custname).getText();
			System.out.println("" +cust_name);
			//mobile number
			String mob_num=driver.findElement(Stellar_Custmobnum).getText();
			System.out.println("" +mob_num);
			//email id
			String email_id=driver.findElement(Stellar_Custemail).getText();
			System.out.println("" +email_id);
			//Display message
			String Disp_msg=driver.findElement(Stellar_Dispmsg).getText();
			System.out.println("" +Disp_msg);
			
			//Comments/questions
			driver.findElement(Stellar_Comment).sendKeys("This is Sample Stellar Support ISG");
			
			
			//Dealer name
			driver.findElement(Stellar_Dealername).sendKeys("ABC1");
			System.out.println("Dealer name entered");
			//Dealer city
			driver.findElement(Stellar_Dealercity).sendKeys("California");
			System.out.println("Dealer City entered");
			//Dealer state
			driver.findElement(Stellar_Dealerstate).sendKeys("US");
			System.out.println("Dealer State entered");
			
			
			//Adding files 
			driver.findElement(Stellar_AttachButton).click();
			System.out.println("Add button clicked");
			Thread.sleep(10000);
			//clicking on select button
			WebElement Browse = driver.findElement(Stellar_SelectButton);
			
			
		     Actions builder = new Actions(driver);
		     builder.moveToElement(Browse).click(Browse).build().perform();
		     System.out.println("Select browse button clicked");	
		     StringSelection sel=new StringSelection("C:\\Users\\sandeepr\\Desktop\\JHD.PNG");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);		
			
			
			Thread.sleep(3000);
			Robot rob=new Robot();
			
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			JE();
			//Entering the name 
			//driver.findElement(Stellar_Attachfiletxt).clear();
			//driver.findElement(Stellar_Attachfiletxt).sendKeys("Johndeere_ISG");
			//getting the text of uploaded file
			String file_name=driver.findElement(Stellar_Attachfilename).getText();
			System.out.println(""+file_name);
			
			//selecting the drop down category
			//new Select(driver.findElement(Stellar_AttachdropdownCategory)).selectByVisibleText("File");
			//selecting the attachement category
			//new Select(driver.findElement(Stellar_AttachCategory)).selectByVisibleText("External");
			//clicking on attach button
			driver.findElement(Stellar_AttachSubmitButton).click();
			System.out.println("File Uploaded");
			//validating the attched file
			//String Val_attach=driver.findElement(Stellar_Validating_file).getText();
			//System.out.println(""+Val_attach);
			
			Thread.sleep(5000);
			//clicking on submit button
			driver.findElement(Stellar_SubmitButton).click();
			System.out.println("Submitted successfully");
			
			Thread.sleep(5000);
			String str=driver.findElement(Final_msg).getText();
			
			System.out.println(str);
			
			String[] strArr = str.split(" ");
			
			String Case_ID = strArr[8];
			
			System.out.println(""+Case_ID);  
			
			FileWriter fw=new FileWriter(FwConstants.StellarSupport_CaseID);    
	        fw.write(Case_ID);    
	        fw.close();
			return Case_ID;   
			
			
		}
		public void case_search_isg(String Case_id) throws InterruptedException {
		 	driver.findElement(CCMS_Casesearch).click();
		 	JE();
		  	System.out.println("Clicked on Case Search");
		  
		  	driver.switchTo().frame("PegaGadget0Ifr");
		  	JE();
		  	System.out.println("Switched to frame PegaGadget0Ifr ");
		  
		  	driver.findElement(search_coloumn).sendKeys(Case_id);
		  	System.out.println("Entered Case Value into search box");
		  	JE();
		  
		  
		  	driver.findElement(Search_click).click();
		  	System.out.println("Clicked on Search img button");
			 
		 	JE();
		 	driver.findElement(case_selection).click();
			System.out.println("Clicked on Case ID Link");
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");

			 
			Thread.sleep(9000);
			WebElement Workbasket = driver.findElement(By.xpath("//span[@data-test-id=\"201605271224490472142949\"]"));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Workbasket));
			String WorkBasket_ISG=Workbasket.getText();
			System.out.println("The Workbasket of case ISG is:"+WorkBasket_ISG);
	}
		
		
		public static void JE() {
		    JavascriptExecutor js = (JavascriptExecutor)driver;  
		    js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
		    
		}

		
	
		
		
		


		

		
		
	



		public void clickOnISGRoute() {
			driver.findElement(ISGRoute_Button).click();//////after clicking it will move to status as NEW
		}

		public void clickOnISGAccept() {
			driver.findElement(ISGAccept_Button).click();
		}
		public void clickOnISGClose() {
			driver.findElement(ISGClose_Button).click();
		}
		

		public void clickOnSubmit(WebDriver driver) {

			driver.findElement(ISGModelSubmit).click();
		}

		public void clickOnSearch(WebDriver driver) {

			driver.findElement(SearchCustomers).click();
		}

		public Stellar_US31540(WebDriver driver) {
			this.driver = driver;
		}
	}



	
	


