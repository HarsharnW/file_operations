package iooperations.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter
{
    public static void main(String[] args) {
        Object[][] bookData = {
                {"Java","Harsharn", 800},
                {"JavaScript","Oshada",100},
                {"EJBs","Test2",400},
        };
        write(bookData,"MyJavaBook.xlsx");
    }

    public static void write(Object[][] data, String filePath){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("MyJavaBook");

        int rowCount = 0;

        for (Object[] object : data) {     // first focus on the rows
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            for (Object field : object) {
                Cell cell = row.createCell(columnCount++);

                if (field instanceof String) {
                    cell.setCellValue((String) field);
                }
                else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
