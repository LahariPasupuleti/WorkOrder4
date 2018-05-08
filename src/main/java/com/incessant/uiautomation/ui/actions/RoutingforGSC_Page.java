package com.incessant.uiautomation.ui.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.DriverActions;
import com.incessant.uiautomation.util.FWWait;
import com.incessant.uiautomation.util.XLReader;

public class RoutingforGSC_Page {
	WebDriver driver = null;
	Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
	By ISGCaseCreation=By.xpath(locators.getProperty("ISGCaseCreation"));
	By AddCustomerInfoButton=By.xpath(locators.getProperty("AddCustomerInfo"));
	//customer info
	By Country_Code=By.id(locators.getProperty("ISGCountry_code"));
	By CountryCode_Select=By.xpath(locators.getProperty("ISGCountrycode_Click"));
	By FirstName = By.cssSelector(locators.getProperty("GSCAddCustFirstName"));
	By LastName = By.cssSelector(locators.getProperty("GSCAddCustLastname"));
	By SearchCustomers = By.xpath(locators.getProperty("GSCAddCustInfoSearchCustomers"));
	By GSCAddCustInfoCustName = By.xpath(locators.getProperty("GSCAddCustInfoCustName"));
	By ISGCustInfoRadioButton=By.xpath(locators.getProperty("ISGCustomer_RadioButton"));
	By ISGCustSubmitButton=By.id(locators.getProperty("ISGSubmitButton"));
	//Product info
	By GSCAddProductInfo=By.xpath(locators.getProperty("GSCAddProductInfo"));
	By GSCAddProfuctInfoModel= By.cssSelector(locators.getProperty("GSCAddProfuctInfoModel"));
	By GSCAddProductInfoLoadVal = By.xpath(locators.getProperty("GSCAddProductInfoLoadVal"));
	//By ISGModelDialog_Select= By.xpath(locators.getProperty("ISGModelDialog_Select"));
	By ISGModelSubmit=By.xpath(locators.getProperty("ISGModelSubmit"));
	
	//Case Coding
	By GSCFunctional_Area=By.cssSelector(locators.getProperty("GSCFunctional_Area"));
	By GSCFunctional_Area_Dropdown=By.xpath(locators.getProperty("GSCFunctional_Area_Dropdown"));
	By GSCFunctionalCode=By.cssSelector(locators.getProperty("GSCFunctional_Code"));
	By GSCFunctionalCode_Select=By.xpath(locators.getProperty("Functional_Code_Dropdown"));
	By ISGFunctionalIssue=By.id(locators.getProperty("ISGFunctionalIssue"));
	//Case Info
	By CasePriority=By.cssSelector(locators.getProperty("CasePriority"));
	By LangCode=By.cssSelector(locators.getProperty("LangCode"));
	By CaseOrigin=By.cssSelector(locators.getProperty("CaseOrigin"));
	
	
	//Problem details
	By GSCSummary=By.xpath(locators.getProperty("GSCSummary"));
	By GSCWorkBasket=By.xpath(locators.getProperty("GSCWorkBasket"));
	By GSCWorkbasketSubgroup=By.xpath(locators.getProperty("GSCWorkbasketSubgroup"));
	By GSCRoute_Button=By.xpath(locators.getProperty("GSCRoute_Button"));
	By TransferButton= By.xpath(locators.getProperty("TransferButton"));
	By NewWorkBasket= By.xpath(locators.getProperty("NewWorkBasket"));
	
	
	//Buttons
	By ISGAccept_Button=By.xpath(locators.getProperty("ISGAccept_Button"));
	By ISGRoute_Button=By.xpath(locators.getProperty("ISGRoute_Button"));
	By ISGClose_Button=By.xpath(locators.getProperty("ISGClose_Button"));
	
	By GSC_Action= By.xpath(locators.getProperty("GSC_Action"));
	By GSCworkcase_Button=By.xpath(locators.getProperty("GSCworkcase_Button"));
	By GSC_Accept_Button=By.xpath(locators.getProperty("GSC_Accept_Button"));
	By GSC_Transfer_WBButton = By.xpath(locators.getProperty("GSC_Transfer_WBButton"));
	By ISG_New1= By.xpath(locators.getProperty("ISG_New1"));
	By ISG_Owned= By.xpath(locators.getProperty("ISG_Owned"));
	By ISG_Resolve_completed= By.xpath(locators.getProperty("ISG_Resolve_completed"));
//	By ISGAct_Button=By.xpath(locators.getProperty("ISGAct_Button"));
	//By ISGAction_DP=By.xpath(locators.getProperty("ISGAction_DP"));
	By ISGAction_frame=By.xpath(locators.getProperty("ISGAction_frame"));
	By ISGAction_framelist=By.xpath(locators.getProperty("ISGAction_framelist"));
	By ISGNewText=By.xpath(locators.getProperty("ISGNewText"));
	By ISGwork_Case=By.xpath(locators.getProperty("ISGwork_Case"));
	By ISG_Actions_Reopened=By.xpath(locators.getProperty("ISG_Actions_Reopened"));
	
//	By ISGAction_TWB=By.xpath(locators.getProperty("ISGAction_TWB"));  
//	By ISGWkBasket=By.xpath(locators.getProperty("ISGWkBasket")); 
//	By ISG_TWB_WB=By.xpath(locators.getProperty("ISG_TWB_WB"));    
//	By ISG_TransferButton=By.xpath(locators.getProperty("ISG_TransferButton"));
//	By ISG_Actnew_WC=By.xpath(locators.getProperty("ISG_Actnew_WC"));
	
	List<String> inputData = null;
	

	
	/**
	 * 
	 * @param testCaseId
	 * @throws InterruptedException 
	 */
	
	public void GSC_Actions_NewDraft() throws InterruptedException{
		
//		String New_Draft=driver.findElement(GSC_NewDraft).getText();
//		System.out.println("" + New_Draft);
//		
//		 driver.findElement(ISGAct_Button).click();
//		 JE();
//		 WebElement NewDraft_Action = driver.findElement(ISGAction_frame);
//		 
//	    //if(driver.findElement(By.id("pyNavigation1513821425469")).isDisplayed()) 
//		 if(NewDraft_Action.isDisplayed()){
//	    	List<WebElement> Actions_Elements = driver.findElements(ISGAction_framelist);
//	    	
//	    	for(WebElement option : Actions_Elements){
//	    	    System.out.println(option.getText());
//	    	    
//	    	}
//	    	
//	    	driver.findElement(ISGAct_Button).click();
//	    	
//	JE();
//		
//		 }
//		
//		;
		JE();
		driver.findElement(GSC_Action).click();
		Thread.sleep(2000);
		driver.findElement(GSCworkcase_Button).click();
	}
	
	
	
	public void GSC_Accept() throws InterruptedException{
		
		
		
//		String New=driver.findElement(ISG_New1).getText();
//		
//		System.out.println("" + New);
//		
//		driver.findElement(ISGAct_Button).click();
//		 //driver.findElement(By.xpath("//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")).click();
//		 JE();
//		 WebElement New_Action = driver.findElement(ISGAction_frame);
//		 
//	    //if(driver.findElement(By.id("pyNavigation1513821425469")).isDisplayed()) 
//		 if(New_Action.isDisplayed()){
//	    	List<WebElement> Actions_Elements = driver.findElements(ISGAction_framelist);
//	    	
//	    	for(WebElement option : Actions_Elements){
//	    	    System.out.println(option.getText());
//	    	    
//	    	}
//	    	driver.findElement(ISGAct_Button).click();
//	    	
//	JE();
//	
////	driver.findElement(ISGAction_DP).click();
////	JE();
//	//driver.findElement();
//	driver.findElement(ISG_Actnew_WC).click();
//	
		JE();
	driver.findElement(GSC_Accept_Button).click();
		
		 }
	
	


	
	public void GSC_Actions_Owned() throws InterruptedException{
		
//		String Owned=driver.findElement(ISG_Owned).getText();
//		
//		System.out.println("" + Owned);
//		
//		 driver.findElement(ISGAct_Button).click();
//		 JE();
//		 driver.findElement(ISGAction_TWB).click();
//		 Thread.sleep(3000);
//		 
//		// WebDriver frame=new WebDriverWait(driver, 40).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//input[@id='WBName']")));
//		 //WebElement frame = driver.findElement(By.xpath("//*[@id=\"PegaWebGadget0\"]"));
//		 
//		 
//		 //System.out.println(""+ frame);
//		 WebElement WB = driver.findElement(By.xpath("//input[@data-test-id='201605271221250444446791']"));
//		 WB.click();
//		 WB.sendKeys("AgCC");
//		 Thread.sleep(3000);
//		 driver.findElement(By.xpath("//*[@id='$PD_ListWorkbasketInformationWithGSC$ppxResults$l100']/td[1]/div")).click();
//		 Thread.sleep(2000);
//		 new Select(driver.findElement(By.id("SubWBName"))).selectByVisibleText("7M HR");
//		 driver.findElement(ISG_TransferButton).click();
JE();
driver.findElement(GSC_Transfer_WBButton).click();
Thread.sleep(2000);

driver.findElement(NewWorkBasket).sendKeys("20CPS");
JE();
driver.findElement(By.xpath("//tr[@data-gargs='[\"20CPS\",\"20CPS\"]']")).click();
Thread.sleep(5000);
driver.findElement(TransferButton).click();
		
		 
	
	
	
	}
	public void AddCustomerInfo() {
		try {
			//new WebDriverWait(driver, 30).until(
					//ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("PegaGadget0Ifr"))));
			
			//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(ISGAddCust_Button));
			//clickOnISGAddCust_Button(driver);
//			new WebDriverWait(driver, 15).until(
//					ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//*[@class='content-item content-field item-1'])[3]"))));
			inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
					FwConstants.GSC_Test_data);
			clickOnAddCustomerInfoButton(driver);
			System.out.println("Clicked on Home page");
			new WebDriverWait(driver, 30).until(
					ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("CSC_Section"))));
//			driver.switchTo().frame("PegaGadget0Ifr");
			
			inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
					FwConstants.GSC_Test_data);
			Thread.sleep(7000);
			FWWait wait = new FWWait();
			driver.findElement(FirstName).sendKeys(inputData.get(1));
			driver.findElement(LastName).sendKeys(inputData.get(0));
			Select country = new Select(driver.findElement(By.cssSelector("#country")));
			country.selectByValue("US");
			
			DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
			Thread.sleep(1000);
			clickOnSearch(driver);
			wait.findWebElementByXPath(driver, locators.getProperty("GSCAddCustInfoCustName"));
			driver.findElement(GSCAddCustInfoCustName).click();
			//FWWait wait = new FWWait();
			//driver.findElement(By.xpath("//*[@class='content-item content-field item-1'])[3]"));
//			driver.findElement(Country_Code).sendKeys("US");
//			driver.findElement(CountryCode_Select).click();				
//			driver.findElement(FirstName).sendKeys(inputData.get(0));
//			driver.findElement(LastName).sendKeys(inputData.get(1));
//			DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
//			JE();
//			clickOnSearch(driver);
//			JE();
//			driver.findElement(ISGCustInfoRadioButton).click();
//			JE();
//			driver.findElement(ISGCustSubmitButton).click();
//			JE();
			//driver.findElement(ISGCustInfoRadioButton).click();
//			
			//driver.findElement(ISGCustSubmitButton).click();
//			wait.findWebElementByXPath(driver, locators.getProperty("GSCAddCustInfoCustName"));
//			driver.findElement(GSCAddCustInfoCustName).click();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickOnAddCustomerInfoButton(WebDriver driver) {

		driver.findElement(AddCustomerInfoButton).click();

	}
//	public void clickOnISGAddCust_Button(WebDriver driver) {
//
//		driver.findElement(ISGAddCust_Button).click();
//
//	}

	public void AddProductInfo() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget0Ifr");
		Thread.sleep(2000);
		clickOnGSCProductInfoButton(driver);
		JE();
//		FWWait wait = new FWWait();
//		wait.findWebElementById(driver, locators.getProperty("ISGModeldialog"));
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		driver.findElement(GSCAddProfuctInfoModel).sendKeys(inputData.get(1));
		driver.findElement(GSCAddProductInfoLoadVal).click();
		//wait.findWebElementByXPath(driver, locators.getProperty("ISGModelDialog_Select"));
					
		JE();
		clickOnSubmit(driver);

	}

	public void enterFunAreaCode(WebDriver driver) throws InterruptedException {
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0002", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		JE();
		//System.out.println(inputData.get(0));
		driver.findElement(GSCFunctional_Area).sendKeys(inputData.get(2));// waiting till Dropdown appears
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(GSCFunctional_Area_Dropdown));
		driver.findElement(GSCFunctional_Area_Dropdown).click();
		JE();
//		assertTrue(driver.findElement(Functional_Area_Validate).getText()
//				.equalsIgnoreCase(inputData.get(1)));
	}

	public void enterFunCode(WebDriver driver) throws InterruptedException {
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0003", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		JE();
		driver.findElement(GSCFunctionalCode).sendKeys(inputData.get(0));// waiting till Dropdown appears
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(GSCFunctionalCode_Select));
		driver.findElement(GSCFunctionalCode_Select).click();
		JE();
//		assertTrue(driver.findElement(Functional_Code_Validate).getText()
//				.equalsIgnoreCase(inputData.get(1)));
	}
	
	
	public void selectPriority(WebDriver driver) {
		new Select(driver.findElement(CasePriority)).selectByIndex(1);
	}
	
	public void selectLanguage(WebDriver driver) {
		new Select(driver.findElement(LangCode)).selectByVisibleText("English");
	}
	
	public void selectCaseOrigin(WebDriver driver) {
		new Select(driver.findElement(CaseOrigin)).selectByIndex(1);
	}
	
	public void AddSummary(WebDriver driver) {
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0004", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		driver.findElement(GSCSummary).sendKeys(inputData.get(0));
	}

//	public void selectWorkBasket(WebDriver driver) throws InterruptedException {
//		new Select(driver.findElement(GSCWorkBasket)).selectByIndex(1);
//		JE();
//		new Select(driver.findElement(GSCWorkBasket)).selectByIndex(3);
//	}
//	
	public void clickOnGSCProductInfoButton(WebDriver driver) {
		JE();
		driver.findElement(GSCAddProductInfo).click();

	}
	

	public void clickOnGSCRoute(WebDriver driver) {
		driver.findElement(GSCRoute_Button).click();//////after clicking it will move to status as NEW
	}

	public void clickOnGSC_Action() {
		driver.findElement(GSC_Action).click();
	}
	public void clickOnISGClose() {
		driver.findElement(ISGClose_Button).click();
	}
	public void PressEnter() throws AWTException {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void PressDownArrow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		}
	public void selectWorkBasket(WebDriver driver) throws InterruptedException, AWTException {
		
			
	
			
//		wait.findWebElementByXPath(driver, locators.getProperty("GSCWorkBasket"));
			new Select(driver.findElement(GSCWorkBasket)).selectByVisibleText("3PAreaOffice");
//		driver.findElement(GSCWorkBasket)
//		PressDownArrow();
			Thread.sleep(3000);
		new Select(driver.findElement(GSCWorkBasket)).selectByVisibleText("3PAreaOffice");
//		driver.findElement(GSCWorkBasket).sendKeys("3PAreaOffice");
		//PressEnter();
//		JE();
		
		Thread.sleep(3000);
////		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(GSCWorkbasketSubgroup));
		
		new Select(driver.findElement(GSCWorkbasketSubgroup)).selectByIndex(1);
		//new Select(driver.findElement(GSCWorkbasketSubgroup)).selectByIndex(1);
//		JE();
////		new Select(driver.findElement(GSCWorkBasket)).selectByIndex(3);
	
	}
	public void clickOnSubmit(WebDriver driver) {

		driver.findElement(ISGModelSubmit).click();
	}

	public void clickOnSearch(WebDriver driver) {

		driver.findElement(SearchCustomers).click();
	}

	public RoutingforGSC_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void JE() {
        JavascriptExecutor js = (JavascriptExecutor)driver;  
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        
 }

}


