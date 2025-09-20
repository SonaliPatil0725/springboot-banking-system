package com.exponent.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exponent.banking.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
