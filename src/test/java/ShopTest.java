import Models.Order;
import Models.User;
import Models.UserFactory;
import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;
    private Order order;
    private CartPage cartPage;
    private UserFactory userFactory;
    private User user;
    private InfoPage infoPage;
    private FinalPage finalPage;

    @BeforeMethod
    public void setUpTest() {
        topMenuPage = new TopMenuPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        order = new Order();
        userFactory = new UserFactory();
        user = userFactory.setUserData("Adam");
        infoPage = new InfoPage(driver);
        finalPage = new FinalPage(driver);
    }

    @Test
    public void shopTestOne() {

        for (int i = 0; i < 4; i++) {
            topMenuPage.SelectRandomCategory();
            categoryPage.selectProduct();
            productPage.AddProductToCart(order);
        }

        topMenuPage.goIntoCart();
        cartPage.checkCart(order)
                .clickContinueBtn();
        infoPage.checkPrice(order)
                .setUser(user)
                .Purchase();
        finalPage.checkProduct(order)
                .checkPrice(order);
    }
    @Test
    public void shopTestTwo() {

        for (int i = 0; i < 4; i++) {
            topMenuPage.SelectRandomCategory();
            categoryPage.selectProduct();
            productPage.AddProductToCart(order);
        }

        topMenuPage.goIntoCart();
        cartPage.checkCart(order)
                .clickContinueBtn();
        infoPage.checkPrice(order)
                .setUser(user)
                .Purchase();
        finalPage.checkProduct(order)
                .checkPrice(order);
    }
    @Test
    public void shopTestThree() {

        for (int i = 0; i < 4; i++) {
            topMenuPage.SelectRandomCategory();
            categoryPage.selectProduct();
            productPage.AddProductToCart(order);
        }

        topMenuPage.goIntoCart();
        cartPage.checkCart(order)
                .clickContinueBtn();
        infoPage.checkPrice(order)
                .setUser(user)
                .Purchase();
        finalPage.checkProduct(order)
                .checkPrice(order);
    }
}
