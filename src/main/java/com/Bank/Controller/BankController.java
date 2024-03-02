package com.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.Entity.Bank;
import com.Bank.Exception.BankException;
import com.Bank.Service.BankService;

@RestController
@RequestMapping(value="/bank")
public class BankController {
	@Autowired
	BankService bs;
	
	@PostMapping(value= "/postBankDetails")
	public String postBank(@RequestBody List<Bank> b) {
		return bs.postBank(b);
	}

	@GetMapping(value="/getBranchByifsc/{a}")
		public String getBranch(@PathVariable String a) throws BankException {
			return bs.getBranch(a);
	}
	
	@GetMapping(value="/getAllBank")
	public List<Bank> get() {
		return bs.get();
	}
	
	@GetMapping(value="/getBankByName/{a}")
	public Bank getBank(@PathVariable String a) {   //throws NullPointerException 
		return bs.getBank(a);
	}
}
