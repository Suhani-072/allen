package com.suhani.demo.repository.repo;

import com.suhani.demo.repository.model.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealsConfigRepository extends CrudRepository<Deal, Integer> {

}
