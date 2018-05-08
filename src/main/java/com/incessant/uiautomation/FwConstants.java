package com.incessant.uiautomation;

public interface FwConstants {

	// Properties specific to local or specific to Eclipse

	String CONFFILEPATH = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\config.properties";
	String LOCATORS = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\locators.properties";
	String ALL_DATA = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\JohnDeere_Application_data.xlsx";
	String Log4j_Properties_File = "D:\\JohnDeereAutomation\\resources\\conf\\log4j.properties";
	String TESTDATA = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\testdata.properties";
	String PAL_Data_File = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\PALReadings.txt";
	String Menus_Xml_File = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\Menus.xml";
	String CASEID_PROPERTIES_FILE = "D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\caseid.properties";
	String Agronomy_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\Agronomy_CaseID.txt";
	String StellarSupport_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\StellarSupport_CaseID.txt";
	String India_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\India_CaseID.txt";
	String R4Agcc_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\R4Agcc_CaseID.txt";
	String Techpubs_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\Techpubs_CaseID.txt";
	String SouthAfrica_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\SouthAfricaCaseid.txt";
	String R4Turf_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\R4TurfCaseid.txt";
	String JDParts_CASEID_File="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\JDPartsCaseId.txt";
	String JDLink_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\JDLink_CaseID.txt";
	String Deere_CaseID="D:\\Latest April 23rd,2018\\JohnDeereAutomation\\resources\\conf\\Deere_CaseID.txt";
	String File_Path="C:\\Users\\laharip\\Pictures\\console report.png";
	
	// Maven specific
	/*
	 * String CONFFILEPATH = "../conf/config.properties"; String LOCATORS =
	 * "../conf/locators.properties"; String ALL_DATA =
	 * "../conf/Application_data.xlsx"; String Log4j_Properties_File =
	 * "../conf/log4j.properties"; String TESTDATA = "../conf/testdata.properties";
	 * String PAL_Data_File = "../conf/PALReadings.txt"; String Menus_Xml_File =
	 * "../conf/Menus.xml"; String CASEID_PROPERTIES_FILE
	 * ="../conf/caseid.properties";
	 */

	String LOGIN_DATA_JD_SHEET_NAME = "Login-data-Johndeere";
	String LOGIN_DATA_PA_SHEET_NAME = "Login-data-Pega";
	String Sheet_Security_Matrix = "Security-matrix";
	String GSC_Test_data = "GSC_Test_data";
	String ISG_Test_Data="ISG_Test_Data";
	String Sheet_Menus = "Menus";
	String Sheet_Report_Names = "Report_Names";
	String Sheet_GSC_ProductInfo_Model= "GSC_Test_Data_ProductInfo";
	String Sheet_ISG_ProductInfo_Model= "ISG_Test_Data_ProductInfo";

	String ROLE_ADMIN = "Administrator";
	String ROLE_MANAGER = "Manager";
	String ROLE_MANAGERONE = "Manager1";
	String ROLE_USER_JD = "User";
	String ROLE_INACTIVE = "InactiveUser";
	String ROLE_ICLEARUSER = "iClearUser";
	String MENU_REPORTS = "Reports";
	String Sheet_CaseSearch_Data="CaseSearch_Data";
	String ROLE_USER_PA = "User";

	String INITIATE_CASE_OPERATION = "Initiate Case";
	String SEARCH_OPERATION = "Search";
	String ATTACH_OPERATION = "Attach";
	String ROUTING_OPERATION = "Routing";
	String APPROVE_OPERATION = "Approve";

	String ROLE_OPERATOR = "Operator";
	String HEADER_NAME_ROLE = "AccessRole";
	String HEADER_NAME_USERNAME = "UserName";
	String HEADER_NAME_PASSWORD = "Password";
	String CHROME_EXE_PATH = "D:\\Latest_code\\JohnDeereAutomation\\resources\\Dirvers\\chromedriver.exe";
	
	String YES = "Y";
	String NO = "N";
	String TEST_URL = "www.incessanttechnologies.com";
	String ATTACHMENT_TYPE_URL = "URL";
	String ATTACHMENT_TYPE_FILE_FROM_DEVICE = "File from device";
	String TRANSFER_CASE_TO_WB = "workbasket";
	String TRANSFER_CASE_TO_Operator = "operator";
	String FILE_FROM_DEVICE = "File from device";
	String DEFAULT_FILE_PATH = "C:\\Users\\dheerajab\\Desktop\\Documents\\Phantomjs";

	String CONNECTOR_RULE_TYPE_STRING = "Connects executed";
	String TOTAL_ELAPSED_TIME = "Total Elapsed time for the reading";
	String PYWORKPAGE_SIZE_STRING = "pyWorkPageSize (KB)";
	String THRESHOLD_COMPLAINCE_SCORE = "ThresholdComplianceScore";
	String OPERATOR_EQUALS = "equals";
	String OPERATOR_LESSTHAN = "less than";
	String OPERATOR_BETWEEN = "between";
	String OPERATOR_GREATERTHAN = "greater than";

	String ASSIGNMENTS_COUNT = "AssignmentsCount";
	String ATTACHMENTS_COUNT = "AttachmentsCount";
	String SLA_COUNT = "SLACount";

	String CASETYPE_PERSONAL_AUTOSUBMISSION = "Create personal auto submission";
	String CASETYPE_PERSONAL_UMBRELLA_SUBMISSION = "Create personal umbrella submission";
	String CASETYPE_PERSONAL_BUNDLE = "Create personal bundle";

}
