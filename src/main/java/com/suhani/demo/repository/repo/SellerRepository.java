package com.suhani.demo.repository.repo;

import com.suhani.demo.repository.model.Seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
}
