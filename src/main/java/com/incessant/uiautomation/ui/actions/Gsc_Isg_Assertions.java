package com.incessant.uiautomation.ui.actions;

import static org.testng.Assert.assertTrue;

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
import com.incessant.uiautomation.util.FWWait;
import com.incessant.uiautomation.util.XLReader;

public class Gsc_Isg_Assertions {

	WebDriver driver = null;
	Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);

	By AddCustomerInfoButton = By.xpath(locators.getProperty("AddCustomerInfo"));
	By ISGCaseCreation = By.xpath(locators.getProperty("ISGCaseCreation"));
	By ISGAddCust_Button = By.xpath(locators.getProperty("ISGAddCust_Button"));
	// customer info
	By Country_Code = By.id(locators.getProperty("ISGCountry_code"));
	By CountryCode_Select = By.xpath(locators.getProperty("ISGCountrycode_Click"));
	By FirstName = By.xpath(locators.getProperty("ISGAddCustFirstName"));
	By LastName = By.xpath(locators.getProperty("ISGAddCustLastname"));
	By SearchCustomers = By.xpath(locators.getProperty("ISGCustomer_SearchButton"));
	By ISGCustInfoRadioButton = By.xpath(locators.getProperty("ISGCustomer_RadioButton"));
	By ISGCustSubmitButton = By.id(locators.getProperty("ISGSubmitButton"));
	// Product info
	By ISGProductinfo_Button = By.xpath(locators.getProperty("ISGProductinfo_Button"));
	By ISGModelDialog = By.xpath(locators.getProperty("ISGModeldialog"));
	// By ISGModelDialog_Select=
	// By.xpath(locators.getProperty("ISGModelDialog_Select"));
	By ISGModelSubmit = By.xpath(locators.getProperty("ISGModelSubmit"));

	// Case Coding
	By ISGFunctionalArea = By.id(locators.getProperty("ISGFunctionalArea"));
	By ISGFunctionalArea_Select = By.xpath(locators.getProperty("ISGFunctionalArea_Select"));
	By ISGFunctionalCode = By.xpath(locators.getProperty("ISGFunctionalCode"));
	By ISGFunctionalCode_Select = By.xpath(locators.getProperty("ISGFunctionalCode_Select"));
	By ISGFunctionalIssue = By.id(locators.getProperty("ISGFunctionalIssue"));
	// Case Info
	By ISGCase_Priority = By.id(locators.getProperty("ISGCase_Priority"));
	By ISGCaselanguagecode = By.id(locators.getProperty("ISGCaselanguagecode"));
	By ISGCase_Origin = By.id(locators.getProperty("ISGCase_Origin"));
	// Problem details
	By ISGSummary = By.xpath(locators.getProperty("ISGSummary"));

	// Buttons
	By ISGAccept_Button = By.xpath(locators.getProperty("ISGAccept_Button"));
	By ISGRoute_Button = By.xpath(locators.getProperty("ISGRoute_Button"));
	By ISGClose_Button = By.xpath(locators.getProperty("ISGClose_Button"));

	By ISG_NewDraft = By.xpath(locators.getProperty("ISG_NewDraft"));
	By ISG_New1 = By.xpath(locators.getProperty("ISG_New1"));
	By ISG_Owned = By.xpath(locators.getProperty("ISG_Owned"));
	By ISG_Resolve_completed = By.xpath(locators.getProperty("ISG_Resolve_completed"));
	// By ISG_Action=By.xpath(locators.getProperty("ISG_Action"));
	By ISGAction_DP = By.xpath(locators.getProperty("ISGAction_DP"));
	By ISGAction_frame = By.xpath(locators.getProperty("ISGAction_frame"));
	By ISGAction_framelist = By.xpath(locators.getProperty("ISGAction_framelist"));
	By ISGNewText = By.xpath(locators.getProperty("ISGNewText"));
	By ISGwork_Case = By.xpath(locators.getProperty("ISGwork_Case"));
	By ISG_Actions_Reopened = By.xpath(locators.getProperty("ISG_Actions_Reopened"));
	By GSCAddCustInfoCustName=By.xpath(locators.getProperty("GSCAddCustInfoCustName"));
	List<String> inputData = null;

	/**
	 * 
	 * @param testCaseId
	 * @throws InterruptedException
	 */

	public void Tiles_check() throws InterruptedException {

		WebElement GSC = driver.findElement(By.xpath(locators.getProperty("CreateGSCCase")));

		if (GSC.isDisplayed()) {
			// assertTrue(driver.findElement(By.xpath(locators.getProperty("CreateGSCCase"))).isDisplayed());
			System.out.println(
					"The" + "\n" + "Create GSC Case(Global Support center)" + "\n" + "tile avilable in Home page");
		} else {
			System.out.println("The" + "\n" + "Create GSC Case(Global Support center)" + "\n"
					+ "tile is not avilable in Home page");
		}
		WebElement ISG = driver.findElement(By.xpath(locators.getProperty("CreateISGCase")));

		if (ISG.isDisplayed()) {

			// assertTrue(driver.findElement(By.xpath(locators.getProperty("CreateISGCase"))).isDisplayed());
			System.out.println("The" + "\n" + "Create ISG Case(Intelligent Sollutions Group)" + "\n"
					+ "tile avilable in Home page");
		} else {
			System.out.println("The" + "\n" + "Create ISG Case(Intelligent Sollutions Group)" + "\n"
					+ "tile is not avilable in Home page");
		}
	}

	public void GSC_CustInfo_check() throws InterruptedException {

		clickOnAddCustomerInfoButton(driver);
		System.out.println("Clicked on ADDCustomer Info Button");
		new WebDriverWait(driver, 15).until(
				ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("CSC_Section"))));
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
				FwConstants.GSC_Test_data);
		JE();
		
		driver.findElement(FirstName).sendKeys(inputData.get(1));
		driver.findElement(LastName).sendKeys(inputData.get(0));
		DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
		clickOnSearch(driver);
		System.out.println("");
		JE();
		driver.findElement(GSCAddCustInfoCustName).click();
		
		
		
	}

	public void ISG_CustInfo_check() throws InterruptedException {

		try {

			clickOnAddCustomerInfoButton(driver);
			System.out.println("Cliced on AddCustomerInfo Button");
			inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
					FwConstants.ISG_Test_Data);

			JE();

			driver.findElement(Country_Code).sendKeys("US");
			JE();
			driver.findElement(CountryCode_Select).click();
			driver.findElement(FirstName).sendKeys(inputData.get(0));
			driver.findElement(LastName).sendKeys(inputData.get(1));
			DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
			clickOnSearch(driver);
			System.out.println("Customer details entered and clicked on search");
			Thread.sleep(3000);
			driver.findElement(ISGCustInfoRadioButton).click();
			System.out.println("Selected the customer");
			driver.findElement(ISGCustSubmitButton).click();
			System.out.println("Clicked on submit");
			JE();
			WebElement Edit = driver.findElement(By.xpath("(//img[@src=\"webwb/pzediticon_13962397645.png!!.png\"])"));
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(Edit));
			Edit.click();
			System.out.println("Clicked on change customer");
			
			driver.findElement(ISGCustSubmitButton).click();
			System.out.println("Clicked on submit button without selecting the customer");
			String error = driver.findElement(By.xpath(
					"//div[@class=\" content layout-content-portal_header_group_primary  content-portal_header_group_primary clearfix\"]"))
					.getText();
			System.out.println("" + error);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddCustomerInfoButton(WebDriver driver) {

		driver.findElement(AddCustomerInfoButton).click();

	}

	public void JE() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

	}

	public Gsc_Isg_Assertions(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSearch(WebDriver driver) {

		driver.findElement(SearchCustomers).click();
	}
}
