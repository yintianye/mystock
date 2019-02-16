package test.tianye.service;

import test.tianye.model.Stock;

import java.util.List;

public interface StockBasicInfoService {
  List<Stock> getAllStock();
  List<String> getAllStockId();
  boolean setStock(List<Stock> stockList);
}
