package com.lucasrb.batch.service;

import com.lucasrb.batch.entity.Customer;
import com.lucasrb.batch.repository.CustomerRepository;
import com.lucasrb.batch.repository.criteria.params.CustomParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository repository;

    public List<Customer> getCustomers(CustomParams params){
        return repository.getWithFilter(params);
    }
}
