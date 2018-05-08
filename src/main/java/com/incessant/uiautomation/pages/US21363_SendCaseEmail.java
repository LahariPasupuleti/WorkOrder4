package com.incessant.uiautomation.pages;

	import java.util.Map;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.incessant.uiautomation.FwConstants;
	import com.incessant.uiautomation.TestBaseCommon;
	import com.incessant.uiautomation.ui.actions.LoginToJohnDeere;
	import com.incessant.uiautomation.ui.actions.LogoutFromJohnDeere;
	import com.incessant.uiautomation.ui.actions.ProcessFlowActions;
	import com.incessant.uiautomation.util.XLReader;
	
	public class US21363_SendCaseEmail extends TestBaseCommon{ 
		
			@Test
				public void US21363_SendCaseEmail() {
					System.out.println("Starting the execution ActionsByStatus_US21363");
					WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
					Map<String, String> userjd = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_JD,
							FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_JD_SHEET_NAME); // data for JD Login 
			 
			
				boolean JDisLoginOK = LoginToJohnDeere.logintoJohndeere(userjd.get(FwConstants.HEADER_NAME_USERNAME),
							userjd.get(FwConstants.HEADER_NAME_PASSWORD), driver);
					Assert.assertTrue(JDisLoginOK);
					Map<String, String> userpa = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_PA,
							FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_PA_SHEET_NAME);
					boolean PAisLoginOK=LoginToJohnDeere.loginToPega(userpa.get(FwConstants.HEADER_NAME_USERNAME), userpa.get(FwConstants.HEADER_NAME_PASSWORD),
							driver);// data for PA Login
					Assert.assertTrue(PAisLoginOK);
					ProcessFlowActions.SendcaseEmail(driver);
					
					//LogoutFromJohnDeere.logOut(driver);
			       
			}
		
			 

	}


