package functional.model;

import java.math.BigDecimal;

/**
 * Created by mgb on 10/04/2016.
 */
public class ReceiptDetailsTest {
    private String name;
    private String code;
    private int quantity;
    private BigDecimal price;
    private BigDecimal total;

    public ReceiptDetailsTest(String name, String code, int quantity, BigDecimal price, BigDecimal total) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
