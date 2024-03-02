package com.Bank.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.Dao.BankDao;
import com.Bank.Entity.Bank;
import com.Bank.Exception.BankException;

@Service
public class BankService {
	@Autowired
	BankDao bankDao;
	
	public String postBank(List<Bank> b) {
		return bankDao.postBank(b);
	}
	
	public String getBranch(String a) throws BankException {
		List<Bank> li = this.get();
		List<Bank> list = li.stream().filter(x->x.getIfscCode().equals(a)).toList();
		
		if(list.isEmpty()) {
			throw new BankException("No Ifsc found");
		}
		else {
		  return bankDao.getBranch(a);
		}		
	}
	

	public List<Bank> get() {
		return bankDao.get();
	}
	
	public Bank getBank(String a)    { //throws NullPointerException
//		List<Bank> li = this.get();
//		List<Bank> list = li.stream().filter(x->x.getBranch().equals(a)).toList();
//		
//		if(list.isEmpty()) {
//			throw new NullPointerException("There is No Branch You are Searching");
//		}
//		else {
			return bankDao.getBank(a);
		}
 	}

