package functional.model;

import java.math.BigDecimal;

/**
 * Created by mgb on 03/04/2016.
 */
public class PaymentDataTest {
    private String type;
    private BigDecimal total;

    public PaymentDataTest(String type, BigDecimal total) {
        this.type = type;
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
