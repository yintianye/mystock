package test.tianye.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
  @Id
  @Column(name = "stock_id")
  private String stockId;

  @Column(name = "stock_name")
  private String stockName;

  @Column(name = "stock_type")
  private String stockType;

  public Stock(String stockId, String stockName, String stockType) {
    this.stockId = stockId;
    this.stockName = stockName;
    this.stockType = stockType;
  }

  public Stock() {
  }

  public String getStockId() {
    return stockId;
  }

  public void setStockId(String stockId) {
    this.stockId = stockId;
  }

  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }

  public String getStockType() {
    return stockType;
  }

  public void setStockType(String stockType) {
    this.stockType = stockType;
  }
}
