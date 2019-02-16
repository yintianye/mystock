package test.tianye.model.modelid;


import java.io.Serializable;

public class DailyRaiseStockId implements Serializable{
  private String stockId;
  private String date;

  public DailyRaiseStockId() {
  }

  public DailyRaiseStockId(String stockId, String date) {
    this.stockId = stockId;
    this.date = date;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (obj instanceof DailyRaiseStockId) {
      DailyRaiseStockId temp = (DailyRaiseStockId)obj;
      return (this.date.equals(temp.date) && this.stockId.equals(temp.stockId));
    }

    return false;
  }
}
