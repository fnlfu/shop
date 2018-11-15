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
import static org.testng.AssertJUnit.assertTrue;

public class FinalPage extends BasePage {
    @FindBy(css = "tbody tr td")
    private List<WebElement> tdList;
    @FindBy(xpath = "//p[contains(text(),'Total')]")
    private WebElement totals;

    public FinalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FinalPage checkProduct(Order order) {

        waitForElements(tdList);
        for (int i = 0; i < tdList.size(); i += 4) {
            int index = order.serchListByName(tdList.get(i).getText().replaceAll("–", "-"));
            assertEquals(order.getPrice(index), new BigDecimal(tdList.get(i + 1).getText().substring(1)));
            assertEquals(order.getQuantity(index), Integer.parseInt(tdList.get(i + 2).getText()));
            assertEquals(order.getTotal(index), new BigDecimal(tdList.get(i + 3).getText().substring(1).replaceAll(",", "")));
        }
        return this;
    }

    public FinalPage checkPrice(Order order) {
        assertTrue(totals.getText().replaceAll(",", "").contains(order.getTotal().toString()));
        assertTrue(totals.getText().replaceAll(",", "").contains(order.getShiping().toString()));
        return this;
    }
}
