package test.tianye.entity;

import java.math.BigDecimal;

public class BrifeStockInfo {
  private String value;
  private String yesterdayValue;
  private String deltaValue;
  private String deltaPercent;

  public BrifeStockInfo() {
  }

  public BrifeStockInfo(String value, String yesterdayValue, String deltaValue, String deltaPercent) {
    this.value = value;
    this.yesterdayValue = yesterdayValue;
    this.deltaValue = deltaValue;
    this.deltaPercent = deltaPercent;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getYesterdayValue() {
    return yesterdayValue;
  }

  public void setYesterdayValue(String yesterdayValue) {
    this.yesterdayValue = yesterdayValue;
  }

  public String getDeltaValue() {
    return deltaValue;
  }

  public void setDeltaValue(String deltaValue) {
    this.deltaValue = deltaValue;
  }

  public String getDeltaPercent() {
    return deltaPercent;
  }

  public void setDeltaPercent(String deltaPercent) {
    this.deltaPercent = deltaPercent;
  }
}
