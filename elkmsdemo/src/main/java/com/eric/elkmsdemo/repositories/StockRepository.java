package com.eric.elkmsdemo.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.eric.elkmsdemo.models.Stock;

public interface StockRepository extends ElasticsearchRepository<Stock,Long>{

    List<Stock> findByLocation(String location);

    List<Stock> findByProductId(long productId);

}
