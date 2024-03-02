package com.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Customer.Entity.Customer;
import com.Customer.Service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	CustomerService cusSer;
	
	@PostMapping(value="/postCustomerDetails")
	public String postC(@RequestBody List<Customer>c) {
		return cusSer.postC(c);
	}
//--------------------------------------------------------------------------------------------------------------------------------------
	@Autowired
	RestTemplate rt;              //   CONTROLLER   
	
	@PutMapping(value="/updateBranchWithCustomer")
	public String updateBranch(@RequestBody List<Customer>c) {
		
		
		String url = "http://localhost:8080/bank/getBranchByifsc/";
		c.forEach(x->{
			String ifsc = x.getIfscCode();
			
			ResponseEntity<String> branch = rt.exchange(url+ifsc,HttpMethod.GET,null,String.class);
			String b = branch.getBody();
			x.setBranch(b);
			
		});
		return cusSer.updateBranch(c);
		
		
	}

}
