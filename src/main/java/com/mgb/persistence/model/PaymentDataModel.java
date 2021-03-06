package com.mgb.persistence.model;

import java.math.BigDecimal;

/**
 * Created by mgb on 26/03/2016.
 */
public class PaymentDataModel {
    private String type;
    private BigDecimal total;
    private int count;

    public PaymentDataModel(String type, BigDecimal total, int count) {
        this.type = type;
        this.total = total;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentDataModel that = (PaymentDataModel) o;

        if (count != that.count) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return !(total != null ? !total.equals(that.total) : that.total != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + count;
        return result;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getTotal(PaymentDataModel value){
        return value.getTotal().intValue();
    }

    @Override
    public String toString() {
        return "PaymentDataModel{" +
                "type='" + type + '\'' +
                ", total=" + total +
                ", count=" + count +
                '}';
    }
}
