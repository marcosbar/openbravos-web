package com.mgb.persistence.model;

import java.math.BigDecimal;

/**
 * Created by mgb on 10/04/2016.
 */
public class TicketLineModel {

    private String name;
    private String code;
    private int line;
    private int units;
    private BigDecimal price;

    public TicketLineModel(String name, String code, int line, int units, BigDecimal price) {
        this.name = name;
        this.code = code;
        this.line = line;
        this.units = units;
        this.price = price;
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

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
