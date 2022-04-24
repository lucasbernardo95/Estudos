package com.lucasrb.batch.config;

import com.lucasrb.batch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

//<Customer, Customer> I/O
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {

        return customer;
    }
}
