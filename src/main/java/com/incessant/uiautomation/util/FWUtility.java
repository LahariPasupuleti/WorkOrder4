package com.incessant.uiautomation.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class FWUtility {
		
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isEmpty(String content) {
		if(null == content || "".equals(content) || " ".equals(content) || content.length() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param driver
	 */
	public static void turnOffImplicitWait(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param driver
	 */
	public static void turnOnImplicitWait(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	 * @param pyWorkPageSize
	 * @param limits
	 * @return
	 */
	public static boolean checkPyWorkPageSizeLimits(int pyWorkPageSize, String[] limits) {
		System.out.println("pyWorkPage size from clipboard is -> " + pyWorkPageSize + " KB");
		System.out.println("Expected pyWorkPage size (KB) should be in between  -> " + Integer.parseInt(limits[0].trim()) + "-" + Integer.parseInt(limits[1].trim()));
		return pyWorkPageSize >= Integer.parseInt(limits[0].trim()) && pyWorkPageSize <= Integer.parseInt(limits[1].trim());
	}
	
	/**
	 * 
	 * @param absolutePathOfXML
	 */
	public static List<String> parseMenusXml(String roleName, String absolutePathOfXML) {
		String currentRole = "";
		Map<String, List<String>> menuData = null;
		try {
			File fXmlFile = new File(absolutePathOfXML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
    		XPath xPath =  XPathFactory.newInstance().newXPath();
    		menuData = new HashMap<String, List<String>>();
			NodeList nodeListOfRoles = (NodeList) xPath.compile("/Roles/Role").evaluate(doc, XPathConstants.NODESET);
			for(int roleIndex = 0; roleIndex < nodeListOfRoles.getLength(); roleIndex++) { //Iterating over roles
				currentRole =  nodeListOfRoles.item(roleIndex).getAttributes().getNamedItem("name").getTextContent();
				Element roleEle = (Element)nodeListOfRoles.item(roleIndex);
				NodeList menuList = roleEle.getElementsByTagName("MenuItem");
				List<String> menuNameSet = new ArrayList<String>();
				for(int i=0; i< menuList.getLength(); i++) { //Iterating over menu names
					Element menuItemEle = (Element)nodeListOfRoles.item(roleIndex);
					NodeList menuItemsList = menuItemEle.getElementsByTagName("name");
					menuNameSet.add(menuItemsList.item(i).getTextContent());
				}
				menuData.put(currentRole, menuNameSet);
			}
		} catch(Exception eee) {
			eee.printStackTrace();
		}
		
		return menuData.get(roleName);
	}
	
	/**
	 * 
	 * @param args
	 */
	/*public static void main(String args[]) {
		Set<String> data = FWUtility.parseMenusXml(FwConstants.ROLE_USER, FwConstants.Menus_Xml_File);
		for(String menuName :  data) {
			System.out.println("Name of the menu " + menuName);
		}
	}*/
	
}