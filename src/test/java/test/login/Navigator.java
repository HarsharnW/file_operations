package test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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


        driver.findElement(By.name("userName")).sendKeys("Test1");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.name("submit")).click();
    }
}
