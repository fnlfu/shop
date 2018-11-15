package Models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal total;

    public Product(String name, String price) {
        this.name = name.replaceAll("–", "-");
        price = price.substring(1);
        this.price = new BigDecimal(price);
        this.quantity = 1;
    }


    public void addQuantity() {
        quantity++;
    }

    public BigDecimal getTotal() {
        return price.multiply(new BigDecimal(quantity));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
