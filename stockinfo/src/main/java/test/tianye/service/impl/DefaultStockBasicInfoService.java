package test.tianye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.tianye.model.Stock;
import test.tianye.repository.StockRepository;
import test.tianye.service.StockBasicInfoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultStockBasicInfoService implements StockBasicInfoService{

  @Autowired
  private StockRepository stockRepository;

  @Override
  public List<Stock> getAllStock() {
    List<Stock> stockList = new ArrayList<Stock>();
    Iterable<Stock> stockIterable = stockRepository.findAll();
    while (stockIterable.iterator().hasNext()) {
      Stock stock = stockIterable.iterator().next();
      stockList.add(stock);
    }

    return stockList;
  }

  @Override
  public List<String> getAllStockId() {
    return stockRepository.getAllStockId();
  }

  @Override
  public boolean setStock(List<Stock> stockList) {
    stockRepository.save(stockList);
    return true;
  }
}
