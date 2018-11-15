package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CategoryPage extends BasePage {
    private TopMenuPage topMenuPage;
    @FindBy(css = "[id*='page_container'] div[class*='display']")
    private List<WebElement> productList;
    @FindBy(css = "a[class='wpsc_product_title']")
    private List<WebElement> linksToProduct;
    private Random r = new Random();

    public CategoryPage(WebDriver driver) {
        super(driver);
        topMenuPage = new TopMenuPage(driver);
        PageFactory.initElements(driver, this);
    }

    public CategoryPage selectProduct() {
        WebElement element = getRandomElement(linksToProduct);
        waitToByClicable(element);
        clickOnElement(element);
        return this;
    }

    public List<WebElement> getProductList() {
        return productList;
    }
}
