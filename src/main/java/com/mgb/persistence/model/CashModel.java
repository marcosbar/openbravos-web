package com.mgb.persistence.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mgb on 23/03/2016.
 */
public class CashModel {
    private String id;
    private DateTime start;
    private DateTime end;
    private List<PaymentData> paymentDetails;

    public List<PaymentData> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentData> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CashModel cashModel = (CashModel) o;

        if (id != null ? !id.equals(cashModel.id) : cashModel.id != null) return false;
        if (start != null ? !start.equals(cashModel.start) : cashModel.start != null) return false;
        if (end != null ? !end.equals(cashModel.end) : cashModel.end != null) return false;
        return !(paymentDetails != null ? !paymentDetails.equals(cashModel.paymentDetails) : cashModel.paymentDetails != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (paymentDetails != null ? paymentDetails.hashCode() : 0);
        return result;
    }
}
