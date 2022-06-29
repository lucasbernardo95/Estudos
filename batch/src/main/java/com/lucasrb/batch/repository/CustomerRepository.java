package com.lucasrb.batch.repository;

import com.lucasrb.batch.entity.Customer;
import com.lucasrb.batch.repository.criteria.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, CustomerRepositoryCustom {
}
