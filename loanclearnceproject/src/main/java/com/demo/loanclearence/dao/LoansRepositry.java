package com.demo.loanclearence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.loanclearence.bean.Loans;

public interface LoansRepositry extends JpaRepository<Loans, Long> {

	Loans findById(long id);
	Loans findByLoanAmount(String loanAmount);
	
}
