package com.suhani.demo.repository.repo.readonly;

import com.suhani.demo.repository.model.Deal;
import com.suhani.demo.utils.ReadOnlyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

@ReadOnlyRepository
public interface DealsConfigReadRepository extends JpaRepository<Deal, Integer> {

    @Query("select d from Deal d where d.product.id = ?1 and d.dealStartTime <= ?2 and d.dealEndTime >= ?2 and d.saleQuantityRemaining > ?3")
    Optional<Deal> findByProduct_idAndDealStartTimeLessThanEqualAndDealEndTimeGreaterThanEqualAndSaleQuantityRemainingGreaterThan(Integer productId, LocalDateTime currentTime, Integer quantity);
}
