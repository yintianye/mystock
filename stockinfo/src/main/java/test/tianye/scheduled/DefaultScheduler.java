package test.tianye.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.tianye.entity.BrifeStockInfo;
import test.tianye.fetcher.StockInfoFetcher;
import test.tianye.model.DailyRaiseStock;
import test.tianye.service.DailyRaiseStockService;
import test.tianye.service.StockBasicInfoService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DefaultScheduler {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultScheduler.class);

  @Autowired
  StockBasicInfoService stockBasicInfoService;

  @Autowired
  DailyRaiseStockService dailyRaiseStockService;

 // @Scheduled(cron = "0 0 23 * * ?")
  @Scheduled(fixedDelay = 600*1000)
  public void scheduledTask() {
    List<String> stockIdList = stockBasicInfoService.getAllStockId();
    LOGGER.info("The stockIdList is {}", stockIdList);
    List<DailyRaiseStock> dailyRaiseStockList = new ArrayList<DailyRaiseStock>();
    String today = getTodayStr();
    for (String stockId : stockIdList) {
      BrifeStockInfo brifeStockInfo = StockInfoFetcher.fetchInfoFromIFeng(stockId);
      String percentStr = brifeStockInfo.getDeltaPercent();
      double realPercent = Double.parseDouble(percentStr);
      if (realPercent > 5.0) {
        LOGGER.info("Arise Id={}, Percent={}", stockId, percentStr);
        DailyRaiseStock dailyRaiseStock = new DailyRaiseStock(stockId, today, brifeStockInfo.getValue(),
          brifeStockInfo.getYesterdayValue(), brifeStockInfo.getDeltaValue(), brifeStockInfo.getDeltaPercent());

        dailyRaiseStockList.add(dailyRaiseStock);
      } else if (realPercent < -5.0) {
        LOGGER.info("Desc Id={}, Percent={}", stockId, percentStr);
      }

    }

    dailyRaiseStockService.saveAll(dailyRaiseStockList);
    LOGGER.info("Saved all today raised stocks.");
  }

//  @Scheduled(cron = "0 0 22 ")

  private static String getTodayStr() {
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return simpleDateFormat.format(date);
  }
}
