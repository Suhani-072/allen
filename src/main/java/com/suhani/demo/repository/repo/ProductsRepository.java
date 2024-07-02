package com.suhani.demo.repository.repo;


import com.suhani.demo.repository.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer> {
}
