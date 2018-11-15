package Pages;

import Base.BasePage;
import Models.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage extends BasePage {

    @FindBy(css = "[class*='wpsc_product_name'] a")
    private List<WebElement> nameList;
    @FindBy(css = "input[name='quantity'][type='text']")
    private List<WebElement> quantity;
    @FindBy(css = "[class='pricedisplay']")
    private WebElement subTotal;
    @FindBy(css = "[class*='step2']")
    private WebElement continueBtn;
    @FindBy(xpath = "//tr[contains(@class,'product_row')]/td[4]/span")
    private List<WebElement> priceList;
    @FindBy(xpath = "//tr[contains(@class,'product_row')]/td[5]/span/span")
    private List<WebElement> totalPriceList;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueBtn() {
        waitToByClicable(continueBtn);
        clickOnElement(continueBtn);
    }

    public CartPage checkCart(Order order) {
        for (int i = 0; i < nameList.size(); i++) {
            int index = order.serchListByName(nameList.get(i).getText());
            assertEquals(order.getPrice(index), new BigDecimal(priceList.get(i).getText().substring(1)));
            assertEquals(order.getQuantity(index), Integer.parseInt(quantity.get(i).getAttribute("value")));
            assertEquals(order.getTotal(index), new BigDecimal(totalPriceList.get(i).getText().substring(1).replaceAll(",", "")));
        }
        assertEquals(order.getSubTotal(), new BigDecimal(subTotal.getText().substring(1).replaceAll(",", "")));
        return this;
    }

}
