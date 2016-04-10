package functional.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by mgb on 10/04/2016.
 */
public class ReceiptDataTest {
    private String id;
    private DateTime date;
    private String type;
    private BigDecimal total;

    public ReceiptDataTest(String id, DateTime date, String type, BigDecimal total) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
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
