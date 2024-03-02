package com.Customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Customer.Dao.CustomerDao;
import com.Customer.Entity.Customer;

@Service
public class CustomerService {
	@Autowired                    // SERVICE                     
	CustomerDao cusDao;
	
	public String postC(List<Customer> c) {
		return cusDao.postC(c);
	}
	
	public String updateBranch(List<Customer> c) {
		return cusDao.updateBranch(c);
	}

}
