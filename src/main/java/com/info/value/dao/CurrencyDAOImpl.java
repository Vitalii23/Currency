package com.info.value.dao;

import com.info.value.model.CanvasJsChartData;
import com.info.value.model.Currency;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class CurrencyDAOImpl implements CurrencyDAO {

    private JdbcTemplate jdbcTemplate;

    public CurrencyDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addBuy(Currency currency) {
        String sql = "INSERT INTO currency_exchange.purchase (value_buy, amount_buy, result_buy) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, currency.getValueBuy(), currency.getAmountBuy(), currency.getResultBuy());
    }

    @Override
    public void addSale(Currency currency) {
        String sql = "INSERT INTO currency_exchange.sale (value_sale, amount_sale, result_sale) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, currency.getValueSale(), currency.getAmountSale(), currency.getResultSale());
    }

    @Override
    public void add(Currency currency) {
        String sql = "INSERT INTO currency_exchange.limit_order (date, value, amount, result, limit) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, currency.getDate(), currency.getValue(), currency.getAmount(),
                currency.getResult(), currency.getLimitOrder());
    }

    @Override
    public List<Currency> listBuy() {
        String sql = "SELECT * FROM currency_exchange.purchase";
        List<Currency> currencyList;
        currencyList = jdbcTemplate.query(sql, (resultSet, i) -> {
           Currency currency = new Currency();
           currency.setValue(resultSet.getDouble("value_buy"));
           currency.setAmount(resultSet.getDouble("amount_buy"));
           currency.setResult(resultSet.getDouble("result_buy"));
           return currency;
        });
        return currencyList;
    }

    @Override
    public List<Currency> listSale() {
        String sql = "SELECT * FROM currency_exchange.sale";
        List<Currency> currencyList;
        currencyList = jdbcTemplate.query(sql, (resultSet, i) -> {
            Currency currency = new Currency();
            currency.setValue(resultSet.getDouble("value_sale"));
            currency.setAmount(resultSet.getDouble("amount_sale"));
            currency.setResult(resultSet.getDouble("result_sale"));
            return currency;
        });
        return currencyList;
    }

    @Override
    public List<Currency> listHistory() {
        String sql = "SELECT * FROM currency_exchange.limit_order";
        List<Currency> currencyList;
        currencyList = jdbcTemplate.query(sql, (resultSet, i) -> {
            Currency currency = new Currency();
            currency.setDate(resultSet.getDate("date"));
            currency.setValue(resultSet.getDouble("value"));
            currency.setAmount(resultSet.getDouble("amount"));
            currency.setResult(resultSet.getDouble("result"));
            return currency;
        });
        return currencyList;
    }

    @Override
    public List<List<Map<Object, Object>>> getCanvasJsChartData() {
        return CanvasJsChartData.getCanvasJsDataList();
    }
}
