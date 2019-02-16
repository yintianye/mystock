package test.tianye.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import test.tianye.model.Stock;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, String>, PagingAndSortingRepository<Stock, String>{
  @Query("SELECT a.stockId from Stock a")
  List<String> getAllStockId();

}
