package com.incessant.uiautomation.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConfPropertyReader {

	private static ConfPropertyReader reader;
	private static Map<String, Properties> allPropsMap = new HashMap<String, Properties>();

	/**
	 * 
	 * 
	 * @param path
	 * @return
	 */

	private ConfPropertyReader() {
	}

	/**
	 * 
	 * @return
	 */
	public static ConfPropertyReader getConfPropertyReader() {

		if (null == reader) {
			reader = new ConfPropertyReader();
		}

		return reader;
	}

	private FileInputStream readConfFile(String path) {

		FileInputStream stream = null;
		try {
			stream = new FileInputStream(path);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return stream;

	}

	/**
	 * Gets the value of any property.
	 * 
	 * @param path
	 * @param key
	 * @return
	 */

	public String getProperty(String path, String key) {
		
		if (null != allPropsMap.get(path) && allPropsMap.get(path).size() > 0) {
			return allPropsMap.get(path).getProperty(key);
		}
		
		Properties props = new Properties();
		try {
			props.load(readConfFile(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props.getProperty(key);
	}

	/**
	 * This method can be used to persist a property. The properties file
	 * specified always holds only one key-value pair.
	 * 
	 * @param path
	 * @param key
	 * @param newValue
	 * @throws IOException
	 */
	public boolean setProperty(String path, String key, String newValue) throws IOException {
		boolean valueSet = true;
		FileOutputStream fileOut = null;
		try {
			Properties props = new Properties();
			props.load(readConfFile(path));
			props.setProperty(key, newValue);
			fileOut = new FileOutputStream(new File(path));
			props.store(fileOut, "Adding the new value");
		} catch (Exception ex) {
			ex.printStackTrace();
			valueSet = false;
		} finally {
			try {
				fileOut.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return valueSet;
	}

	/**
	 * 
	 * 
	 * @param path
	 * @return
	 */
	public Properties getProperties(String path) {

		if (null!= allPropsMap.get(path) && allPropsMap.get(path).size() > 0) {
			return allPropsMap.get(path);
		}

		Properties props = new Properties();
		FileInputStream inStream = null;
		try {
			inStream = readConfFile(path);
			props.load(inStream);
			allPropsMap.put(path, props);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}
		}
		return props;
	}
	
	/**
	 * Used to append the properties
	 * 
	 * @param fileWithPath
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean appendProperties(String fileWithPath, List<String> caseids) {
		boolean appendSuccessful = true;
		try {
			//Deleting the previously persisted caseids.
	        PrintWriter pwOb = new PrintWriter(new FileWriter(fileWithPath, false), false);
	        pwOb.flush();
	        pwOb.close();
	        
	        //Appending the new caseids
			FileWriter fileWritter = new FileWriter(fileWithPath, true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			for(String caseKeyAndValue : caseids) {
				bufferWritter.append(caseKeyAndValue);
				bufferWritter.newLine();
			}
			bufferWritter.newLine();
			bufferWritter.close();
		} catch(IOException io) {
			appendSuccessful = false;
			io.printStackTrace();
		} catch(Exception ee) {
			appendSuccessful = false;
			ee.printStackTrace();
		}
		return appendSuccessful;
	}
	
	/**
	 * Use this method to retrieve the AQR caseids.
	 * 
	 * @param filePath
	 * @return
	 */
	public List<String> retrieveCaseIds(String filePath) {
		List<String> caseIds = new ArrayList<String>();
		FileReader fileReader = null;
		BufferedReader bufReader = null;
		try {
			fileReader = new FileReader(new File(filePath));
			bufReader = new BufferedReader(fileReader);
			String data = null;
			while ((data = bufReader.readLine()) != null) {
				if (!data.trim().equals(""))
					caseIds.add(data.split("=")[1]);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				bufReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return caseIds;
	}

}
