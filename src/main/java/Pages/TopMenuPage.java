package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class TopMenuPage extends BasePage {
    @FindBy(css = "[id=menu-item-33]")
    private WebElement prodCat;
    @FindBy(css = "li[class*='menu-item'] [href*='accessories']")
    private WebElement accessories;
    @FindBy(css = "li[class*='menu-item'] [href*='imacs']")
    private WebElement iMacs;
    @FindBy(css = "li[class*='menu-item'] [href*='ipads']")
    private WebElement iPads;
    @FindBy(css = "li[class*='menu-item'] [href*='iphones']")
    private WebElement iPhones;
    @FindBy(css = "li[class*='menu-item'] [href*='ipods']")
    private WebElement iPods;
    @FindBy(css = "li[class*='menu-item'] [href*='macbooks']")
    private WebElement macBooks;
    @FindBy(css = "[id='menu-item-33'] [class*='product_category']")
    private List<WebElement> prodCatList;
    @FindBy(className = "count")
    private WebElement countItems;

    public TopMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void SelectRandomCategory() {
        hoverOnElement(prodCat);
        Random r = new Random();
        int sel = r.nextInt(prodCatList.size());
        waitToByClicable(prodCatList.get(sel));
        clickOnElement(prodCatList.get(sel));
    }

    public void goIntoCart() {
        waitToByClicable(countItems);
        clickOnElement(countItems);
    }

    public WebElement getCountItems() {
        return countItems;
    }
}
