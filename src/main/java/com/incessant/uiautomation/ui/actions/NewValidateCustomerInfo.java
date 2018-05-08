
	package com.incessant.uiautomation.ui.actions;

	import static org.testng.Assert.assertTrue;

	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.util.List;
		import java.util.Properties;
	import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.Reporter;

	import com.incessant.uiautomation.FwConstants;
		import com.incessant.uiautomation.util.ConfPropertyReader;
	import com.incessant.uiautomation.util.DriverActions;
	import com.incessant.uiautomation.util.FWWait;
	import com.incessant.uiautomation.util.XLReader;
	public class NewValidateCustomerInfo {
	
	Properties locators = ConfPropertyReader.getConfPropertyReader().getProperties(FwConstants.LOCATORS);
	By Assert_FirstName = By.xpath(locators.getProperty("Assert_FirstName"));
	By Assert_LastName = By.xpath(locators.getProperty("Assert_LastName"));
	By Assert_MobilePhone = By.xpath(locators.getProperty("Assert_MobilePhone"));
	By Assert_Address = By.xpath(locators.getProperty("Assert_Address"));
	By Assert_Email = By.xpath(locators.getProperty("Assert_Email"));
	By Assert_EntityID = By.xpath(locators.getProperty("Assert_EntityID"));// customer info button
	By CaseSearch = By.id(locators.getProperty("CaseSearch"));
	By Searchbox = By.id(locators.getProperty("Searchbox"));
	By Searchbutton = By.xpath(locators.getProperty("Searchbutton"));
	By Caseid = By.xpath(locators.getProperty("Caseid"));
	
	//Sahara South Africa
		By SA_lang_select = By.xpath(locators.getProperty("SA_lang_select"));
		By SA_Custname = By.xpath(locators.getProperty("SA_Custname"));
		By SA_Custmobnum = By.xpath(locators.getProperty("SA_Custmobnum"));
		By SA_Custemail = By.xpath(locators.getProperty("SA_Custemail"));
		By SA_Dispmsg = By.xpath(locators.getProperty("SA_Dispmsg"));
		By SA_comment = By.xpath(locators.getProperty("SA_comment"));
		By SA_textareacomment = By.xpath(locators.getProperty("SA_textareacomment"));
		By SA_Langportuegese = By.xpath(locators.getProperty("SA_Langportuegese"));
		By SA_AttachButton = By.xpath(locators.getProperty("SA_AttachButton"));
		By SA_SelectButton = By.xpath(locators.getProperty("SA_SelectButton"));
		By SA_AttachSubmitButton = By.xpath(locators.getProperty("SA_AttachSubmitButton"));
		By SA_SubmitButton = By.xpath(locators.getProperty("SA_SubmitButton"));
		By SA_attachment_name = By.xpath(locators.getProperty("SA_attachment_name"));
		By SA_textsubmitbutton = By.xpath(locators.getProperty("SA_textsubmitbutton"));
		By SA_textclearbutton = By.xpath(locators.getProperty("SA_textclearbutton"));
		By SA_Langfrance = By.xpath(locators.getProperty("SA_Langfrance"));
		By SA_Final_msg = By.xpath(locators.getProperty("SA_Final_msg"));
		
		//Scope for Functional Action
		//By FunctionalActionBox =By.xpath(locators.getProperty("FunctionalActionBox"));
		//By FunctionalIssueBox=By.xpath(locators.getProperty("FunctionalIssueBox"));
		
		
		//Form R4Turf
		By R4_Custname = By.xpath(locators.getProperty("R4_Custname"));
		By R4_Custmobnum = By.xpath(locators.getProperty("R4_Custmobnum"));
		By R4_Custemail = By.xpath(locators.getProperty("R4_Custemail"));
		By R4_Dispmsg = By.xpath(locators.getProperty("R4_Dispmsg"));
		By R4_comment = By.xpath(locators.getProperty("R4_comment"));
		By R4_textareacomment = By.xpath(locators.getProperty("R4_textareacomment"));
		//By R4_Langportuegese = By.xpath(locators.getProperty("R4_Langportuegese"));
		By R4_AttachButton = By.xpath(locators.getProperty("R4_AttachButton"));
		By R4_SelectButton = By.xpath(locators.getProperty("R4_SelectButton"));
		By R4_AttachSubmitButton = By.xpath(locators.getProperty("R4_AttachSubmitButton"));
		By R4_SubmitButton = By.xpath(locators.getProperty("R4_SubmitButton"));
		By R4_attachment_name = By.xpath(locators.getProperty("R4_attachment_name"));
		By R4_textsubmitbutton = By.xpath(locators.getProperty("R4_textsubmitbutton"));
		By R4_textclearbutton = By.xpath(locators.getProperty("R4_textclearbutton"));
		By R4_Langfrance = By.xpath(locators.getProperty("R4_Langfrance"));
		By R4_Final_msg = By.xpath(locators.getProperty("R4_Final_msg"));
		By R4_Attach_Attach= By.xpath(locators.getProperty("R4_Attach_Attach"));
		By R4_Attach_Close= By.xpath(locators.getProperty("R4_Attach_Close"));
		By R4_DealerName= By.xpath(locators.getProperty("R4_DealerName"));
		By R4_DealerCity=By.xpath(locators.getProperty("R4_DealerCity"));
		By R4_DealerState=By.xpath(locators.getProperty("R4_DealerState"));
		
		//validateAutoForm

		//validateEmailFunctionality
		By email_HomePage=By.xpath(locators.getProperty("email_HomePage"));   
		By email_GSCHomePage=By.xpath(locators.getProperty("email_GSCHomePage"));
		By email_CaseSearch=By.xpath(locators.getProperty("email_CaseSearch"));
		By	email_Case_Search_box=By.xpath(locators.getProperty("email_Case_Search_box"));
		By	email_SearchButton=By.xpath(locators.getProperty("email_SearchButton"));
		By	email_LinkGSCCaseId=By.xpath(locators.getProperty("email_LinkGSCCaseId"));
		By	correspondence=By.xpath(locators.getProperty("correspondence"));
		By	R4TurfSubmission=By.xpath(locators.getProperty("R4TurfSubmission"));
		By	AutoMailEmailTable=By.xpath(locators.getProperty("AutoMailEmailTable"));
		By	LinkTurfCase=By.xpath(locators.getProperty("LinkTurfCase"));
		By	TurfCaseTable=By.xpath(locators.getProperty("TurfCaseTable")); 

		
		
	
	
	List<String> inputData = null;
	String strArr[]=null;
	String Case_ID=null;
	
	static WebDriver driver;
	
	 public void getscreenshot(String path) throws Exception 
     {
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(path));
     }
     
	
	public NewValidateCustomerInfo(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void JE() {
	    JavascriptExecutor js = (JavascriptExecutor)driver;  
	    js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 10000);");
	    
	}//end of JE
	
	public static void clipBoard(String string) {
		StringSelection Stringselect = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Stringselect, null);
	}//end of Clipboard
	
	
	public static void uploadFile(String filelocation) throws Exception {
		//Setting clipboard to file location
		clipBoard(filelocation);
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
	}//end of uploadfile
	
	public void clickOnSearch(WebDriver driver) throws InterruptedException {

	driver.findElement(Searchbutton).click();
	Thread.sleep(6000);
	}
	
	public void InputCaseId(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
	List<String> inputData = XLReader.getXLReader().getExcelDataByTestCaseId("Test-0001", FwConstants.ALL_DATA,
	FwConstants.Sheet_CaseSearch_Data);
	driver.findElement(By.xpath(locators.getProperty("Searchbox"))).sendKeys(inputData.get(0));
	Thread.sleep(4000);
	}
	
	public void ClickCaseId(WebDriver driver) throws InterruptedException {

	driver.findElement(Caseid).click();
	Thread.sleep(6000);
	}
	
	public void SwitchToDef(WebDriver driver) throws InterruptedException {

	driver.switchTo().defaultContent();
	Thread.sleep(6000);
	}
	
	
	public void AssertInfo(WebDriver driver) {

	assertTrue(driver.findElement(By.xpath(locators.getProperty("Assert_FirstName")))
	.isDisplayed());
	    System.out.println("Verified FirstName");
	    assertTrue(driver.findElement(By.xpath(locators.getProperty("Assert_LastName")))
	.isDisplayed());
	    System.out.println("Verified LastName");
	    assertTrue(driver.findElement(By.xpath(locators.getProperty("Assert_MobilePhone")))
	.isDisplayed());
	    System.out.println("Verified MobilePhone");
	    assertTrue(driver.findElement(By.xpath(locators.getProperty("Assert_Address")))
	.isDisplayed());
	    System.out.println("Verified Address");
	    assertTrue(driver.findElement(By.xpath(locators.getProperty("Assert_Email")))
	.isDisplayed());
	    System.out.println("Verified Email");
	    assertTrue(driver.findElement(By.xpath(locators.getProperty("Assert_EntityID")))
	.isDisplayed());
	    System.out.println("Verified EntityID");
	}
	
	public void R4TurfTier(WebDriver driver) throws Exception
	{
		
		
		Thread.sleep(8000);
		//Asserting Customer First Name 	
		Assert.assertTrue(driver.findElement(R4_Custname).isDisplayed(),"First Name  last nameis not displayed");
		System.out.println("First Name  last name is "+driver.findElement(R4_Custname).getText());
		
		
		//Asserting Customer Last Name
		Assert.assertTrue(driver.findElement(R4_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
		System.out.println("Phone number is "+driver.findElement(R4_Custmobnum).getText());
		
		//Asserting Customer Email Name
		Assert.assertTrue(driver.findElement(R4_Dispmsg).isDisplayed(), "Email is not Dispayed");
		System.out.println("Email is "+driver.findElement(R4_Dispmsg).getText());
		
		//Asserting Customer Primary Message
//		Assert.assertTrue(driver.findElement(By.xpath("R4_comment")).isDisplayed(), "Primary Msg is not displayed");
//		System.out.println("Primary Msg is"+driver.findElement(R4_comment).getText());
		
		//Asserting Comments Text box	
//		Assert.assertTrue(driver.findElement(R4_textareacomment).isDisplayed(),"Text area input box is not displayed");
//		System.out.println("Comments/questions input box is displayed");
		
		//Clicked on  comments into text box
//		driver.findElement(R4_textareacomment).click();
//		System.out.println("clicked on comments/question box");
		
		//Clicked on Dealer name to capture error message
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-test-id='2018030916435602054843']"))).click();
//		
//	    
//		//Clicked on Dealer name 
//		System.out.println("clicked on dealer name  ");
//		Thread.sleep(3000);
//		
//		//Got Alert message
//		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='iconError dynamic-icon-error']")).isDisplayed(),"Icon AlertMessage is not displayed");
//		System.out.println("Icon AlertMessage is Mandatory is displayed");
		
		//enter comments
		driver.findElement(R4_comment).sendKeys("sample comment");
		System.out.println("sample comment");
		
		//Enter dealer name
		driver.findElement(R4_DealerName).sendKeys("sample dealer name");
        System.out.println("sample dealer name");
        
        //Enter dealer city
		driver.findElement(R4_DealerCity).sendKeys("sample dealer city ");
		System.out.println("sample dealer city");
		
		//Enter dealer state
		driver.findElement(R4_DealerState).sendKeys("sample dealer state ");
		System.out.println("sample dealer state");
		
		//Clicked Attachement 
		driver.findElement(R4_AttachButton).click();
	    System.out.println("clicked Attachment a file button");
	    
	    JE();
	    
	    Actions actions2=new Actions(driver);
	    actions2.moveToElement(driver.findElement(R4_Attach_Attach));
	    //Assert.assertTrue(driver.findElement(R4_Attach_Attach).isDisplayed(), "Cancel button of upload file window is not visible");
	   // System.out.println("Cancel button is Displayed");
	    
	    Actions actions = new Actions(driver);
	    actions.moveToElement(driver.findElement(By.xpath("//*[@name='$PpyAttachmentPage$ppyNote']")));
	    actions.click();
	    
	   // actions.sendKeys("SOME DATA");
	    actions.build().perform();
	    
	    
	    
	    
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='$PpyAttachmentPage$ppyNote']"))).click();
		System.out.println("select button is clicked to upload a file");
		
		Thread.sleep(3000);

        //Calling a function to upload
		uploadFile(FwConstants.File_Path);
		System.out.println("File got uploaded");
		Thread.sleep(4000);
	
		
		
		
		actions.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Attach')])[2]")));
		actions.click();
		actions.build().perform();
			
		System.out.println("Clicked on Attach Button ");
		
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element1=driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']"));
		
	    //This will scroll the page till the element is found either horrizontal or vertical
	    js.executeScript("arguments[0].scrollIntoView();", Element1);
	
		Assert.assertTrue(driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']")).isDisplayed(), "Submit button is not displayed");
		System.out.println("Submit button is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id='2018032009190808117329']")).isDisplayed(), "Submit button is not displayed");
		System.out.println("Clear button is displayed");
		 WebDriverWait wait1 = new WebDriverWait(driver, 30); 
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-id='2018032009190808117329']"))).click();
		System.out.println("Clicked on clear button");
		
		Thread.sleep(4000);
		
//entering data for creating case again
		driver.findElement(By.xpath("//textarea[@data-test-id='2018031407540502455903']")).sendKeys("sample comment");
		System.out.println("sample comment");
		
		driver.findElement(By.xpath("//input[@data-test-id='2018030916435602054843']")).sendKeys("sample dealer name");
        System.out.println("sample dealer name");
        
		driver.findElement(By.xpath("//input[@data-test-id='20180309164356020549262']")).sendKeys("sample dealer city ");
		System.out.println("sample dealer city");
		
		driver.findElement(By.xpath("//input[@data-test-id='20180309164356020550666']")).sendKeys("sample dealer state ");
		System.out.println("sample dealer state");
		
		
//		driver.findElement(By.xpath("(//div[@id='RULE_KEY']/div/div/div/div/div/div/div/div/div/div/div)[13]")).click();
//	    System.out.println("clicked Attachment a file button");
//	    
//	   JE();
//	    
//	   	    
//	    Actions actions4 = new Actions(driver);
//	    actions4.moveToElement(driver.findElement(By.xpath("//*[@name='$PpyAttachmentPage$ppyNote']")));
//	    actions4.click();
//	    
//	   // actions.sendKeys("SOME DATA");
//	    actions4.build().perform();
//		   
//	    
//	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='$PpyAttachmentPage$ppyNote']"))).click();
//	//	System.out.println("select button is clicked to upload a file");
//		
//		Thread.sleep(3000);
//
//        //Calling a function to upload
//		uploadFile(FwConstants.File_Path);
//		System.out.println("File got uploaded");
//		Thread.sleep(4000);
	
		
		
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        WebElement Element2=driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']"));
//		
//	    //This will scroll the page till the element is found either horrizontal or vertical
//	    js1.executeScript("arguments[0].scrollIntoView();", Element2);
//		
//		
//		actions.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Attach')])[2]")));
//		actions.click();
//		actions.build().perform();
//			
//		System.out.println("Clicked on Attach Button ");
//		
		
		
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']"))).click();
		System.out.println("Submit button clicked");
		
		Thread.sleep(5000);
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-test-id='2015012615503109611417']")));
		
		String str=driver.findElement(By.xpath("//div[@data-test-id='2015012615503109611417']")).getText();
		
		System.out.println(str);
		
		
		strArr=str.split(" ");
		
		Case_ID=strArr[8];
	
		System.out.println(Case_ID);
		
		FileWriter fw=new FileWriter(FwConstants.R4Turf_CaseID);
	    fw.write(Case_ID);    
        fw.close();
		
		
	//	writeToFile();
		
		
		
			
	}
    public void caseSearch_Menu_SA(WebDriver driver) throws InterruptedException, FileNotFoundException
    {
    	
    	 String caseid=null;
    	 driver.findElement(By.xpath("//li[@aria-label='Case Search']")).click();
		 JE();
		  System.out.println("Clicked on Case Search");
		  
		  driver.switchTo().frame("PegaGadget0Ifr");
		  JE();
		 
		  System.out.println("Switched to frame PegaGadget0Ifr ");
		  
		  Scanner myScanner = new Scanner(new File(FwConstants.SouthAfrica_CaseID));
			
			while (myScanner.hasNextLine()) {
				caseid = myScanner.nextLine();
			}
		  
		  
		  
		  
		  driver.findElement(By.xpath("//*[@id='pySearchText']")).sendKeys(caseid);
		  System.out.println("Entered Case Value into search box");
		 JE();
		  
		  
		  driver.findElement(By.xpath("//img[@data-test-id='20151001062712095010804']")).click();
		  System.out.println("Clicked on Search img button");
			 
		 Thread.sleep(3000);
	  	 driver.findElement(By.xpath("//*[@data-test-id='20150212053008079033139']")).click();
		 System.out.println("Clicked on Case ID Link");
		
			 
		 Thread.sleep(4000);
		 
    	
    	
    }//end of SA
    
    
    public void caseSearch_Menu_R4(WebDriver driver) throws InterruptedException, FileNotFoundException
    {
    	
    	String caseid=null;
    	 driver.findElement(By.xpath("//li[@aria-label='Case Search']")).click();
		  JE();
		  System.out.println("Clicked on Case Search");
		  
		  driver.switchTo().frame("PegaGadget0Ifr");
		  JE();
		  System.out.println("Switched to frame PegaGadget0Ifr ");
		  
		  Scanner myScanner = new Scanner(new File(FwConstants.R4Turf_CaseID));
			
			while (myScanner.hasNextLine()) {
			 	caseid = myScanner.nextLine();
			}
		  
		  driver.findElement(By.xpath("//*[@id='pySearchText']")).sendKeys(caseid);
		  System.out.println("Entered Case Value into search box");
		  JE();
		  
		  
		  driver.findElement(By.xpath("//img[@data-test-id='20151001062712095010804']")).click();
		  System.out.println("Clicked on Search img button");
			 
		 JE();
	  	 driver.findElement(By.xpath("//*[@data-test-id='20150212053008079033139']")).click();
		 System.out.println("Clicked on Case ID Link");
		
			 
		 JE();
	  }//end of R4
    
    public void validateEnglishLanguage(WebDriver driver)
	{
		try {
			
			
			System.out.println("Default language is English ");
			Thread.sleep(4000);
			Assert.assertTrue(driver.findElement(SA_lang_select).isDisplayed(),"Language selector is not displayed");
			System.out.println("Language selector is displayed is"+ driver.findElement(SA_lang_select).getText());
		
			Assert.assertTrue(driver.findElement(SA_Custname).isDisplayed(),"First Name  last nameis not displayed");
			System.out.println("First Name  last name is  displayed English");
			
			Assert.assertTrue(driver.findElement(SA_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
			System.out.println("Phone number is  Dispayed English");
			
			Assert.assertTrue(driver.findElement(SA_Custemail).isDisplayed(), "Email is not Dispayed");
			System.out.println("Email is  Dispayed English");
			
			Assert.assertTrue(driver.findElement(SA_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
			System.out.println("Primary Msg is  displayed English");
			
					
		//	Assert.assertTrue(driver.findElement(SA_textareacomment).isDisplayed(),"Text area input box is not displayed");
			System.out.println("Comments/questions input box is  displayed English");
			System.out.println("/************************************/");
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}//end of validateEnglishLanguage
	
	public void validatePortuguesLanguage(WebDriver driver)
	{
		try {
			
     //Checking Portugues Language
			
			 Thread.sleep(3000);
		    new Select(driver.findElement(SA_lang_select)).selectByIndex(1);
		    
		    Thread.sleep(3000);
			
		    String Language=driver.findElement(SA_Langportuegese).getText();
			
			
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(SA_lang_select));
			
			
			
			Assert.assertTrue(driver.findElement(SA_lang_select).isDisplayed(),"Language selector is not displayed");
			System.out.println("Language selector is displayed is "+ Language);
		
			Assert.assertTrue(driver.findElement(SA_Custname).isDisplayed(),"First Name  last nameis not displayed");
			System.out.println("First Name  last name is  displayed");
			
			Assert.assertTrue(driver.findElement(SA_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
			System.out.println("Phone number is  Dispayed");
			
			Assert.assertTrue(driver.findElement(SA_Custemail).isDisplayed(), "Email is not Dispayed");
			System.out.println("Email is  Dispayed");
			
			Assert.assertTrue(driver.findElement(SA_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
			System.out.println("Primary Msg is  displayed");
						
	//		Assert.assertTrue(driver.findElement(SA_textareacomment).isDisplayed(),"Text area input box is not displayed");
			System.out.println("Comments/questions input box is  displayed");
			
			String Attachment_Message_portugese=driver.findElement(SA_attachment_name).getText();
			System.out.println("Attachment message for portugues is :"+Attachment_Message_portugese );
			
			Assert.assertTrue(driver.findElement(SA_textsubmitbutton).isDisplayed(), "Submit button is not displayed");
			System.out.println("Submit button is displayed in portugues "+driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']")).getText() );
				
			Assert.assertTrue(driver.findElement(SA_textclearbutton).isDisplayed(), "clear button is not displayed");
			System.out.println("Clear button is displayed in portugues :"+ driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_2']")).getText());
			System.out.println("/************************************/");
			/**************************************************************/
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
	}//end of validatePortuguesLanguage
	
	public void validateFranceLanguage(WebDriver driver)
	{
		try {
			
//Checking France Language 
			 Thread.sleep(3000);
			new Select(driver.findElement(SA_lang_select)).selectByIndex(2);
			Thread.sleep(3000);		
			 String Language2=driver.findElement(SA_Langfrance).getText();
					
					WebDriverWait wait2 = new WebDriverWait(driver, 30);
					wait2.until(ExpectedConditions.visibilityOfElementLocated(SA_lang_select));
					
					
					
					Assert.assertTrue(driver.findElement(SA_lang_select).isDisplayed(),"Language selector is not displayed");
					System.out.println("Language selector is displayed is "+ Language2);
				
					Assert.assertTrue(driver.findElement(SA_Custname).isDisplayed(),"First Name  last nameis not displayed");
					System.out.println("First Name  last name is  displayed");
					
					Assert.assertTrue(driver.findElement(SA_Custmobnum).isDisplayed(), "Phone number is not Dispayed");
					System.out.println("Phone number is  Dispayed");
					
					Assert.assertTrue(driver.findElement(SA_Custemail).isDisplayed(), "Email is not Dispayed");
					System.out.println("Email is  Dispayed");
					
					Assert.assertTrue(driver.findElement(SA_Dispmsg).isDisplayed(), "Primary Msg is not displayed");
					System.out.println("Primary Msg is  displayed");
								
		//			Assert.assertTrue(driver.findElement(SA_textareacomment).isDisplayed(),"Text area input box is not displayed");
					System.out.println("Comments/questions input box is  displayed");
					
					String Attachment_Message_france=driver.findElement(SA_attachment_name).getText();
					System.out.println("Attachment message for france is :"+Attachment_Message_france );
					
					Assert.assertTrue(driver.findElement(SA_textsubmitbutton).isDisplayed(), "Submit button is not displayed");
					System.out.println("Submit button is displayed in france "+driver.findElement(SA_textsubmitbutton).getText() );
						
					Assert.assertTrue(driver.findElement(SA_textclearbutton).isDisplayed(), "clear button is not displayed");
					System.out.println("Clear button is displayed in france :"+ driver.findElement(SA_textclearbutton).getText());
					System.out.println("/************************************/");
					Thread.sleep(3000);

			/**************************************************************/
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}//end of validateFranceLanguage
    
	
	public void fillSaharaSouthAfricaForm(WebDriver driver)
	{
		try
		{
			//Changing  language to English
			
			new Select(driver.findElement(By.xpath("//select[@name='$PpyWorkPage$pWebformLanguage']"))).selectByIndex(0);
			Thread.sleep(3000);		
			System.out.println("Selected English Language");
							
			
			driver.findElement(By.xpath("//textarea[@data-test-id='2018031407540502455903']")).click();
			System.out.println("clicked on comments/question box");
				
			
			driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']")).click();
			System.out.println("clicked on submit");
			Thread.sleep(4000);

			
			Assert.assertTrue(driver.findElement(By.xpath("//span[@class='iconError dynamic-icon-error']")).isDisplayed(),"Icon AlertMessage is not displayed");
			System.out.println("Icon AlertMessage is Mandatory is displayed");
			
			
			driver.findElement(By.xpath("//textarea[@data-test-id='2018031407540502455903']")).sendKeys("This is a sample comment");
			System.out.println("Comments are given");
			
			
			driver.findElement(By.xpath("//div[@class='content-item content-layout item-1 remove-top-spacing   ']/div/div/div/div")).click();
		    System.out.println("clicked on Attachment button");
		    Thread.sleep(4000);
		    
		    Actions actions2=new Actions(driver);
		    actions2.moveToElement(driver.findElement(By.xpath("//button[@data-test-id='20140919030420037511488']")));
		    Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id='20140919030420037511488']")).isDisplayed(), "Cancel button of upload file window is not visible");
		    System.out.println("Cancel button is Displayed");
		    
		    Actions actions = new Actions(driver);
		    actions.moveToElement(driver.findElement(By.xpath("//*[@name='$PpyAttachmentPage$ppyNote']")));
		    actions.click();
		    
		   // actions.sendKeys("SOME DATA");
		    actions.build().perform();
		    
		    
		    
		    
		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='$PpyAttachmentPage$ppyNote']"))).click();
			System.out.println("select button is clicked to upload a file");
			
			Thread.sleep(3000);

	        //Calling a function to upload
			uploadFile(FwConstants.File_Path);
			System.out.println("File got uploaded");
			Thread.sleep(4000);
		
			
			
			
			actions.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Attach')])[2]")));
			actions.click();
			actions.build().perform();
				
			System.out.println("Clicked on Attach Button ");
			
			Thread.sleep(4000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement Element1=driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']"));
			
		    //This will scroll the page till the element is found either horrizontal or vertical
		    js.executeScript("arguments[0].scrollIntoView();", Element1);
		
			
		    Assert.assertTrue(driver.findElement(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']")).isDisplayed(), "Submit button is not displayed");
			System.out.println("Submit button is displayed");
			
			Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id='2018032009190808117329']")).isDisplayed(), "Submit button is not displayed");
			System.out.println("Clear button is displayed");
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='WebformButtons_pyWorkPage_1']"))).click();
			System.out.println("Submit button clicked");
			
			Thread.sleep(8000);
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-test-id='2015012615503109611417']")));

			//div[@data-test-id="2015012615503109611417"]	
			String str=driver.findElement(By.xpath("//div[@data-test-id='2015012615503109611417']")).getText();
			
			System.out.println(str);
			
			strArr=str.split(" ");
			
			Case_ID=strArr[8];
			
			System.out.println(Case_ID);
			
			FileWriter fw=new FileWriter(FwConstants.SouthAfrica_CaseID);
		    fw.write(Case_ID);    
	        fw.close();
	        System.out.println("Stored Case id in file");
			
		//	writeToFile(Case_ID);
		//	System.out.println("CaseId wrote to file ");
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void GetWorkBasket(WebDriver driver) throws InterruptedException
	{
		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
		 driver.switchTo().frame("PegaGadget1Ifr");
		 System.out.println("switched to Frame 1");
		 Thread.sleep(4000);
		 
		
		 String WorkBasketName=driver.findElement(By.xpath("//span[@data-test-id=\"20180206080439027912600\"]")).getText();
		 Assert.assertTrue(driver.findElement(By.xpath("//span[@data-test-id=\"20180206080439027912600\"]")).isDisplayed(), "Work Basket is not generated");
		 System.out.println("Work Basket Name is :"+ WorkBasketName);
		
		
	}
	
	

public void validateEmailFunctionality(WebDriver driver) throws Exception
	{
	
	
	
		System.out.println("cfgasjkfgasjkjkasdfjkasghuk");
		 driver.findElement(email_HomePage).click();
		  Thread.sleep(3000);
		  System.out.println("entered homepage");
		  Thread.sleep(3000);
		  
		  driver.findElement(email_GSCHomePage).click();
		  System.out.println("entered CSG Home Page");
		  Thread.sleep(3000);
		  
		  driver.findElement(email_CaseSearch).click();
			 Thread.sleep(4000);
			 
			 System.out.println("Clicked on Case Search");
			 
			 driver.switchTo().frame("PegaGadget1Ifr");
			 Thread.sleep(2000);
			 System.out.println("Switched to frame PegaGadget1Ifr ");
			 
			 
			 //call caseId from file
			 driver.findElement(email_Case_Search_box).sendKeys("GSC-3426");
			 System.out.println("Entered GSC Value into search box");
			 Thread.sleep(3000);
			 
			 driver.findElement(email_SearchButton).click();
			 System.out.println("Clicked on Search img button");
			 
			 Thread.sleep(3000);
			 driver.findElement(email_LinkGSCCaseId).click();
			 System.out.println("Clicked on Link GSC Case ID");	
			 
			  Thread.sleep(8000);
			  
			 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
//			 js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
//			 System.out.println("Wait");
			 
			 driver.switchTo().defaultContent();
			 System.out.println("switch to default frame");
			 driver.switchTo().frame("PegaGadget2Ifr");
			 System.out.println("switch to frame ");
//			 
			 Thread.sleep(8000);
			 
//			 WebDriverWait wait = new WebDriverWait(driver, 30);
//			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[contains(text(),'Correspondence')]")));
//				
//			 
			 
		     WebElement Element1=driver.findElement(correspondence);
				
		     
			//This will scroll the page till the element is found either horrizontal or vertical
			js.executeScript("arguments[0].scrollIntoView();", Element1);
			System.out.println("scrolled down to element ");
			
			
			driver.findElement(R4TurfSubmission).click();
			System.out.println("Clicked on link R4 Turf Submission");
			Thread.sleep(4000);
			
			// Get all the details of the current window
			 String parentHandle = driver.getWindowHandle();
			 
			 Set<String> handles = driver.getWindowHandles();
		     System.out.println(handles);

		     for (String handle1 : driver.getWindowHandles()) {

		            System.out.println(handle1);

		            driver.switchTo().window(handle1);

		     }
		     
		     System.out.println("switched to window");
		     Thread.sleep(3000);
		     
		     
		     getscreenshot("D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\Submission.png");
		     
		  // Grab the table 
		     WebElement table = driver.findElement(AutoMailEmailTable); 

		     // Now get all the TR elements from the table 
		     List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		     // And iterate over them, getting the cells 
		     
		     for (WebElement row : allRows) { 
		         List<WebElement> cells = row.findElements(By.tagName("td")); 

		         // Print the contents of each cell
		         for (WebElement cell : cells) { 
		             System.out.println(cell.getText());
		         }
			
		    }
		     
		     
		     Thread.sleep(5000);
		     
		     driver.close();
		     
		  // to switch back to parent window
		     driver.switchTo().window(parentHandle);
		     Thread.sleep(4000);
		     
		     
		     driver.switchTo().defaultContent();
			 System.out.println("switch to default frame");
			 driver.switchTo().frame("PegaGadget2Ifr");
			 System.out.println("switch to frame ");
			 
			 Thread.sleep(8000);
		 
		     WebElement Element2=driver.findElement(correspondence);
				
			//This will scroll the page till the element is found either horrizontal or vertical
			js.executeScript("arguments[0].scrollIntoView();", Element2);
			System.out.println("scrolled down to element ");
			
		     
		     
		     
			 
		     driver.findElement(LinkTurfCase).click();
		     System.out.println("clicked on link Turf Case");
			 Thread.sleep(4000);
				
				// Get all the details of the current window
				 String parentHandle1 = driver.getWindowHandle();
				 
				 Set<String> handles1 = driver.getWindowHandles();
			     System.out.println(handles1);

			     for (String handle1 : driver.getWindowHandles()) {

			            System.out.println(handle1);

			            driver.switchTo().window(handle1);

			     }
			     
			     System.out.println("switched to window");
			     Thread.sleep(6000);
			     
			     getscreenshot("D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\CaseCustomerInfo.png");
			     
			     
			  // Grab the table 
		//	     WebElement table1 = driver.findElement(TurfCaseTable); 

			     // Now get all the TR elements from the table 
//			     List<WebElement> allRows1 = table.findElements(By.tagName("tr")); 

			     // And iterate over them, getting the cells 
			     
//			     for (WebElement row : allRows1) { 
//			         List<WebElement> cells1 = row.findElements(By.tagName("td")); 

			         // Print the contents of each cell
//			         for (WebElement cell : cells1) { 
//			             System.out.println(cell.getText());
//			         }
//				
//			    }
			     
			     
			     Thread.sleep(5000);
			     
			     driver.close();
			     
			  // to switch back to parent window
			     driver.switchTo().window(parentHandle);
		     
		     
           //driver.findElement(By.xpath("(//a[contains(text(),'New R4 Turf Case ' )])[1]")).click();
			//	System.out.println("clicked on link Turf Case");
				 
		     
		     
	   }//end of method



	 
   
	
	}	


	
	
	
	
	




