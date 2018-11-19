package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;


public class BasePage extends WebElementManipulator{

    protected WebDriver driver;
    private Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    protected void waitToByClicable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void hoverOnElement(WebElement element) {
        //Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    protected void waitToByVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElements(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    protected WebElement getRandomElement(List<WebElement> webElementList){
        return webElementList.get(new Random().nextInt(webElementList.size()));
    }
}
