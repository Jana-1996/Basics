package com.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Customer.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
