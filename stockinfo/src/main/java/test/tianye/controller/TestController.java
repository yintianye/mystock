package test.tianye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.tianye.entity.BrifeStockInfo;
import test.tianye.fetcher.StockInfoFetcher;
import test.tianye.model.Stock;
import test.tianye.service.StockBasicInfoService;
import test.tianye.temp.TempSpliter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
  @Autowired
  StockBasicInfoService stockBasicInfoService;

  @RequestMapping("/info/stock")
  public BrifeStockInfo getStockInfo(@RequestParam("stockCode") String stockCode) {
    return StockInfoFetcher.fetchInfoFromIFeng(stockCode);
  }

  @RequestMapping("/test/split")
  public String split() {
    return split("D:\\temp\\sh.txt");
  }



  public String split(String fullFilePath) {
    File targetFile = new File(fullFilePath);
    try {
      FileInputStream fileInputStream = new FileInputStream(targetFile);
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");

      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
      List<Stock> stockList = new ArrayList<Stock>();
      String aline = bufferedReader.readLine();
      String[] items = aline.split("\\)");
      for (String item : items) {
        String[] kv = item.split("\\(");
        Stock stock = new Stock("sh"+kv[1], kv[0], "unknown");
        stockList.add(stock);
      }

      bufferedReader.close();

      stockBasicInfoService.setStock(stockList);

      return "OK";
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
