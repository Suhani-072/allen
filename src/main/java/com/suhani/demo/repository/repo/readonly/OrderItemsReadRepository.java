package com.suhani.demo.repository.repo.readonly;

import com.suhani.demo.repository.model.OrderItems;
import com.suhani.demo.utils.ReadOnlyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadOnlyRepository
public interface OrderItemsReadRepository extends JpaRepository<OrderItems, Integer> {
}
