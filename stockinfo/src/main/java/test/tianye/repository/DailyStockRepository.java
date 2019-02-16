package test.tianye.repository;

import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import test.tianye.model.DailyRaiseStock;
import test.tianye.model.modelid.DailyRaiseStockId;

public interface DailyStockRepository extends CrudRepository<DailyRaiseStock, DailyRaiseStockId>,
  PagingAndSortingRepository<DailyRaiseStock, DailyRaiseStockId> {

}
