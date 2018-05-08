package com.incessant.uiautomation.ui.actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.TemporaryFilesystem;

public class DeleteTempFiles {
	
	public  void deleteTemp() {		
		TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
		System.out.println("Deleted Temp Files");
	}

	// Delete all cookies 
	public  void deleteCookies(WebDriver driver) throws IOException {
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
		Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		System.out.println("Deleted Cookies");
	}
	
} 