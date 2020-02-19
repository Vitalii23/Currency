package com.info.value.service;

import com.info.value.dao.CurrencyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CanvasJsChartServiceImpl implements CanvasJsChartService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Override
    public List<List<Map<Object, Object>>> getCanvasJsChartData() {
        return currencyDAO.getCanvasJsChartData();
    }
}
