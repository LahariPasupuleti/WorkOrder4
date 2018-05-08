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
import org.testng.Assert;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.DriverActions;
import com.incessant.uiautomation.util.XLReader;

public class Techpubs_US31550{
	
		
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
		By Techpubs_lang_select=By.xpath(locators.getProperty("Techpubs_lang_select"));
		By Techpubs_Custname=By.xpath(locators.getProperty("Techpubs_Custname"));
		By Techpubs_Custmobnum=By.xpath(locators.getProperty("Techpubs_Custmobnum"));
		By Techpubs_Custemail=By.xpath(locators.getProperty("Techpubs_Custemail"));
		By Techpubs_Dispmsg=By.xpath(locators.getProperty("Techpubs_Dispmsg"));
		By Techpubs_comment=By.xpath(locators.getProperty("Techpubs_comment"));
		By Techpubs_AttachButton=By.xpath(locators.getProperty("Techpubs_AttachButton"));
		By Techpubs_SelectButton=By.xpath(locators.getProperty("Techpubs_SelectButton"));
		By Techpubs_AttachSubmitButton=By.xpath(locators.getProperty("Techpubs_AttachSubmitButton"));
		By Techpubs_SubmitButton=By.xpath(locators.getProperty("Techpubs_SubmitButton"));
		By Techpubs_textareacomment=By.xpath(locators.getProperty("Techpubs_textareacomment"));
		By Techpubs_Langportuegese=By.xpath(locators.getProperty("Techpubs_Langportuegese"));
		By Techpubs_attachment_name=By.xpath(locators.getProperty("Techpubs_attachment_name"));
		By Techpubs_textsubmitbutton=By.xpath(locators.getProperty("Techpubs_textsubmitbutton"));
		By Techpubs_textclearbutton=By.xpath(locators.getProperty("Techpubs_textclearbutton"));
		By Techpubs_Langfrance=By.xpath(locators.getProperty("Techpubs_Langfrance"));
		By Final_msg=By.xpath(locators.getProperty("Final_msg"));
		
		
		//case search
		By CCMS_Casesearch=By.xpath(locators.getProperty("CCMS_Casesearch"));
		By CaseSearch_frame=By.xpath(locators.getProperty("CaseSearch_frame"));
		By search_coloumn=By.xpath(locators.getProperty("search_coloumn"));
		By Search_click=By.xpath(locators.getProperty("Search_click"));
		By case_selection=By.xpath(locators.getProperty("case_selection"));
		
		
		

		List<String> inputData = null;
		 String strArr[];
		 String Case_ID;

		/**
		 * 
		 * @param testCaseId
		 * @return 
		 * @throws AWTException 
		 * @throws IOException 
		 * @throws InterruptedException 
		 */
		
		public String webform_US31550() throws AWTException, IOException, InterruptedException {
			
			Thread.sleep(9000);
			System.out.println("Default language is English ");
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElement(Techpubs_lang_select).isDisplayed(),"Language selector is not displayed");
			System.out.println("Language selector is displayed is"+ driver.findElement(Techpubs_lang_select).getText());
		
			Assert.assertTrue(driver.findElement(Techpubs_Custname).isDisplayed(),"First Name  last nameis not displayed");
			System.out.println("First Name  last name is  displayed English");
			
			Assert.assertTrue(driver.findElement(Techpubs_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
			System.out.println("Phone number is  Dispayed English");
			
			Assert.assertTrue(driver.findElement(Techpubs_Custemail).isDisplayed(), "Email is not Dispayed");
			System.out.println("Email is  Dispayed English");
			
			Assert.assertTrue(driver.findElement(Techpubs_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
			System.out.println("Primary Msg is  displayed English");
			
					
			Assert.assertTrue(driver.findElement(Techpubs_textareacomment).isDisplayed(),"Text area input box is not displayed");
			System.out.println("Comments/questions input box is  displayed English");
			System.out.println("/************************************/");
			Thread.sleep(3000);
			
			
			/*************************************************************************/
			
			//Checking Portugues Language
			
		    new Select(driver.findElement(Techpubs_lang_select)).selectByIndex(1);
		    
		    Thread.sleep(3000);
			
		    String Language=driver.findElement(Techpubs_Langportuegese).getText();
			
			
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(Techpubs_lang_select));
			
			
			
			Assert.assertTrue(driver.findElement(Techpubs_lang_select).isDisplayed(),"Language selector is not displayed");
			System.out.println("Language selector is displayed is "+ Language);
		
			Assert.assertTrue(driver.findElement(Techpubs_Custname).isDisplayed(),"First Name  last nameis not displayed");
			System.out.println("First Name  last name is  displayed");
			
			Assert.assertTrue(driver.findElement(Techpubs_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
			System.out.println("Phone number is  Dispayed");
			
			Assert.assertTrue(driver.findElement(Techpubs_Custemail).isDisplayed(), "Email is not Dispayed");
			System.out.println("Email is  Dispayed");
			
			Assert.assertTrue(driver.findElement(Techpubs_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
			System.out.println("Primary Msg is  displayed");
						
			Assert.assertTrue(driver.findElement(Techpubs_textareacomment).isDisplayed(),"Text area input box is not displayed");
			System.out.println("Comments/questions input box is  displayed");
			
			String Attachment_Message_portugese=driver.findElement(Techpubs_attachment_name).getText();
			System.out.println("Attachment message for portugues is :"+Attachment_Message_portugese );
			
			Assert.assertTrue(driver.findElement(Techpubs_textsubmitbutton).isDisplayed(), "Submit button is not displayed");
			System.out.println("Submit button is displayed in portugues "+driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']")).getText() );
				
			Assert.assertTrue(driver.findElement(Techpubs_textclearbutton).isDisplayed(), "clear button is not displayed");
			System.out.println("Clear button is displayed in portugues :"+ driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_2']")).getText());
			System.out.println("/************************************/");
			/**************************************************************/
			
			//Checking France Language 
			
			new Select(driver.findElement(Techpubs_lang_select)).selectByIndex(2);
			Thread.sleep(3000);		
			 String Language2=driver.findElement(Techpubs_Langfrance).getText();
					
					WebDriverWait wait2 = new WebDriverWait(driver, 30);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(Techpubs_lang_select));
					
					
					
					Assert.assertTrue(driver.findElement(Techpubs_lang_select).isDisplayed(),"Language selector is not displayed");
					System.out.println("Language selector is displayed is "+ Language2);
				
					Assert.assertTrue(driver.findElement(Techpubs_Custname).isDisplayed(),"First Name  last nameis not displayed");
					System.out.println("First Name  last name is  displayed");
					
					Assert.assertTrue(driver.findElement(Techpubs_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
					System.out.println("Phone number is  Dispayed");
					
					Assert.assertTrue(driver.findElement(Techpubs_Custemail).isDisplayed(), "Email is not Dispayed");
					System.out.println("Email is  Dispayed");
					
					Assert.assertTrue(driver.findElement(Techpubs_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
					System.out.println("Primary Msg is  displayed");
								
					Assert.assertTrue(driver.findElement(Techpubs_textareacomment).isDisplayed(),"Text area input box is not displayed");
					System.out.println("Comments/questions input box is  displayed");
					
					String Attachment_Message_france=driver.findElement(Techpubs_attachment_name).getText();
					System.out.println("Attachment message for france is :"+Attachment_Message_france );
					
					Assert.assertTrue(driver.findElement(Techpubs_textsubmitbutton).isDisplayed(), "Submit button is not displayed");
					System.out.println("Submit button is displayed in france "+driver.findElement(Techpubs_textsubmitbutton).getText() );
						
					Assert.assertTrue(driver.findElement(Techpubs_textclearbutton).isDisplayed(), "clear button is not displayed");
					System.out.println("Clear button is displayed in france :"+ driver.findElement(Techpubs_textclearbutton).getText());
					System.out.println("/************************************/");
					Thread.sleep(3000);

			/**************************************************************/
					
			//Drop down language selection
			new Select(driver.findElement(Techpubs_lang_select)).selectByValue("en_US");
			System.out.println("Selected respective language");
			//customer name 
			String cust_name=driver.findElement(Techpubs_Custname).getText();
			System.out.println("" +cust_name);
			//mobile number
			String mob_num=driver.findElement(Techpubs_Custmobnum).getText();
			System.out.println("" +mob_num);
			//email id
			String email_id=driver.findElement(Techpubs_Custemail).getText();
			System.out.println("" +email_id);
			//Display message
			String Disp_msg=driver.findElement(Techpubs_Dispmsg).getText();
			System.out.println("" +Disp_msg);
			
			//Comments/questions
			driver.findElement(Techpubs_comment).sendKeys("This is Sample Techsupport Support GSC");
			System.out.println("Comments entered");
			
			
			JE();
			
			//Adding files 
			driver.findElement(Techpubs_AttachButton).click();
			System.out.println("Add button clicked");
			JE();
			//clicking on select button
			WebElement Browse = driver.findElement(Techpubs_SelectButton);
			JE();
			
		     Actions builder = new Actions(driver);
		     builder.moveToElement(Browse).click(Browse).build().perform();
		     System.out.println("Select browse button clicked");			
			StringSelection sel=new StringSelection("C:\\Users\\sandeepr\\Desktop\\JHD.PNG");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
			
			Thread.sleep(8000);
			
			Robot rob=new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			
			//Entering the name 
			//driver.findElement(By.xpath("//input[@id=\"pyNote1\"]")).sendKeys("Johndeere_GSC");
			//getting the text of uploaded file
			
//			String file_name=driver.findElement(By.xpath("//span[@data-test-id=\"20170905142532037720244\"]")).getText();
//			System.out.println(""+file_name);
			
			//selecting the drop down category
			//new Select(driver.findElement(By.xpath("//select[@name=\"$PdragDropFileUpload$ppxResults$l1$ppyCategory\"]"))).selectByVisibleText("File");
			//selecting the attachement category
			//new Select(driver.findElement(By.xpath("//select[@name=\"$PdragDropFileUpload$ppxResults$l1$pAttachmentCategory\"]"))).selectByVisibleText("External");
			//clicking on attach button
			Thread.sleep(4000);
			driver.findElement(Techpubs_AttachSubmitButton).click();
			System.out.println("File Uploaded");
			//validating the attched file
			Thread.sleep(5000);
			
			
			//clicking on submit button
			driver.findElement(Techpubs_SubmitButton).click();
			System.out.println("Submitted successfully");
			Thread.sleep(8000);
			String str=driver.findElement(Final_msg).getText();
			
			System.out.println(str);
			
			String[] strArr = str.split(" ");
			
			String Case_ID = strArr[8];
			
			System.out.println(""+Case_ID);  
			
			FileWriter fw=new FileWriter(FwConstants.Techpubs_CaseID);    
	        fw.write(Case_ID);    
	        fw.close();
			return Case_ID;   
			
			
			
		}
		public void case_search_isg(String Case_ID) throws InterruptedException {
		 	driver.findElement(CCMS_Casesearch).click();
		 	JE();
		  	System.out.println("Clicked on Case Search");
		  
		  	driver.switchTo().frame("PegaGadget0Ifr");
		  	JE();
		  	System.out.println("Switched to frame PegaGadget0Ifr ");
		  
		  	driver.findElement(search_coloumn).sendKeys(Case_ID);
		  	System.out.println("Entered Case Value into search box");
		  	JE();
		  
		  
		  	driver.findElement(Search_click).click();
		  	System.out.println("Clicked on Search img button");
			 
		 	JE();
		 	driver.findElement(case_selection).click();
			System.out.println("Clicked on Case ID Link");
			 
			Thread.sleep(9000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("PegaGadget1Ifr");
			JE();
			
			WebElement Workbasket = driver.findElement(By.xpath("//span[@data-test-id=\"20180206080439027912600\"]"));
			//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(Workbasket));
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

		public Techpubs_US31550(WebDriver driver) {
			this.driver = driver;
		}
	}



	
	


