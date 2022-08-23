package com.eric.elkmsdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.eric.elkmsdemo.models.Stock;
import com.eric.elkmsdemo.services.StockService;

@RestController
public class StockController {
	@Autowired
    private StockService stockService;


    @GetMapping("/stocks/{location}")
    public List<Stock> searchStockByLocation(@PathVariable("location") String location)
    {
        return stockService.getAllStockForLocation(location);

      
    }

    @GetMapping("/stocks/search/{productId}")
    public List<Stock> searchStockByProductId(@PathVariable("productId") long productId )
    {
        return stockService.findByProductId(productId);
    }

    @PostMapping("/stocks")
    public Stock addStock(@RequestBody Stock stock)
    {

        return stockService.createStockIndex(stock);
    }

    @PostMapping("/stocks/createInBulk")
    public  List<Stock> addStockInBulk(@RequestBody List<Stock> stockList)
    {
        return (List<Stock>) stockService.createStockIndices(stockList);
    }

}
