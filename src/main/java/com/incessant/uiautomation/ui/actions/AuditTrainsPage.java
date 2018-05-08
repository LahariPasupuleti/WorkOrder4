
	
	package com.incessant.uiautomation.ui.actions;

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

	public class AuditTrainsPage{
		
		List<String> inputData = null;
			WebDriver driver = null;
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
//			By ISG_Action=By.xpath(locators.getProperty("ISG_Action"));
			By ISGAction_DP=By.xpath(locators.getProperty("ISGAction_DP"));
			By ISGAction_frame=By.xpath(locators.getProperty("ISGAction_frame"));
			By ISGAction_framelist=By.xpath(locators.getProperty("ISGAction_framelist"));
			By ISGNewText=By.xpath(locators.getProperty("ISGNewText"));
			By ISGwork_Case=By.xpath(locators.getProperty("ISGwork_Case"));
			By ISG_Actions_Reopened=By.xpath(locators.getProperty("ISG_Actions_Reopened"));
			By ISGSend_Mail=By.xpath(locators.getProperty("ISGSend_Mail"));
			By ISGSend_Case_mail=By.xpath(locators.getProperty("ISGSend_Case_mail"));
			By ISG_Send_Button=By.xpath(locators.getProperty("ISG_Send_Button"));
							
							
								public void ISG_Actions_NewDraft() throws InterruptedException{
									
									String New_Draft=driver.findElement(ISG_NewDraft).getText();
									System.out.println("" + New_Draft);
									
									 driver.findElement(ISGAction_DP).click();
									 Thread.sleep(3000);
									 WebElement NewDraft_Action = driver.findElement(ISGAction_frame);
									 
								    //if(driver.findElement(By.id("pyNavigation1513821425469")).isDisplayed()) 
									 if(NewDraft_Action.isDisplayed()){
								    	List<WebElement> Actions_Elements = driver.findElements(ISGAction_framelist);
								    	
								    	for(WebElement option : Actions_Elements){
								    	    System.out.println(option.getText());
								    	    
								    	}
								    	
								    	driver.findElement(ISGAction_DP).click();
								    	
								Thread.sleep(3000);
									
									 }
									
									;
								}
								public void ISG_Actions_New() throws InterruptedException{
									
									
									
									String New=driver.findElement(ISG_New1).getText();
									
									System.out.println("" + New);
									
									driver.findElement(ISGAction_DP).click();
									 //driver.findElement(By.xpath("//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")).click();
									 Thread.sleep(3000);
									 WebElement New_Action = driver.findElement(ISGAction_frame);
									 
								    //if(driver.findElement(By.id("pyNavigation1513821425469")).isDisplayed()) 
									 if(New_Action.isDisplayed()){
								    	List<WebElement> Actions_Elements = driver.findElements(ISGAction_framelist);
								    	
								    	for(WebElement option : Actions_Elements){
								    	    System.out.println(option.getText());
								    	    
								    	}
								    	driver.findElement(ISGAction_DP).click();
								    	
								Thread.sleep(3000);
								
								driver.findElement(ISGAction_DP).click();
								Thread.sleep(2000);
								driver.findElement(ISGwork_Case).click();
								Thread.sleep(2000);
								
									
									 }
								}
								


								
								public void ISG_Actions_Owned() throws InterruptedException{
									
									String Owned=driver.findElement(ISG_Owned).getText();
									
									System.out.println("" + Owned);
									
									 driver.findElement(ISGAction_DP).click();
									 Thread.sleep(3000);
									 WebElement Owned_Action = driver.findElement(ISGAction_frame);
									 
								    //if(driver.findElement(By.id("pyNavigation1513821425469")).isDisplayed()) 
									 if(Owned_Action.isDisplayed()){
								    	List<WebElement> Actions_Elements = driver.findElements(ISGAction_framelist);
								    	
								    	for(WebElement option : Actions_Elements){
								    	    System.out.println(option.getText());
								    	    
								    	}
								    	
								    	
										Thread.sleep(3000);
										//driver.findElement(By.xpath("(//*[@data-test-id='2015082803183403581177'])[3]")).click();
										driver.findElement(ISGNewText).click();
										//driver.findElement(By.xpath("//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")).click();
										Thread.sleep(3000);
								
									
									 }
								}
								public void ISG_Actions_Resolved() throws InterruptedException{
									
									Thread.sleep(3000);
									String Resolved=driver.findElement(ISG_Resolve_completed).getText();
									
									System.out.println("" + Resolved);
									
									 driver.findElement(ISGAction_DP).click();
									 Thread.sleep(3000);
									 WebElement Resolved_Action = driver.findElement(ISGAction_frame);
									 
								    //if(driver.findElement(By.id("pyNavigation1513821425469")).isDisplayed()) 
									 if(Resolved_Action.isDisplayed()){
								    	List<WebElement> Actions_Elements = driver.findElements(ISGAction_framelist);
								    	
								    	for(WebElement option : Actions_Elements){
								    	    System.out.println(option.getText());
								    	    
								    	}
								    	
								    	Thread.sleep(3000);
								    	driver.findElement(ISGNewText).click();
								    	Thread.sleep(2000); 
								    	
								
									
									 }
								}
								public void ISG_Actions_Reopened() throws InterruptedException {			
									Thread.sleep(3000);
									 driver.findElement(ISGAction_DP).click();
									
									 
									 driver.findElement(ISG_Actions_Reopened).click();
									 Thread.sleep(3000);
									 String Reopened=driver.findElement(ISG_Resolve_completed).getText();
										
										System.out.println("" + Reopened);	
								} 
								
								
								public void AddCustomerInfo() {
									try {
										//new WebDriverWait(driver, 30).until(
												//ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("PegaGadget0Ifr"))));
										
										//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(ISGAddCust_Button));
										//clickOnISGAddCust_Button(driver);
//										new WebDriverWait(driver, 15).until(
//												ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//*[@class='content-item content-field item-1'])[3]"))));
										inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
												FwConstants.ISG_Test_Data);
										Thread.sleep(5000);
										//FWWait wait = new FWWait();
										//driver.findElement(By.xpath("//*[@class='content-item content-field item-1'])[3]"));
										driver.findElement(Country_Code).sendKeys("US");
										driver.findElement(CountryCode_Select).click();				
										driver.findElement(FirstName).sendKeys(inputData.get(0));
										driver.findElement(LastName).sendKeys(inputData.get(1));
										DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
										Thread.sleep(1000);
										clickOnSearch(driver);
										Thread.sleep(3000);
										driver.findElement(ISGCustInfoRadioButton).click();
												
										driver.findElement(ISGCustSubmitButton).click();
										Thread.sleep(3000);
										driver.findElement(ISGCustInfoRadioButton).click();
//										
										driver.findElement(ISGCustSubmitButton).click();
//										wait.findWebElementByXPath(driver, locators.getProperty("GSCAddCustInfoCustName"));
//										driver.findElement(GSCAddCustInfoCustName).click();
										

									} catch (Exception e) {
										e.printStackTrace();
									}
								}

//								public void clickOnISGAddCust_Button(WebDriver driver) {
						//
//									driver.findElement(ISGAddCust_Button).click();
						//
//								}

								public void AddProductInfo() throws InterruptedException {
									clickOnISGProductInfoButton(driver);
									Thread.sleep(3000);
//									FWWait wait = new FWWait();
//									wait.findWebElementById(driver, locators.getProperty("ISGModeldialog"));
									inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
											FwConstants.Sheet_ISG_ProductInfo_Model);
									driver.findElement(ISGModelDialog).sendKeys(inputData.get(0));
									driver.findElement(By.xpath("(//span[text()='Edger'])[2]")).click();
									//wait.findWebElementByXPath(driver, locators.getProperty("ISGModelDialog_Select"));
												
									Thread.sleep(3000);
									clickOnSubmit(driver);

								}

								public void enterFunAreaCode(WebDriver driver) throws InterruptedException {
									inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0002", FwConstants.ALL_DATA,
											FwConstants.Sheet_ISG_ProductInfo_Model);
									Thread.sleep(2000);
									//System.out.println(inputData.get(0));
									driver.findElement(ISGFunctionalArea).sendKeys(inputData.get(0));// waiting till Dropdown appears
									new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(ISGFunctionalArea_Select));
									driver.findElement(ISGFunctionalArea_Select).click();
									Thread.sleep(1000);
//									assertTrue(driver.findElement(Functional_Area_Validate).getText()
//											.equalsIgnoreCase(inputData.get(1)));
								}

								public void enterFunCode(WebDriver driver) throws InterruptedException {
									inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0003", FwConstants.ALL_DATA,
											FwConstants.Sheet_ISG_ProductInfo_Model);
									Thread.sleep(2000);
									driver.findElement(ISGFunctionalCode).sendKeys(inputData.get(0));// waiting till Dropdown appears
									new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(ISGFunctionalCode_Select));
									driver.findElement(ISGFunctionalCode_Select).click();
									Thread.sleep(6000);
//									assertTrue(driver.findElement(Functional_Code_Validate).getText()
//											.equalsIgnoreCase(inputData.get(1)));
								}
								
								
								public void selectPriority(WebDriver driver) {
									new Select(driver.findElement(ISGCase_Priority)).selectByIndex(1);
								}
								
								public void selectLanguage(WebDriver driver) {
									new Select(driver.findElement(ISGCaselanguagecode)).selectByVisibleText("English");
								}
								
								public void selectCaseOrigin(WebDriver driver) {
									new Select(driver.findElement(ISGCase_Origin)).selectByIndex(1);
								}
								
								public void AddSummary(WebDriver driver) {
									inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0005", FwConstants.ALL_DATA,
											FwConstants.Sheet_ISG_ProductInfo_Model);
									driver.findElement(ISGSummary).sendKeys(inputData.get(0));
								}

//								public void selectWorkBasket(WebDriver driver) throws InterruptedException {
//									new Select(driver.findElement(GSCWorkBasket)).selectByIndex(1);
//									Thread.sleep(1000);
//									new Select(driver.findElement(GSCWorkBasket)).selectByIndex(3);
//								}
//								
								public void clickOnISGProductInfoButton(WebDriver driver) {

									driver.findElement(ISGProductinfo_Button).click();

								}
								

								public void clickOnISGRoute() {
									driver.findElement(ISGRoute_Button).click();//////after clicking it will move to status as NEW
								}

							 public void sendCaseEmail() throws InterruptedException
						        {
						        	Thread.sleep(3000);
									driver.findElement(ISGAction_DP).click();
									 //driver.findElement(By.xpath("//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")).click();
									 Thread.sleep(3000);
								     driver.findElement(ISGSend_Case_mail).click();
								     Thread.sleep(2000);
								     driver.findElement(ISGSend_Mail).sendKeys("aparajitap@incessanttechnologies.com");
								     driver.findElement(ISG_Send_Button).click(); 
								     

						} 					
							 public void clickOnSearch(WebDriver driver) {

									driver.findElement(SearchCustomers).click();
								} 
							 public void clickOnSubmit(WebDriver driver) {

									driver.findElement(ISGModelSubmit).click();
								}
							 public AuditTrainsPage(WebDriver driver) {
									this.driver = driver;
								}
								 			 
								  



}
