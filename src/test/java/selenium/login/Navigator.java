package selenium.login;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Navigator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/newtours");
        driver.manage().window().maximize();

    }

    @Test
    public void login() {
        driver.findElement(By.name("userName")).sendKeys(read("UserDetails.xlsx",1,0));
        driver.findElement(By.name("password")).sendKeys(read("UserDetails.xlsx",1,1));
        driver.findElement(By.name("submit")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private static String read(String filePath, int rowNumber, int columnNumber) {
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFCell cell;
        String data = "";

        File file = new File(filePath);         //Give the file path
        try {
            FileInputStream fileInputStream = new FileInputStream(file);        //FileInputStream will read the content from file & put it to memory
            workbook = new XSSFWorkbook(fileInputStream);               // assign the data of memory var fileINputStream to workbook
          //  sheet = workbook.getSheet("JavaBooks");
            sheet = workbook.getSheetAt(0);                           // way 2

            cell = sheet.getRow(rowNumber).getCell(columnNumber);
            data = cell.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
