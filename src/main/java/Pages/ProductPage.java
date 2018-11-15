package Pages;

import Base.BasePage;
import Models.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class ProductPage extends BasePage {
    @FindBy(css = "[class='prodtitle']")
    private WebElement name;
    @FindBy(css = "[class*='currentprice']")
    private WebElement price;
    @FindBy(name = "Buy")
    private WebElement submit;
    private Random r = new Random();
    private TopMenuPage topMenuPage;

    public ProductPage(WebDriver driver) {
        super(driver);
        topMenuPage = new TopMenuPage(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductPage AddProductToCart(Order order) {
        int q = r.nextInt(3);
        WebDriverWait wait = new WebDriverWait(driver, 45);
        for (int i = 0; i <= q; i++) {
            int count = Integer.parseInt(topMenuPage.getCountItems().getText());
            waitToByClicable(submit);
            clickOnElement(submit);
            wait.until(ExpectedConditions.attributeContains(
                    topMenuPage.getCountItems(),
                    "innerHTML",
                    Integer.toString(count + 1)));
            order.addProduct(name.getText().replaceAll("–", "-"), price.getText());
        }
        return this;
    }

}
