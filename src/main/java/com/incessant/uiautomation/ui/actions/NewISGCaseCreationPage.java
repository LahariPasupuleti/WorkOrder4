
package com.incessant.uiautomation.ui.actions;

	import static org.testng.Assert.assertTrue;
	import static org.testng.Assert.expectThrows;

	import java.util.List;
	import java.util.Properties;
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.incessant.uiautomation.FwConstants;
	import com.incessant.uiautomation.util.ConfPropertyReader;
	import com.incessant.uiautomation.util.XLReader;
	import com.incessant.uiautomation.util.DriverActions;
	import com.incessant.uiautomation.util.FWWait;

	public class NewISGCaseCreationPage {

		
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
		By ISGAccept_Button=By.xpath(locators.getProperty("ISGAccept_Button"));
		
		
		
		
		

		List<String> inputData = null;

		/**
		 * 
		 * @param testCaseId
		 */
		public void AddCustomerInfo() {
			try {
				//new WebDriverWait(driver, 30).until(
						//ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("PegaGadget0Ifr"))));
				
				//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(ISGAddCust_Button));
				//clickOnISGAddCust_Button(driver);
//				new WebDriverWait(driver, 15).until(
//						ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath("//*[@class='content-item content-field item-1'])[3]"))));
				inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
						FwConstants.ISG_Test_Data);
				JE();
				//FWWait wait = new FWWait();
				//driver.findElement(By.xpath("//*[@class='content-item content-field item-1'])[3]"));
				driver.findElement(Country_Code).sendKeys("US");
				JE();
				driver.findElement(CountryCode_Select).click();				
				driver.findElement(FirstName).sendKeys(inputData.get(0));
				driver.findElement(LastName).sendKeys(inputData.get(1));
				DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
				clickOnSearch(driver);
				System.out.println("Customer details entered and clicked on search");
				JE();
				driver.findElement(ISGCustInfoRadioButton).click();
				System.out.println("Selected the customer");
				driver.findElement(ISGCustSubmitButton).click();
				System.out.println("Clicked on submit");
//				Thread.sleep(5000);
//				driver.findElement(ISGCustInfoRadioButton).click();
//				driver.findElement(ISGCustSubmitButton).click();
//				wait.findWebElementByXPath(driver, locators.getProperty("GSCAddCustInfoCustName"));
//				driver.findElement(GSCAddCustInfoCustName).click();
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		public void clickOnISGAddCust_Button(WebDriver driver) {
//
//			driver.findElement(ISGAddCust_Button).click();
//
//		}

		public void AddProductInfo() throws InterruptedException {
			clickOnISGProductInfoButton(driver);
			Thread.sleep(3000);
//			FWWait wait = new FWWait();
//			wait.findWebElementById(driver, locators.getProperty("ISGModeldialog"));
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
			System.out.println(inputData.get(0));
			driver.findElement(ISGFunctionalArea).sendKeys(inputData.get(0));// waiting till Dropdown appears
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(ISGFunctionalArea_Select));
			driver.findElement(ISGFunctionalArea_Select).click();
			Thread.sleep(1000);
//			assertTrue(driver.findElement(Functional_Area_Validate).getText()
//					.equalsIgnoreCase(inputData.get(1)));
		}

		public void enterFunCode(WebDriver driver) throws InterruptedException {
			inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0003", FwConstants.ALL_DATA,
					FwConstants.Sheet_ISG_ProductInfo_Model);
			Thread.sleep(2000);
			driver.findElement(ISGFunctionalCode).sendKeys(inputData.get(0));// waiting till Dropdown appears
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(ISGFunctionalCode_Select));
			driver.findElement(ISGFunctionalCode_Select).click();
			Thread.sleep(1000);
//			assertTrue(driver.findElement(Functional_Code_Validate).getText()
//					.equalsIgnoreCase(inputData.get(1)));
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

//		public void selectWorkBasket(WebDriver driver) throws InterruptedException {
//			new Select(driver.findElement(GSCWorkBasket)).selectByIndex(1);
//			Thread.sleep(1000);
//			new Select(driver.findElement(GSCWorkBasket)).selectByIndex(3);
//		}
		
		public void clickOnISGProductInfoButton(WebDriver driver) {

			driver.findElement(ISGProductinfo_Button).click();

		}
		public void JE() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

		}

		
		public void clickOnISGAccept() {
			driver.findElement(ISGAccept_Button).click();
		}

		public void clickOnSubmit(WebDriver driver) {

			driver.findElement(ISGModelSubmit).click();
		}

		public void clickOnSearch(WebDriver driver) {

			driver.findElement(SearchCustomers).click();
		}

		public NewISGCaseCreationPage(WebDriver driver) {
			this.driver = driver;
		}
	}


