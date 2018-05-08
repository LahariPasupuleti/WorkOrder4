package com.incessant.uiautomation.pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.incessant.uiautomation.FwConstants;
import com.incessant.uiautomation.TestBaseCommon;
import com.incessant.uiautomation.ui.actions.DeleteTempFiles;
import com.incessant.uiautomation.ui.actions.JDLink_Dashboard_US31545;
import com.incessant.uiautomation.ui.actions.LoginToJohnDeere;
import com.incessant.uiautomation.ui.actions.LogoutFromJohnDeere;
import com.incessant.uiautomation.ui.actions.ProcessFlowActions;
import com.incessant.uiautomation.util.Customer_JohnDeere_URLS;
import com.incessant.uiautomation.util.XLReader;



public class JDLink_US31545  extends TestBaseCommon {
	@Test
	public void Newurlopenforcustomer() throws Exception {
		WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
	  //CustomerjohnDeere WebForms LoginCode
//		Map<String, String> Cusjd = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_JD,
//				FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_JD_SHEET_NAME);
//		
//       boolean CusLoginOk=LoginToJohnDeere.Customer_logintoJohndeere(Cusjd.get(FwConstants.HEADER_NAME_USERNAME),Cusjd.get(FwConstants.HEADER_NAME_PASSWORD), driver);
//	 Thread.sleep(20000);
//		Assert.assertTrue(CusLoginOk);
//		WebDriver driver=null;
//		Customer_JohnDeere_URLS opencustomerurl=new Customer_JohnDeere_URLS(null);
//
//        opencustomerurl.Customer_URLS(driver, "JDLink");
//        ProcessFlowActions.Customerlogin(driver);
		Customer_JohnDeere_URLS opencustomerurl=new Customer_JohnDeere_URLS(driver);

        opencustomerurl.Customer_URLS(driver, "JDLink");
        
//			ProcessFlowActions.JDLink_Webform(driver);
			

		
		
	
//		DeleteTempFiles del=new DeleteTempFiles();
//		del.deleteTemp();
//		del.deleteCookies(driver);
//		
//		//TSSjohnDeere  LoginCode
//		Map<String, String> userjd = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_JD,
//				FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_JD_SHEET_NAME); // data for JD Login
//		boolean JDisLoginOK = LoginToJohnDeere.logintoJohndeere(userjd.get(FwConstants.HEADER_NAME_USERNAME),
//				userjd.get(FwConstants.HEADER_NAME_PASSWORD), driver);
//		Assert.assertTrue(JDisLoginOK);
//		Map<String, String> userpa = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_PA,
//				FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_PA_SHEET_NAME);
//		boolean PAisLoginOK=LoginToJohnDeere.loginToPega(userpa.get(FwConstants.HEADER_NAME_USERNAME), userpa.get(FwConstants.HEADER_NAME_PASSWORD),
//				driver);// data for PA Login
//		Assert.assertTrue(PAisLoginOK);
//		ProcessFlowActions.casesearch_JDLink(driver);
//		
//		LogoutFromJohnDeere.logOut(driver);
		
       
}

}
