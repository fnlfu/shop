import Models.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    DriverFactory factory;
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        factory = new DriverFactory();
        driver = factory.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");
    }


    @AfterMethod
    public void tearDown() {
        getLastUrl();
        getLogs();
        getSS();
        driver.quit();
    }

    private void getSS(){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\ss\\"+ LocalDate.now()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void getLastUrl(){
        System.out.println(driver.getCurrentUrl());
    }

    private void getLogs(){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
}
