package com.incessant.uiautomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import com.incessant.uiautomation.FwConstants;
import com.sun.javafx.css.converters.FontConverter.FontWeightConverter;

public class XLReader {

	private static XLReader xlReader = null;
	private static Logger logger = Logger.getLogger(XLReader.class);

	private XLReader() {
	}

	/**
	 * 
	 * @return
	 */
	public static XLReader getXLReader() {

		if (xlReader == null) {
			xlReader = new XLReader();
		}

		return xlReader;
	}

	/**
	 * 
	 * @param excelFileName
	 * @param sheetName
	 * @return
	 */
	public int getNumberPhysicalOfRows(String excelFileNameWithPath, String sheetName) {
		int rowCount = 0;
		Workbook userDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			userDetailsBook = new XSSFWorkbook(inPutStream);
			rowCount = userDetailsBook.getSheet(sheetName).getPhysicalNumberOfRows();
		} catch (FileNotFoundException e) {
			System.out.println(excelFileNameWithPath + " excel sheet not found and error is " + e.getLocalizedMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inPutStream.close();
				userDetailsBook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return rowCount;
	}

	/**
	 * 
	 * @param detailsSheet
	 * @return
	 */
	private List<String> getHeaders(Sheet detailsSheet) {
		List<String> headerValues = new ArrayList<String>();
		try {
			Row headers = detailsSheet.getRow(0);
			Iterator<Cell> itr = headers.cellIterator();
			while (itr.hasNext()) {
				headerValues.add(itr.next().getStringCellValue());
			}
		} catch (Exception ee) {
			logger.error(ee.getMessage());
		}

		return headerValues;
	}

	/**
	 * 
	 * @param headerValues
	 * @param detailsSheet
	 * @param rowIndex
	 * @param excelFileName
	 * @return
	 */
	private Map<String, String> getDataFromExcel(List<String> headerValues, Sheet detailsSheet, int rowIndex,
			String excelFileName) {
		Map<String, String> data = new HashMap<String, String>();
		try {
			for (int i = 0; i < headerValues.size(); i++) {
				Cell c = detailsSheet.getRow(rowIndex).getCell(i);
				if (null != c) {
					String headerName = headerValues.get(i);
					c.setCellType(Cell.CELL_TYPE_STRING);
					String cellValue = c.getStringCellValue();
					data.put(headerName, cellValue);
				} else {
					// Cell value is NULL in excel sheet.
					Reporter.log(excelFileName + " file has NULL values. Please verify");
					System.out.println(excelFileName + " metadata excel has some null values. Please verify.");
				}
			}

		} catch (Exception eee) {
			logger.error(eee.getMessage());
		}

		return data;
	}


	/**
	 * 
	 * @param rowIndex
	 * @param excelFileNameWithPath
	 * @return
	 */
	public List<Map<String, String>> getUsersMetaData(int rowIndex, String excelFileNameWithPath, String sheetName) {
		Workbook userDetailsBook = null;
		FileInputStream inPutStream = null;
		List<Map<String, String>> excelData = new ArrayList<Map<String, String>>();
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			userDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = userDetailsBook.getSheet(sheetName);
			// Gets headers
			List<String> headerValues = getHeaders(detailsSheet);
			excelData.add(getDataFromExcel(headerValues, detailsSheet, rowIndex, excelFileNameWithPath));
		} catch (FileNotFoundException e) {
			System.out
					.println(excelFileNameWithPath + " excel sheet not found and error is " + e.getLocalizedMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inPutStream.close();
				userDetailsBook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return excelData;

	}

	/**
	 * 
	 * @param rowStartIndex
	 * @param rowEndIndex
	 * @param excelFileName
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getUsersMetaData(int rowStartIndex, int rowEndIndex, String excelFileNameWithPath,
			String sheetName) {

		Workbook userDetailsBook = null;
		FileInputStream inPutStream = null;
		List<Map<String, String>> excelData = new ArrayList<Map<String, String>>();
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			userDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = userDetailsBook.getSheet(sheetName);
			// Gets headers
			List<String> headerValues = getHeaders(detailsSheet);
			for (int rowNumber = rowStartIndex; rowNumber <= rowEndIndex; rowNumber++) {
				Map<String, String> data = getDataFromExcel(headerValues, detailsSheet, rowNumber,
						excelFileNameWithPath);
				excelData.add(data);
			}

		} catch (FileNotFoundException e) {
			System.out
					.println(excelFileNameWithPath + " excel sheet not found and error is " + e.getLocalizedMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inPutStream.close();
				userDetailsBook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return excelData;

	}

	/**
	 * 
	 * @param businessIdentifier
	 * @param loginDetailsExcelFileName
	 * @return
	 */
	public Map<String, String> getUserCredentialsByRole(String accessRole, String excelFileNameWithPath,
			String sheetName) {
		Map<String, String> data = new HashMap<String, String>();
		Workbook carrierDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			carrierDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = carrierDetailsBook.getSheet(sheetName);
			// Gets headers
			List<String> headerValues = getHeaders(detailsSheet);
			int physicalRows = getNumberPhysicalOfRows(excelFileNameWithPath, sheetName);
			for (int rowNumber = 1; rowNumber < physicalRows; rowNumber++) {
				for (int i = 0; i < headerValues.size(); i++) {
					Cell c = detailsSheet.getRow(rowNumber).getCell(i);
					if (null != c) {
						c.setCellType(Cell.CELL_TYPE_STRING);
						String cellValue = c.getStringCellValue();
						if (cellValue.equals(accessRole)) {
							data = getUsersMetaData(rowNumber, excelFileNameWithPath, sheetName).get(0);
							return data;
						}
					} else {
						Reporter.log(excelFileNameWithPath + " file has NULL values. Please verify");
					}
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println(excelFileNameWithPath + " excel file not found.");
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				inPutStream.close();
				carrierDetailsBook.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

		return data;

	}

	public static Set<String> getCellValues(String filepath, String sheetName) {
		Set<String> setOfvalues = new LinkedHashSet<String>();
		Workbook carrierDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(filepath);
			inPutStream = new FileInputStream(file);
			carrierDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = carrierDetailsBook.getSheet(sheetName);
			for (int i = 0; i <= 6; i++) {
				Cell c = detailsSheet.getRow(0).getCell(i);
				String a = c.getStringCellValue();
				// System.out.println(a);
				if (c != null) {
					setOfvalues.add(a);
				}
			}
			Iterator<String> iterator = setOfvalues.iterator();

			while (iterator.hasNext()) {
				String name = iterator.next();
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setOfvalues;
	}

	public boolean getExpectedValueFromSecurityMatrix(int rowIndex, int colIndex) {
		return getExpectedValueFromSecurityMatrix(rowIndex, colIndex, FwConstants.ALL_DATA,
				FwConstants.Sheet_Security_Matrix);
	}

	public boolean getExpectedValueFromSecurityMatrix(int rowIndex, int colIndex, String securityMatrixFileName, String sheetName) {
		String expectedVal = null;
		Workbook userDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(securityMatrixFileName);
			inPutStream = new FileInputStream(file);
			userDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = userDetailsBook.getSheet(sheetName);
			expectedVal = detailsSheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		} catch (FileNotFoundException e) {
			System.out.println("security matrix " + securityMatrixFileName + " not found.");
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				inPutStream.close();
				userDetailsBook.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

		return expectedVal.equals(FwConstants.YES) ? true : false;
	}
	
	/**
	 * 
	 * @param testCaseId
	 * @return
	 */
	public List<String> getExcelDataByTestCaseId(String testCaseId, String excelFileNameWithPath, String sheetName) {
		List<String> data = new ArrayList<String>();
		Workbook carrierDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			carrierDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = carrierDetailsBook.getSheet(sheetName);
			int physicalRows = getNumberPhysicalOfRows(excelFileNameWithPath, sheetName);
			for (int rowNumber = 0; rowNumber < physicalRows; rowNumber++) {
					Row row = detailsSheet.getRow(rowNumber);
					Cell c = row.getCell(0);
					if (null != c) {
						c.setCellType(Cell.CELL_TYPE_STRING);
						String cellValue = c.getStringCellValue();
						if (cellValue.equals(testCaseId)) {
							int physicalCols = row.getPhysicalNumberOfCells();
							for(int colIndex = 1; colIndex < physicalCols ; colIndex++) {
								Cell colCell = row.getCell(colIndex);
								colCell.setCellType(Cell.CELL_TYPE_STRING);
								data.add(colCell.getStringCellValue());
							}
							break;
						}
					} else {
						Reporter.log(excelFileNameWithPath + " file has NULL values. Please verify");
					}

			}
		} catch (FileNotFoundException e) {
			System.out.println(excelFileNameWithPath + " excel file not found.");
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				inPutStream.close();
				carrierDetailsBook.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		return data;

	}
	
	
	/**
	 * 
	 * @param testCaseId
	 * @return
	 */
	public List<String> getExcelDataByRuleType(String ruleType, String excelFileNameWithPath, String sheetName) {
		List<String> data = new ArrayList<String>();
		Workbook carrierDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			carrierDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = carrierDetailsBook.getSheet(sheetName);
			int physicalRows = getNumberPhysicalOfRows(excelFileNameWithPath, sheetName);
			for (int rowNumber = 1; rowNumber < physicalRows; rowNumber++) {
					Row row = detailsSheet.getRow(rowNumber);
					Cell c = row.getCell(0);
					if (null != c) {
						c.setCellType(Cell.CELL_TYPE_STRING);
						String cellValue = c.getStringCellValue();
						if (cellValue.equals(ruleType)) {
							int physicalCols = row.getPhysicalNumberOfCells();
							for(int colIndex = 1; colIndex < physicalCols ; colIndex++) {
								Cell colCell = row.getCell(colIndex);
								colCell.setCellType(Cell.CELL_TYPE_STRING);
								data.add(colCell.getStringCellValue());
								
							}
							break;
						}
					} else {
						Reporter.log(excelFileNameWithPath + " file has NULL values. Please verify");
					}

			}
		} catch (FileNotFoundException e) {
			System.out.println(excelFileNameWithPath + " excel file not found.");
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				inPutStream.close();
				carrierDetailsBook.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return data;
	}
	
	public List<String> getExcelDataByUserType(String userType, String excelFileNameWithPath, String sheetName) {
		List<String> data = new ArrayList<String>();
		Workbook carrierDetailsBook = null;
		FileInputStream inPutStream = null;
		try {
			File file = new File(excelFileNameWithPath);
			inPutStream = new FileInputStream(file);
			carrierDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = carrierDetailsBook.getSheet(sheetName);
			int physicalRows = getNumberPhysicalOfRows(excelFileNameWithPath, sheetName);
			System.out.println("no of physical rows is "+physicalRows);
			int columcount = detailsSheet.getRow(0).getLastCellNum();
			for(int col = 0;col<columcount;col++) {
				Cell c = detailsSheet.getRow(0).getCell(col);
				c.setCellType(Cell.CELL_TYPE_STRING);
				String value = c.getStringCellValue();
				if(value.equalsIgnoreCase("Manager")) {
					for(int row = 1;row<physicalRows-1;row++) {
						Cell celValue = detailsSheet.getRow(row).getCell(col);
						celValue.setCellType(Cell.CELL_TYPE_STRING);
						String d = celValue.getStringCellValue();
						data.add(d);
						
					}break;
				}else {
					Reporter.log(excelFileNameWithPath + " file has NULL values. Please verify");
				}
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return data;
	}
	
	/**
	 * 
	 * @param operationType
	 * @param userType
	 * @return
	 */
	public boolean getExcelDataByOperation(String operationType, String userType) {
		String expectedVal = "";
		Workbook userDetailsBook = null;
		FileInputStream inPutStream = null;
		Map<String, String> data = null;
		List<Map<String, String>> listData = new ArrayList<Map<String,String>>();
		try {
			File file = new File(FwConstants.ALL_DATA);
			inPutStream = new FileInputStream(file);
			userDetailsBook = new XSSFWorkbook(inPutStream);
			Sheet detailsSheet = userDetailsBook.getSheet(FwConstants.Sheet_Security_Matrix);
			List<String> headerValues = getHeaders(detailsSheet);
			int physicalRows = getNumberPhysicalOfRows(FwConstants.ALL_DATA, FwConstants.Sheet_Security_Matrix);
			for (int rowNumber = 1; rowNumber < physicalRows; rowNumber++) {
				data = new HashMap<String, String>();
				for (int i = 0; i < headerValues.size(); i++) {
					Cell c = detailsSheet.getRow(rowNumber).getCell(i);
					if (null != c) {
						c.setCellType(Cell.CELL_TYPE_STRING);
						data.put(headerValues.get(i), c.getStringCellValue());
					} else {
						Reporter.log(FwConstants.ALL_DATA + " file has NULL values. Please verify");
					}
				}
				listData.add(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("security matrix " + FwConstants.ALL_DATA + " not found.");
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				inPutStream.close();
				userDetailsBook.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		for(Map<String, String> map : listData) {
			if(map.get("UserType").equals(userType)) {
				expectedVal = map.get(operationType);
			}
		}
		
		return expectedVal.equals(FwConstants.YES) ? true : false;
		
	}
	
	/*public static void main(String args[]) {
		List<String> ff = XLReader.getXLReader().getExcelDataByUserType("Manager",FwConstants.ALL_DATA, "Sheet1");
		System.out.println("-------> " + ff);
	}*/
}