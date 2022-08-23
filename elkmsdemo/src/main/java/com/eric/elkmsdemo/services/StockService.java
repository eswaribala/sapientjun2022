package com.eric.elkmsdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.elkmsdemo.models.Stock;
import com.eric.elkmsdemo.repositories.StockRepository;

@Service
public class StockService {
    @Autowired
	private StockRepository stockRepository;
    
    public Stock createStockIndex(final Stock stock)
    {
        return stockRepository.save(stock);
    }

    public Iterable<Stock> createStockIndices(final List<Stock> stockList)
    {
        return stockRepository.saveAll(stockList);
    }

    public List<Stock> getAllStockForLocation (String location)
    {
        return stockRepository.findByLocation(location);
    }

    public Stock findById (long stockId)
    {
        return stockRepository.findById(stockId).get();
    }

    public List<Stock> findByProductId (long productId)
    {
        return stockRepository.findByProductId(productId);
    }

}
