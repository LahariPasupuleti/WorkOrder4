package com.incessant.uiautomation.ui.actions;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.expectThrows;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.util.ConfPropertyReader;
import com.incessant.uiautomation.util.XLReader;
import com.incessant.uiautomation.util.DriverActions;
import com.incessant.uiautomation.util.FWWait;

public class NewGSCCaseCreationPage {

	WebDriver driver = null;
	Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
	By FirstName = By.cssSelector(locators.getProperty("GSCAddCustFirstName"));
	By LastName = By.cssSelector(locators.getProperty("GSCAddCustLastname"));
	By SearchCustomers = By.xpath(locators.getProperty("GSCAddCustInfoSearchCustomers"));
	By GSCAddCustInfoCustName = By.xpath(locators.getProperty("GSCAddCustInfoCustName"));
	By AddProductInfoButton = By.xpath(locators.getProperty("GSCAddProductInfo"));
	By AddCustomerInfoButton = By.xpath(locators.getProperty("AddCustomerInfo"));// customer info button
	By GSCAddProfuctInfoTitle = By.id(locators.getProperty("GSCAddProfuctInfoTitle"));
	By GSCAddProfuctInfoModel = By.id(locators.getProperty("GSCAddProfuctInfoModel"));
	By GSCAddProductInfoLoadDDVal = By.xpath(locators.getProperty("GSCAddProductInfoLoadDDVal"));
	By GSCAddProductInfoSubmit = By.xpath(locators.getProperty("GSCAddProductInfoSubmit"));
	By GSCFunctional_Area = By.id(locators.getProperty("GSCFunctional_Area"));
	By GSCFunctional_Area_Dropdown = By.xpath(locators.getProperty("GSCFunctional_Area_Dropdown"));
	By Functional_Area_Validate = By.xpath(locators.getProperty("Functional_Area_Validate"));
	By Functional_Code = By.id(locators.getProperty("Functional_Code"));
	By Functional_Code_Dropdown = By.xpath(locators.getProperty("Functional_Code_Dropdown"));
	By Functional_Code_Validate = By.xpath(locators.getProperty("Functional_Code_Validate"));
	By CasePriority=By.id(locators.getProperty("CasePriority"));
	By LangCode=By.id(locators.getProperty("LangCode"));
	By CaseOrigin=By.id(locators.getProperty("CaseOrigin"));
	By GSCSummary=By.xpath(locators.getProperty("GSCSummary"));
	By GSCWorkBasket=By.xpath(locators.getProperty("GSCWorkBasket"));
	By GSCCaseAccept=By.xpath(locators.getProperty("GSCCaseSubmit"));

	List<String> inputData = null;

	/**
	 * 
	 * @param testCaseId
	 */
	public void AddCustomerInfo() {
		try {
			//clickOnAddCustomerInfoButton(driver);
			//System.out.println("Clicked on Home page");
			new WebDriverWait(driver, 15).until(
					ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.id("CSC_Section"))));
			inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
					FwConstants.GSC_Test_data);
			Thread.sleep(7000);
			FWWait wait = new FWWait();
			driver.findElement(FirstName).sendKeys(inputData.get(1));
			driver.findElement(LastName).sendKeys(inputData.get(0));
			DriverActions.scrollIntoView(driver, driver.findElement(SearchCustomers));
			Thread.sleep(1000);
			clickOnSearch(driver);
			wait.findWebElementByXPath(driver, locators.getProperty("GSCAddCustInfoCustName"));
			driver.findElement(GSCAddCustInfoCustName).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddCustomerInfoButton(WebDriver driver) {

		driver.findElement(AddCustomerInfoButton).click();

	}

	public void AddProductInfo() throws InterruptedException {
		clickOnAddProductInfoButton(driver);
		FWWait wait = new FWWait();
		wait.findWebElementById(driver, locators.getProperty("GSCAddProfuctInfoTitle"));
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		driver.findElement(GSCAddProfuctInfoModel).sendKeys(inputData.get(0));
		wait.findWebElementByXPath(driver, locators.getProperty("GSCAddProductInfoLoadDDVal"));
		driver.findElement(GSCAddProductInfoLoadDDVal).click();
		Thread.sleep(1000);
		clickOnSubmit(driver);

	}

	public void enterFunAreaCode(WebDriver driver) throws InterruptedException {
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0002", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		Thread.sleep(2000);
		System.out.println(inputData.get(0));
		driver.findElement(GSCFunctional_Area).sendKeys(inputData.get(0));// waiting till Dropdown appears
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(GSCFunctional_Area_Dropdown));
		driver.findElement(GSCFunctional_Area_Dropdown).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(Functional_Area_Validate).getText()
				.equalsIgnoreCase(inputData.get(1)));
	}

	public void enterFunCode(WebDriver driver) throws InterruptedException {
		inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0003", FwConstants.ALL_DATA,
				FwConstants.Sheet_GSC_ProductInfo_Model);
		Thread.sleep(2000);
		driver.findElement(Functional_Code).sendKeys(inputData.get(0));// waiting till Dropdown appears
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(Functional_Code_Dropdown));
		driver.findElement(Functional_Code_Dropdown).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(Functional_Code_Validate).getText()
				.equalsIgnoreCase(inputData.get(1)));
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

	public void WB_Details() {
		
		new Select(driver.findElement(By.xpath("//*[@data-test-id=\"201802060658510010138182\"]")));
		List<WebElement> WB=new Select(driver.findElement(By.xpath("//*[@data-test-id=\"201802060658510010138182\"]"))).getOptions();
//		System.out.println("/n"+ WB);
		for(int i=0;i<WB.size();i++)
		{
			System.out.println(""+ WB.get(i).getText());
		}
		
		new Select(driver.findElement(By.xpath("//*[@data-test-id=\"201802060658510010139750\"]")));
		List<WebElement> WSB=new Select(driver.findElement(By.xpath("//*[@data-test-id=\"201802060658510010139750\"]"))).getOptions();
//		System.out.println("/n"+ WB);
		for(int i=0;i<WSB.size();i++)
		{
			System.out.println(""+ WSB.get(i).getText());
		}
			
	}
	public void GSC_Addcomment() throws InterruptedException {
		
		driver.findElement(By.xpath("(//*[@data-test-id=\"20170908144733046212866\"])[1]")).click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.xpath("//*[@data-test-id=\"20171025092116079418730\"]"))).selectByVisibleText("English EN (English)");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@class=\"cke_wysiwyg_frame cke_reset\"]")).sendKeys("This the sample");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class=\"content-item content-field item-1 remove-all-spacing\"])[1]")).click();
		
		boolean displayed = driver.findElement(By.xpath("//*[@class=\" content layout-content-stacked  content-stacked auto-width-column commentCommon TSSGreen clearfix\"]")).isDisplayed();
		System.out.println("/n" + displayed);
				
	}
	
	
	
	public void selectWorkBasket(WebDriver driver) throws InterruptedException {
		new Select(driver.findElement(GSCWorkBasket)).selectByIndex(1);
		Thread.sleep(1000);
		new Select(driver.findElement(GSCWorkBasket)).selectByIndex(3);
	}
	
	public void clickOnAddProductInfoButton(WebDriver driver) {

		driver.findElement(AddProductInfoButton).click();

	}
	
	public void clickOnGSCAccept() {
		driver.findElement(GSCCaseAccept).click();
	}

	public void clickOnSubmit(WebDriver driver) {

		driver.findElement(GSCAddProductInfoSubmit).click();
	}

	public void clickOnSearch(WebDriver driver) {

		driver.findElement(SearchCustomers).click();
	}

	public NewGSCCaseCreationPage(WebDriver driver) {
		this.driver = driver;
	}
}
