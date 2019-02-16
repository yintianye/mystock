package test.tianye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.tianye.model.DailyRaiseStock;
import test.tianye.repository.DailyStockRepository;
import test.tianye.service.DailyRaiseStockService;

import java.util.List;

@Service
public class DefaultDailyRaiseStockService implements DailyRaiseStockService{
  @Autowired
  DailyStockRepository dailyStockRepository;

  @Override
  public boolean saveAll(List<DailyRaiseStock> list) {
    dailyStockRepository.save(list);
    return true;
  }
}
