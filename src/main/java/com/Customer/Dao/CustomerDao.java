package com.Customer.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Customer.Entity.Customer;
import com.Customer.Repository.CustomerRepository;

@Repository
public class CustomerDao {
          
	@Autowired
	CustomerRepository custRepo;
	
	public String postC(List<Customer> c) {
		custRepo.saveAll(c);
		return "Customer Details Posted";
	}
	
	public String updateBranch(List<Customer> c) {
		custRepo.saveAll(c);
		return "Branches Updated";
	}
}
