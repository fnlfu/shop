package Base;

import org.openqa.selenium.WebElement;

public class WebElementManipulator{


    protected void clickOnElement(WebElement element) {
        System.out.println("Element " + element.getText() + " is clicked");
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        System.out.println("text is set to " + text);
        element.sendKeys(text);
    }
}
