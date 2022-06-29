package com.lucasrb.batch.repository.criteria;

import com.lucasrb.batch.entity.Customer;
import com.lucasrb.batch.repository.criteria.params.CustomParams;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> getWithFilter(CustomParams params);
}
