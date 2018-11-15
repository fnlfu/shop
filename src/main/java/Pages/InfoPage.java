package Pages;

import Base.BasePage;
import Models.Order;
import Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;

import static org.testng.AssertJUnit.assertEquals;

public class InfoPage extends BasePage {

    @FindBy(name = "shippingSameBilling")
    private WebElement shippingCheckBox;
    @FindBy(css = "[title='billingemail']")
    private WebElement email;
    @FindBy(css = "[title='billingfirstname']")
    private WebElement firstName;
    @FindBy(css = "[title='billinglastname']")
    private WebElement lastName;
    @FindBy(css = "[title='billingaddress']")
    private WebElement address;
    @FindBy(css = "[title='billingcity']")
    private WebElement city;
    @FindBy(css = "[title='billingstate']")
    private WebElement state;
    @FindBy(css = "select[title='billingcountry'")
    private WebElement selectCounty;
    @FindBy(css = "[title='billingpostcode']")
    private WebElement postalCode;
    @FindBy(css = "[title='billingphone']")
    private WebElement phone;
    @FindBy(css = "[class*='total_shipping'] td span span")
    private WebElement totalShipping;
    @FindBy(css = "[class*='total_item'] td span span")
    private WebElement itemCost;
    @FindBy(css = "span[class*='checkout-total']")
    private WebElement totalPrice;
    @FindBy(css = "[value='Purchase']")
    private WebElement purchase;


    public InfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        sendKeys(this.firstName, firstName);
    }

    public void setEmail(String email) {
        sendKeys(this.email, email);
    }

    public void setLastName(String lastName) {
        sendKeys(this.lastName, lastName);
    }

    public void setAddress(String address) {
        sendKeys(this.address, address);
    }

    public void setCity(String city) {
        sendKeys(this.city, city);
    }

    public void setState(String state) {
        sendKeys(this.state, state);
    }

    public void setPostalCode(String postalCode) {
        sendKeys(this.postalCode, postalCode);
    }

    public void setPhone(String phone) {
        sendKeys(this.phone, phone);
    }

    public void setCountry() {
        Select country = new Select(selectCounty);
        country.selectByIndex(5);
        country.selectByValue("PL");
    }

    public InfoPage setUser(User user) {
        clickOnElement(shippingCheckBox);
        setEmail(user.getEmail());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setAddress(user.getAddress());
        setCity(user.getCity());
        setState(user.getState());
        setCountry();
        setPostalCode(user.getPostalCode());
        setPhone(user.getPhone());
        return this;
    }

    public InfoPage checkPrice(Order order) {
        waitToByVisible(totalShipping);
        order.setShiping(new BigDecimal(totalShipping.getText().substring(1).replaceAll(",", "")));
        System.out.println(itemCost.getText());
        assertEquals(order.getSubTotal(), new BigDecimal(itemCost.getText().substring(1).replaceAll(",", "")));
        assertEquals(order.getTotal(), new BigDecimal(totalPrice.getText().substring(1).replaceAll(",", "")));
        return this;
    }

    public void Purchase() {
        clickOnElement(purchase);
    }
}