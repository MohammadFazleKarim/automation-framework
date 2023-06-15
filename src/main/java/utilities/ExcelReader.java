package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader  {

    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelReader(String excelPath,String sheetName) {

        try {
            projectPath=System.getProperty("user.dir");
            workbook = new XSSFWorkbook(excelPath);
            sheet= workbook.getSheet(sheetName);
        }
        catch (Exception exp ) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static int getRowCount()  {

        try {

            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of rows : "+rowCount);
            return rowCount;
        } catch (Exception exp ) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();

        }
        return 0;
    }

    //* Function to fetch the row count from excel in which data is present
    public static int getColCount()  {
        try {
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            return colCount;
        } catch (Exception exp ) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();

        }
        return 0;
    }

    public static int findStringInRow(int rowNo, String key)  {
        try {
            for(int i =0; i<getColCount(); i++) {
                if(sheet.getRow(rowNo).getCell(i).toString().equalsIgnoreCase(key)) {
                    return i;
                }
            }
        } catch (Exception exp ) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static String getCellValueAsString(int rowNo, int colNo)  {
        try {
            return sheet.getRow(rowNo).getCell(colNo).toString();
        } catch (Exception exp ) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
            return "";
        }
    }

    //* Function to fetch the String data from the Cell of excel
    public static String getcelldataString(int rowNum, int colNum)  {

        try {

            String CellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println(CellData);
            return CellData;
        } catch (Exception exp ) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return null;
    }

    //* Function to fetch the  Numeric data from the Cell of excel
    public static double getcelldataNumber(int rowNum, int colNum)  {
        try {

            double CellData= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(CellData);
            return CellData;

        } catch (Exception exp ) {
            System.out.println(exp.getMessage());;
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return 0;

    }

}
