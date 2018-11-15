package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverFactory {


    public WebDriver getDriver() {
        switch (getFromConfig()) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFireFox();
            case IE:
                return getIE();
            case EDGE:
                return getEdge();
        }
        return getChromeDriver();
    }

    private WebDriver getEdge(){
        System.setProperty("webdriver.edge.driver", "src/main/resources/MicrosoftWebDriver.exe");
        return new EdgeDriver();
    }

    private WebDriver getIE(){
        System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
        return new InternetExplorerDriver();
    }

    private WebDriver getFireFox(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        return new FirefoxDriver(options);
    }

    private WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

    private Drivers getFromConfig() {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/config.properties"));
            return Drivers.valueOf(prop.getProperty("browser"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return Drivers.CHROME;
    }
}
