package com.incessant.uiautomation.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.TestBaseCommon;
import com.incessant.uiautomation.ui.actions.DeleteTempFiles;
import com.incessant.uiautomation.ui.actions.LoginToJohnDeere;
import com.incessant.uiautomation.ui.actions.LogoutFromJohnDeere;
import com.incessant.uiautomation.ui.actions.ProcessFlowActions;
import com.incessant.uiautomation.util.Customer_JohnDeere_URLS;
import com.incessant.uiautomation.util.XLReader;

public class US31548_TC01_GSC_R4TurfTier1 {
	
	@Test
	public void US31548_TC01_GSC_R4TurfTier1() throws Exception  {
		
		
		WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
    	Customer_JohnDeere_URLS opencustomerurl=new Customer_JohnDeere_URLS(driver);
		opencustomerurl.Customer_URLS(driver,"R4 Turf");
		
		driver.manage().window().maximize();
		
				
		/************************************************************/
		DeleteTempFiles del=new DeleteTempFiles();
		del.deleteTemp();
		del.deleteCookies(driver);
		
		//TSSjohnDeere  LoginCode
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
		
	
		ProcessFlowActions.validateCustomerWorkBasketR4(driver);
		LogoutFromJohnDeere.logOut(driver);
       
		driver.quit();
		
}
	
	
	

}
