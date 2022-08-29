package com.demo.loanclearence.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.loanclearence.bean.Loans;
import com.demo.loanclearence.dao.LoansRepositry;


@Service
public class LoansService {

	@Autowired
	private LoansRepositry loansRepositry;


	public Loans saveLoans( Loans loans )
	{
		try {
			System.out.println("sravan saveLoans testing program");
			Date transDate = new Date();
			loans.setTransDate(transDate);
			loans = loansRepositry.save(loans);
			System.out.println("sravan saveLoans testing program end");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return loans;
	}
	
	public Loans updateLoans( Loans loans )
	{
		try {

			Date transDate = new Date();
			loans.setTransDate(transDate);
			loans = loansRepositry.save(loans);

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return loans;

	}
	
	public void deleteLoans( long loanId )
	{
		try {
			
			loansRepositry.deleteById(loanId);

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public Loans retrieveLoansById( long loanid )
	{
		Loans  loan = null;
		try {
			
			loan = loansRepositry.findById(loanid);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return loan;
	}
	
	public List<Loans> retrieveLoans()
	{
		List<Loans>  loans = null;
		
		try {
			
			loans = loansRepositry.findAll();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return loans;
	}
	

}
