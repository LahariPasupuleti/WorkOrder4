package com.incessant.uiautomation.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import com.incessant.uiautomation.FwConstants;

public class PALFileReader {

	public static float getCount(String typeOfRule) {
		float countOfExecutedRuleBasedOnType = 0;
		String ruleMetaData = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new java.io.FileReader(new File(FwConstants.PAL_Data_File)));
			System.out.println("----------- reader "+reader);
			while( (ruleMetaData = reader.readLine()) != null) {
				if(ruleMetaData.contains(typeOfRule)) {
					String[] splitData = ruleMetaData.split(":");
					System.out.println("-------d "+splitData[0]);
					countOfExecutedRuleBasedOnType = Float.parseFloat(splitData[0]);
				}//Integer.parseInt(splitData[0]);
			}
			
		} catch(Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch(IOException ee){
				ee.printStackTrace();
			}
		}
		
		return countOfExecutedRuleBasedOnType;
	}
	
/*	*//**
	 * 
	 * @param args
	 *//*
	public static void main(String args[]) {
		FileReader reader = new FileReader();
		int count = reader.getCount(FwConstants.CONNECTOR_RULE_TYPE_STRING);
		System.out.println(count);
	}*/
}
