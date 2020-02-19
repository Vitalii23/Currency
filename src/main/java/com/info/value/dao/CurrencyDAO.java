package com.info.value.dao;

import com.info.value.model.Currency;

import java.util.List;
import java.util.Map;

public interface CurrencyDAO {

    void addBuy(Currency currency);

    void addSale(Currency currency);

    void add(Currency currency);

    List<Currency> listBuy();

    List<Currency> listSale();

    List<Currency> listHistory();

    List<List<Map<Object, Object>>> getCanvasJsChartData();
}
