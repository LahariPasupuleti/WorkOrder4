
	package com.incessant.uiautomation.pages;

	import java.io.IOException;
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
	import com.incessant.uiautomation.util.XLReader;

	public class TestNewGSCCase extends TestBaseCommon {
//US21375_GSC

		@Test
		public void createGSCCaseByUser_US21375() throws IOException {
			WebDriver driver = TestBaseCommon.getDriver(TestBaseCommon.getConfiguredBrowserType());
			DeleteTempFiles del=new DeleteTempFiles();
			del.deleteCookies(driver);
			del.deleteTemp();
			Map<String, String> userjd = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_JD,
					FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_JD_SHEET_NAME); // data for JD Login
			boolean JDisLoginOK = LoginToJohnDeere.logintoJohndeere(userjd.get(FwConstants.HEADER_NAME_USERNAME),
					userjd.get(FwConstants.HEADER_NAME_PASSWORD), driver);
			Assert.assertTrue(JDisLoginOK);
			System.out.println("Johndheere login"+JDisLoginOK);
			Map<String, String> userpa = XLReader.getXLReader().getUserCredentialsByRole(FwConstants.ROLE_USER_PA,
					FwConstants.ALL_DATA, FwConstants.LOGIN_DATA_PA_SHEET_NAME);
			boolean PAisLoginOK=LoginToJohnDeere.loginToPega(userpa.get(FwConstants.HEADER_NAME_USERNAME), userpa.get(FwConstants.HEADER_NAME_PASSWORD),
					driver);// data for PA Login
			Assert.assertTrue(PAisLoginOK);
			System.out.println("Pega login"+ PAisLoginOK);
			ProcessFlowActions.createGSCCaseByUser(driver);
			//LogoutFromJohnDeere.logOut(driver);
			//System.out.println("Logged out Succesfully");
		}

	}

