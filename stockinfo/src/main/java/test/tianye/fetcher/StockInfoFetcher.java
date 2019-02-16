package test.tianye.fetcher;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import test.tianye.entity.BrifeStockInfo;

public class StockInfoFetcher {
  private static final Logger LOGGER = LoggerFactory.getLogger(StockInfoFetcher.class);
  private static RestTemplate restTemplate = new RestTemplate();

  public static String fetchInfoFromGTImg(String stockCode) {
    String originStr =  restTemplate.getForObject("http://qt.gtimg.cn/q=" + stockCode, String.class);
    String wanted = originStr.substring(originStr.indexOf("\"") + 1,originStr.lastIndexOf("\""));


    return wanted;
  }

  public static BrifeStockInfo fetchInfoFromIFeng(String stockCode) {
    //String originStr =  restTemplate.getForObject("api.finance.ifeng.com/akdaily/?code="+stockCode+"&type=last", String.class);
    String originStr = restTemplate.getForObject("http://hq.finance.ifeng.com/q.php?l=s_"+stockCode, String.class);
    String[] wanted = originStr.substring(originStr.indexOf("[")+1,originStr.lastIndexOf("]")).split(",");

    if (wanted.length != 4) {
      return new BrifeStockInfo("-1", "-1", "0", "0");
    }

    BrifeStockInfo result = new BrifeStockInfo(wanted[0], wanted[1], wanted[2], wanted[3]);

    return result;
  }
}
