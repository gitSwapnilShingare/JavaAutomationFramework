package com.uiFramework.Testbase.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
    private XSSFSheet sh;

    /**
     * Constructor to initialize the ExcelHelper with a given file name and sheet name.
     * @param fileName The name of the Excel file.
     * @param sheetName The name of the Excel sheet.
     */
    public ExcelHelper(String fileName, String sheetName) {
        try {
            File f = new File(System.getProperty("user.dir") + "\\" + fileName);
            FileInputStream fis = new FileInputStream(f);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            sh = wb.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a list of keys from the Excel sheet (assumes keys are in the first column).
     * @return ArrayList of keys.
     */
    public ArrayList<String> getKeysList() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            XSSFRow row = sh.getRow(i);
            XSSFCell cel = row.getCell(0);
            String key = getValueOfCellAccordingToCellType(cel);
            keys.add(key);
        }
        return keys;
    }

    /**
     * Retrieves a list of values from the Excel sheet (assumes values are in the second column).
     * @return ArrayList of values.
     */
    public ArrayList<String> getValuesList() {
        ArrayList<String> values = new ArrayList<>();
        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            XSSFRow row = sh.getRow(i);
            XSSFCell cel = row.getCell(1);
            String val = getValueOfCellAccordingToCellType(cel);
            values.add(val);
        }
        return values;
    }

    /**
     * Retrieves a list of values from a specific column of the Excel sheet.
     * @param columnNumber The column number (0-based) from which to retrieve values.
     * @return ArrayList of values from the specified column.
     */
    public ArrayList<String> getColumnList(int columnNumber) {
        ArrayList<String> values = new ArrayList<>();
        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            XSSFRow row = sh.getRow(i);
            XSSFCell cel = row.getCell(columnNumber);
            String val = getValueOfCellAccordingToCellType(cel);
            values.add(val);
        }
        return values;
    }

    /**
     * Retrieves key-value pairs from the Excel sheet (assumes keys are in the first column and values are in the second column).
     * @return HashMap containing key-value pairs.
     */
    public HashMap<String, String> getKeyValuePair() {
        HashMap<String, String> data = new HashMap<>();
        for (int i = 1; i <= sh.getLastRowNum(); i++) {
            XSSFRow row = sh.getRow(i);
            XSSFCell cel = row.getCell(0);
            String key = getValueOfCellAccordingToCellType(cel);
            cel = row.getCell(1);
            String val = getValueOfCellAccordingToCellType(cel);
            data.put(key, val);
        }
        return data;
    }

    @SuppressWarnings("deprecation")
    private static String getValueOfCellAccordingToCellType(XSSFCell cel) {
        Object dd = null;
        switch (cel.getCellType()) {
            case STRING:
                dd = cel.getStringCellValue();
                break;
            case BOOLEAN:
                dd = cel.getBooleanCellValue();
                break;
            case NUMERIC:
                dd = cel.getNumericCellValue();
                break;
            case FORMULA:
                dd = cel.getCellFormula();
                break;
            case BLANK:
                System.out.println("Cell does not have anything");
                break;
            default:
                System.out.println("We do not have a cell type case written");
                break;
        }
        return dd.toString();
    }
}
