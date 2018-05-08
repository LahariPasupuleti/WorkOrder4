package com.incessant.uiautomation.util;

import java.util.List;
import java.util.Set;

public class Excel_Fetch {
	public static void main(String[] args) {

		List<String> cellValues = XLReader.getXLReader().getExcelDataByTestCaseId("Sample", "‪C:\\Users\\nagarajuk\\Desktop\\Book1.xlsx", "Sheet1");
		for (String string : cellValues) {
			System.out.println(string);
		}
	}
}
