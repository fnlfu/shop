package Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> productList;
    private BigDecimal total;
    private BigDecimal shiping;

    public Order() {
        productList = new ArrayList<Product>();
    }

    public void addProduct(String name, String price) {
        name = name.replaceAll("–", "-");
        for (Product pro : productList) {
            if (pro.getName().contains(name)) {
                pro.addQuantity();
                return;
            }
        }
        productList.add(new Product(name, price));
    }

    public int serchListByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name))
                return i;
        }
        return 0;
    }

    public int getQuantity(int index) {
        return productList.get(index).getQuantity();
    }

    public BigDecimal getPrice(int index) {
        return productList.get(index).getPrice();
    }

    public BigDecimal getTotal(int index) {
        return productList.get(index).getTotal();
    }

    public BigDecimal getSubTotal() {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : productList) {
            sum = sum.add(product.getTotal());
        }
        return sum;
    }

    public void setShiping(BigDecimal shiping) {
        this.shiping = shiping;
    }

    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal(0);
        sum = sum.add(getSubTotal());
        sum = sum.add(shiping);
        return sum;
    }

    public BigDecimal getShiping() {
        return shiping;
    }
}
