package com.info.value.service;

import com.info.value.dao.CurrencyDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ChartServiceImpl implements ChartService {

    @Autowired
    private CurrencyDAO currencyDAO;

    public void setCurrencyDAO(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Override
    public List<List<Map<Object, Object>>> getChartData() {
        return currencyDAO.getChartData();
    }
}
