package com.Bank.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Bank.Entity.Bank;
import com.Bank.Repository.BankRepository;

@Repository
public class BankDao {
	@Autowired
	BankRepository bankRepo;
	
	public String postBank(List<Bank> b) {
		bankRepo.saveAll(b);
		return "Bank Details Posted";
	}
	
	public String getBranch(String a) {
		return bankRepo.getAllBranch(a);
	}
	
	public List<Bank> get() {
		return bankRepo.findAll();
	}
	
	public Bank getBank(String a) {
		return bankRepo.getBank(a);
	}
}
