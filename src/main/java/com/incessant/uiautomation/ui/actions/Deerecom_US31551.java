package com.incessant.uiautomation.ui.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;

public class Deerecom_US31551 {
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
//	By ISG_Action=By.xpath(locators.getProperty("ISG_Action"));
	By ISGAction_DP=By.xpath(locators.getProperty("ISGAction_DP"));
	By ISGAction_frame=By.xpath(locators.getProperty("ISGAction_frame"));
	By ISGAction_framelist=By.xpath(locators.getProperty("ISGAction_framelist"));
	By ISGNewText=By.xpath(locators.getProperty("ISGNewText"));
	By ISGwork_Case=By.xpath(locators.getProperty("ISGwork_Case"));
	By ISG_Actions_Reopened=By.xpath(locators.getProperty("ISG_Actions_Reopened"));
	
	By ISG_CaseSearch = By.xpath(locators.getProperty("ISG_CaseSearch"));
	By ISG_Searchbox= By.xpath(locators.getProperty("ISG_Searchbox"));
	By ISG_Searchbutton= By.xpath(locators.getProperty("Searchbutton"));
	By ISG_CaseClick=By.xpath(locators.getProperty("ISG_CAseClick"));
	By GSCWorkBasketName=By.xpath(locators.getProperty("GSCWorkBasketName"));
	
	
	
	//JDLDashboard_paths
			By JDLDEERE_CountryCode=By.xpath(locators.getProperty("JDLDEERE_CountryCode"));
			By JDLDashboard_Custname=By.xpath(locators.getProperty("JDLDashboard_Custname"));
			By JDLDashboard_Custmobnum=By.xpath(locators.getProperty("JDLDashboard_Custmobnum"));
			By JDLDashboard_Custemail=By.xpath(locators.getProperty("JDLDashboard_Custemail"));
			By JDLDashboard_Dispmsg=By.xpath(locators.getProperty("JDLDashboard_Dispmsg"));
			By JDLDashboard_SelectProduct=By.cssSelector(locators.getProperty("JDLDashboard_SelectProduct"));
			By JDLDashboard_MachinePIN=By.cssSelector(locators.getProperty("JDLDashboard_MachinePIN"));
			By JDLDashboard_Description=By.xpath(locators.getProperty("JDLDashboard_Description"));
			By JDLDashboard_Dealername=By.cssSelector(locators.getProperty("JDLDashboard_Dealername"));
			By JDLDashboard_DealerCity=By.cssSelector(locators.getProperty("JDLDashboard_DealerCity"));
			By JDLDashboard_DealerState=By.cssSelector(locators.getProperty("JDLDashboard_DealerState"));
			By JDLDashboard_Attachimg=By.xpath(locators.getProperty("JDLDashboard_Attachimg"));
			By JDLDashboard_SelectButton=By.xpath(locators.getProperty("JDLDashboard_SelectButton"));
			By JDLDashboard_AttachButton=By.xpath(locators.getProperty("JDLDashboard_AttachButton"));
			By JDLDashboard_AttachSubmitButton=By.xpath(locators.getProperty("JDLDashboard_AttachSubmitButton"));
			By JDLDashboard_subinfo=By.xpath(locators.getProperty("JDLDashboard_subinfo"));
			
//			By JDLDashboard_Attachfiletxt=By.xpath(locators.getProperty("JDLDashboard_Attachfiletxt"));
//			By JDLDashboard_Attachfilename=By.xpath(locators.getProperty("JDLDashboard_Attachfilename"));
//			By JDLDashboard_AttachdropdownCategory=By.xpath(locators.getProperty("JDLDashboard_AttachdropdownCategory"));
//			By JDLDashboard_AttachCategory=By.xpath(locators.getProperty("JDLDashboard_AttachCategory"));
//			
//			By JDLDashboard_Validating_file=By.xpath(locators.getProperty("JDLDashboard_Validating_file"));
			static String strArr[];
			
			static String Case_ID;
			
			
	public void webform_US31551(WebDriver driver) throws AWTException, InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@data-test-id='20180309154956071941973']")).getText();
		
		//language selector
//		Assert.assertTrue(driver.findElement(JDLDashboard_LangSelector).isDisplayed(),"language Selector is not displayed");
//		System.out.println("language Selector is displayed");
		
		
		//customer name 
		Assert.assertTrue(driver.findElement(JDLDashboard_Custname).isDisplayed(),"Customer name is not displayed");
		System.out.println("Customer name is displayed");
//		String cust_name=driver.findElement(JDLDashboard_Custname).getText();
//		System.out.println("" +cust_name);
		
		//mobile number
		Assert.assertTrue(driver.findElement(JDLDashboard_Custmobnum).isDisplayed(),"Phone number is not Dispayed");
		System.out.println("Phone number is Dispayed");
//		String mob_num=driver.findElement(JDLDashboard_Custmobnum).getText();
//		System.out.println("" +mob_num);
		
		//email id
		Assert.assertTrue(driver.findElement(JDLDashboard_Custemail).isDisplayed(), "Email is not Dispayed");
		System.out.println("Email is  Dispayed");
//		String email_id=driver.findElement(JDLDashboard_Custemail).getText();
//		System.out.println("" +email_id);
		
		//Display message
		Assert.assertTrue(driver.findElement(JDLDashboard_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
		System.out.println("Primary Msg is  displayed");
//		String Disp_msg=driver.findElement(JDLDashboard_Dispmsg).getText();
//		System.out.println("" +Disp_msg);
		
		//Selecting Product
		
		new Select(driver.findElement(JDLDEERE_CountryCode)).selectByValue("US");
		//Enter machine pin
//		driver.findElement(JDLDashboard_MachinePIN).sendKeys("12345");
		
		//Comments/questions
		driver.findElement(JDLDashboard_Description).sendKeys("This is Sample Text");
		
		
		//Dealer name
		driver.findElement(JDLDashboard_Dealername).sendKeys("ABC1");
		System.out.println("Dealer name entered");
		//Dealer city
		driver.findElement(JDLDashboard_DealerCity).sendKeys("California");
		System.out.println("Dealer City entered");
		//Dealer state
		driver.findElement(JDLDashboard_DealerState).sendKeys("US");
		System.out.println("Dealer State entered");
		JE(driver);
		
		//Adding files 
		driver.findElement(JDLDashboard_Attachimg).click();
		JE(driver);
		//clicking on select button
		WebElement Browse = driver.findElement(JDLDashboard_SelectButton);
		JE(driver);
		//Entering the name 
	     Actions builder = new Actions(driver);
	     builder.moveToElement(Browse).click(Browse).build().perform();
	    			
		StringSelection sel=new StringSelection("C:\\Users\\sandeepr\\Desktop\\JHD.PNG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
//		System.out.println(sel);
		JE(driver);
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		JE(driver);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		JE(driver);
		//Entering the name 
		driver.findElement(JDLDashboard_AttachButton).click();
		JE(driver);
		//getting the text of uploaded file
//		String file_name=driver.findElement(JDLDashboard_Attachfilename).getText();
//		System.out.println(""+file_name);
//		
//		//selecting the drop down category
//		new Select(driver.findElement(JDLDashboard_AttachdropdownCategory)).selectByVisibleText("File");
//		//selecting the attachement category
//		new Select(driver.findElement(JDLDashboard_AttachCategory)).selectByVisibleText("External");
//		//clicking on attach button
//		driver.findElement(JDLDashboard_AttachButton).click();
//		//validating the attched file
//		String Val_attach=driver.findElement(JDLDashboard_Validating_file).getText();
//		System.out.println(""+Val_attach);
		
		
		//clicking on submit button
		driver.findElement(JDLDashboard_AttachSubmitButton).click();
		JE(driver);
		String str=driver.findElement(JDLDashboard_subinfo).getText();
		
		System.out.println(str);
		
		strArr = str.split(" ");
		
		Case_ID = strArr[8];
		
		 FileWriter fw;
		 
		         try {
		 
		             fw = new FileWriter(new File(FwConstants.Deere_CaseID));
		 
		              
		 
		             fw.write(String.format(Case_ID));
		 
		            
		             fw.close();
		 
		         } catch (IOException ex) {
		 
		             ex.printStackTrace();
		 
		         }

		
		System.out.println(Case_ID); 
		
		
	}
	
	
	public static void JE(WebDriver driver) {
	    JavascriptExecutor js = (JavascriptExecutor)driver;  
	    js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
	    
	}
public void case_search_GSC(WebDriver driver) {
	 	driver.findElement(ISG_CaseSearch).click();
	 	JE(driver);
	  	System.out.println("Clicked on Case Search");
	  
	  	driver.switchTo().frame("PegaGadget0Ifr");
	  	JE(driver);
	  	System.out.println("Switched to frame PegaGadget0Ifr ");
	  
	  	driver.findElement(ISG_Searchbox).sendKeys(Case_ID);
	  	System.out.println("Entered Case Value into search box");
	  	JE(driver);
	  
	  
	  	driver.findElement(ISG_Searchbutton).click();
	  	System.out.println("Clicked on Search img button");
		 
	 	JE(driver);
	 	driver.findElement(ISG_CaseClick).click();
		System.out.println("Clicked on Case ID Link");
		driver.switchTo().defaultContent();
		JE(driver);
		driver.switchTo().frame("PegaGadget1Ifr");
	  	JE(driver);
	  	
		String WorkBasket= driver.findElement(GSCWorkBasketName).getText();
		System.out.println("Case Routed to "+WorkBasket+" WorkBasket");
		JE(driver);
	 
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

	public void JDLink_Dashboard_US31545(WebDriver driver) {
		this.driver = driver;
	}

}