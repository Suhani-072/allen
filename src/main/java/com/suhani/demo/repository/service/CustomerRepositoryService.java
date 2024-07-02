package com.suhani.demo.repository.service;

import com.suhani.demo.constants.Messages;
import com.suhani.demo.enums.ExceptionCode;
import com.suhani.demo.repository.model.Customer;
import com.suhani.demo.repository.repo.CustomerRepository;
import com.suhani.demo.repository.repo.readonly.CustomerReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerReadRepository customerReadRepository;

    public Optional<Customer> findCustomerById(Integer id){ return  customerReadRepository.findById(id); }

    public Optional<Customer> findCustomerByContact(Long contact){ return  customerReadRepository.findByContact(contact); }

    public Customer validateAndGetCustomerById(Integer customerId){
        return findCustomerById(customerId)
                .orElse(null);
    }

    public Customer validateAndGetCustomerByContact(Long contact){
        return findCustomerByContact(contact)
                .orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
