package com.info.value.model;

import java.sql.Date;

public class Currency {
    private int id;
    private double value, valueBuy, valueSale;
    private double amount, amountBuy, amountSale;
    private double result, resultBuy, resultSale;
    private double limitOrder;
    private Date date;

    public Currency() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValueBuy() {
        return valueBuy;
    }

    public void setValueBuy(double valueBuy) {
        this.valueBuy = valueBuy;
    }

    public double getValueSale() {
        return valueSale;
    }

    public void setValueSale(double valueSale) {
        this.valueSale = valueSale;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(double amountBuy) {
        this.amountBuy = amountBuy;
    }

    public double getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(double amountSale) {
        this.amountSale = amountSale;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResultBuy() {
        return resultBuy;
    }

    public void setResultBuy(double resultBuy) {
        this.resultBuy = resultBuy;
    }

    public double getResultSale() {
        return resultSale;
    }

    public void setResultSale(double resultSale) {
        this.resultSale = resultSale;
    }

    public double getLimitOrder() {
        return limitOrder;
    }

    public void setLimitOrder(double limitOrder) {
        this.limitOrder = limitOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
