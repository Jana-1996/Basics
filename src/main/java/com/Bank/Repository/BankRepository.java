package com.Bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Bank.Entity.Bank;

public interface BankRepository extends JpaRepository<Bank,Integer> {

	@Query(value="select branch from bank_details where ifsc_code=?",nativeQuery=true)
	public String getAllBranch(String a);
	
	@Query(value="select * from bank_details where branch =?",nativeQuery = true)
	public Bank getBank(String a);
}
