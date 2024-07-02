package com.suhani.demo.repository.repo.readonly;

import com.suhani.demo.repository.model.Customer;
import com.suhani.demo.repository.model.Products;
import com.suhani.demo.utils.ReadOnlyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@ReadOnlyRepository
public interface CustomerReadRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByContact(Long contact);

}
