package com.mgb.view.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by mgb on 23/03/2016.
 */
public class CurrentCash {
    private BigDecimal cash;
    private DateTime created;
    private int numberOfSales;

    public CurrentCash(BigDecimal cash, DateTime created, int numberOfSales) {
        this.cash = cash;
        this.created = created;
        this.numberOfSales = numberOfSales;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentCash that = (CurrentCash) o;

        if (numberOfSales != that.numberOfSales) return false;
        if (cash != null ? !cash.equals(that.cash) : that.cash != null) return false;
        return created != null ? created.equals(that.created) : that.created == null;

    }

    @Override
    public int hashCode() {
        int result = cash != null ? cash.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + numberOfSales;
        return result;
    }
}
