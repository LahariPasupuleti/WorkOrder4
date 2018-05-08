package com.incessant.uiautomation.pages;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.TestBaseCommon;
import com.incessant.uiautomation.ui.actions.LoginToJohnDeere;
import com.incessant.uiautomation.ui.actions.LogoutFromJohnDeere;
import com.incessant.uiautomation.ui.actions.ProcessFlowActions;
import com.incessant.uiautomation.util.XLReader;

public class US21361_TC01_GSC_validateEmail {

	@Test
	public void US21361_TC01_GSC_validateEmail() throws Exception {
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
		ProcessFlowActions.validateAutoEmail(driver);
		LogoutFromJohnDeere.logOut(driver);
		driver.quit();
	}
	
	
}