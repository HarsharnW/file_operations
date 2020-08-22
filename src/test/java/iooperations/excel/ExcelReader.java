package iooperations.excel;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) {
        read("TestSheet.xlsx");
    }

    public static void read(String filePath) {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFCell cell;

        File file = new File(filePath);         //Give the file path
        try {
            FileInputStream fileInputStream = new FileInputStream(file);        //FileInputStream will read the content from file & put it to memory
            workbook = new XSSFWorkbook(fileInputStream);               // assign the data of memory var fileINputStream to workbook
            sheet = workbook.getSheet("JavaBooks");
         //   sheet = workbook.getSheetAt(0);                           // way 2

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                cell = sheet.getRow(i).getCell(0);           //give cell
                System.out.println(cell);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
