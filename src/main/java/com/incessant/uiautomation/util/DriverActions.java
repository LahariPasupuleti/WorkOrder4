package com.incessant.uiautomation.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverActions {

	public static List<String> getDropdownValues(WebDriver driver, By locator) {
		List<String> dropdownValues = new ArrayList<String>();
		WebElement dropdown = driver.findElement(locator);
		Select select_dropdown = new Select(dropdown);
		List<WebElement> options = select_dropdown.getOptions();
		for (WebElement Values : options) {
			String d_value = Values.getText();
			System.out.println(d_value);
			dropdownValues.add(d_value);
		}
		return dropdownValues;
	}

	public static void scrollIntoView(WebDriver driver, WebElement Element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
	}

}
