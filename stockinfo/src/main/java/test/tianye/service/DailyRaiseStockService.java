package test.tianye.service;

import test.tianye.model.DailyRaiseStock;

import java.util.List;

public interface DailyRaiseStockService {
  boolean saveAll(List<DailyRaiseStock> list);
}
