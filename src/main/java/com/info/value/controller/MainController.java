package com.info.value.controller;

import com.info.value.dao.CurrencyDAO;
import com.info.value.model.Currency;
import com.info.value.service.CanvasJsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Autowired
    private CanvasJsChartService canvasJsChartService;

    // List, data currency
    @RequestMapping(value = "/")
    public ModelAndView currencyData(ModelAndView mav) {
        List<Currency> listBuy = currencyDAO.listBuy();
        List<Currency> listSale = currencyDAO.listSale();
        List<Currency> listHistory = currencyDAO.listHistory();
        Currency newCurrency = new Currency();
        mav.addObject("currencyBuy", newCurrency);
        mav.addObject("currencySale", newCurrency);
        mav.addObject("currencyAddHistory", newCurrency);
        mav.addObject("buyList", listBuy);
        mav.addObject("saleList", listSale);
        mav.addObject("list", listHistory);
        mav.setViewName("index");
        return mav;
    }

    // Save Currency buy
    @RequestMapping(value = "/saveCurrencyBuy", method = RequestMethod.POST)
    public ModelAndView saveCurrencyBuy (@ModelAttribute("currencyBuy") Currency currencyBuy){
        currencyDAO.addBuy(currencyBuy);
        return new ModelAndView("redirect:/");
    }

    // Save Currency sale
    @RequestMapping(value = "/saveCurrencySale", method = RequestMethod.POST)
    public ModelAndView saveCurrencySale (@ModelAttribute("currencySale") Currency currencySale){
        currencyDAO.addSale(currencySale);
        return new ModelAndView("redirect:/");
    }

    // Save Limit order buy/sale
    @RequestMapping(value = "/saveCurrencyAddHistory", method = RequestMethod.POST)
    public ModelAndView saveHistoryList (@ModelAttribute("currencyAddHistory") Currency currencyAddHistory){
        currencyDAO.add(currencyAddHistory);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mvc(ModelMap map){
        List<List<Map<Object, Object>>> canvasJsDataList = canvasJsChartService.getCanvasJsChartData();
        map.addAttribute("dataPointsList", canvasJsDataList);
        return "index";
    }
}



