package functional.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mgb on 03/04/2016.
 */
public class CurrentCashTest {
    private BigDecimal cash;
    private DateTime created;
    private int numberOfSales;
    List<PaymentDataTest> paymentTypes;

    public CurrentCashTest(BigDecimal cash, DateTime created, int numberOfSales) {
        this.cash = cash;
        this.created = created;
        this.numberOfSales = numberOfSales;
    }

    public List<PaymentDataTest> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<PaymentDataTest> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

}
