package com.demo.loanclearence.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.loanclearence.bean.Loans;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanClearenceServiceTest {


	@Autowired
	LoansService loansService;


	private Loans obj  = new Loans();

	@Before
	public void beforecall()
	{

		System.out.println("loans object is intilization start");

		obj.setLoanAmount( "50000" );
		obj.setLoanName( "personal loan" );
		obj.setEnvironment("7000") ;
		obj.setStartDate("12/12/2022");
		obj.setTenure("5");
		obj.setYrmo("YR");
		obj.setInterstrate("12.25");
		obj.setLoanvendor("BAJAJ");
		obj.setTypeofloan("FLEXY");

		System.out.println("loans object is intilization end");

	}

	@Test
	public void saveLoans() throws Exception {

		System.out.println("Test Proghram Start" +  obj.toString());
		Loans loans = loansService.saveLoans(obj);
		System.out.println("Test program End"+ loans);

		assertEquals(obj.getLoanvendor(), loans.getLoanvendor());
	}


	@Test
	public void deleteLoans() throws Exception {

		System.out.println("Test deleteLoans Start");
		loansService.deleteLoans(2);
		System.out.println("Test deleteLoans End");


	}

}
