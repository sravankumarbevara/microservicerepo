package com.demo.loanclearence.dao;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.loanclearence.bean.Loans;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class LoansRepositryTest {


	@Autowired
	private LoansRepositry loansRepositry;

	private long loanid= 2;
	
	@Test
	@Rollback(false)
	public void retrieveLoansById() throws Exception {

		try {
			
			System.out.println("Fetch loans by id test start ");
			Loans  loan = loansRepositry.findById(loanid);
			System.out.println("Fetch loans by id test " + loan.toString());
			assertNotNull(loan);
			System.out.println("Fetch loans by id test " + loan.toString());
			

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	@Test
	@Rollback(false)
	public void retrieveLoans() throws Exception {

		try {
			
			System.out.println("RetrieveLoans test start ");
			List<Loans>  loans = loansRepositry.findAll();
			System.out.println("RetrieveLoans id test " + loans.toString());
			assertNotNull(loans);
			System.out.println("RetrieveLoans test " + loans.toString());
			

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
}
