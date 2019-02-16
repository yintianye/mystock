package test.tianye.temp;

import org.springframework.beans.factory.annotation.Autowired;
import test.tianye.model.Stock;
import test.tianye.service.StockBasicInfoService;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempSpliter {

  public static String split(String fullFilePath) {
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
        Stock stock = new Stock(kv[1], kv[0], "unknown");
        stockList.add(stock);
      }

      bufferedReader.close();


      return "OK";
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

}
