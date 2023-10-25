package com.uiFramework.Testbase.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper1 {

    /**
     * Reads data from the specified Excel file and sheet.
     * @param excelLocation The file path of the Excel file.
     * @param sheetName The name of the Excel sheet.
     * @return A 2D array containing the data from the Excel sheet.
     */
    public Object[][] getExcelData(String excelLocation, String sheetName) {

        try {
            Object dataSets[][] = null;
            FileInputStream file = new FileInputStream(new File(excelLocation));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int totalRow = sheet.getLastRowNum();
            int totalColumn = sheet.getRow(0).getLastCellNum();

            dataSets = new Object[totalRow][totalColumn - 1];

            Iterator<Row> rowIterator = sheet.iterator();
            int i = 0;
            while (rowIterator.hasNext()) {
                i++;
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int j = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getStringCellValue().contains("Start")) {
                        i = 0;
                        break;
                    }
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            dataSets[i - 1][j++] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            dataSets[i - 1][j++] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            dataSets[i - 1][j++] = cell.getBooleanCellValue();
                            break;
                        case FORMULA:
                            dataSets[i - 1][j++] = cell.getCellFormula();
                            break;
                        default:
                            System.out.println("No matching enum data type found");
                            break;
                    }
                }
            }
            return dataSets;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
