package test.tianye.model;

import test.tianye.model.modelid.DailyRaiseStockId;

import javax.persistence.*;

@Entity
@Table(name = "daily_raise_stock")
@IdClass(DailyRaiseStockId.class)
public class DailyRaiseStock {
  @Id
  @Column(name = "stock_id")
  private String stockId;
  @Id
  @Column(name = "date")
  private String date;
  @Column(name = "value")
  private String value;
  @Column(name = "yesterday_value")
  private String yesterdayValue;
  @Column(name = "delta_value")
  private String deltaValue;
  @Column(name = "delta_percent")
  private String deltaPercent;

  public DailyRaiseStock() {
  }

  public DailyRaiseStock(String stockId, String date, String value, String yesterdayValue, String deltaValue, String deltaPercent) {
    this.stockId = stockId;
    this.date = date;
    this.value = value;
    this.yesterdayValue = yesterdayValue;
    this.deltaValue = deltaValue;
    this.deltaPercent = deltaPercent;
  }

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
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
