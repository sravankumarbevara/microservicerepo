package com.demo.loanclearence.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.demo.loanclearence.bean.Loans;
import com.demo.loanclearence.dao.LoansRepositry;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanClearenceMockitoServiceTest {


	@Autowired
	LoansService loansService;

	@MockBean
	private LoansRepositry loansRepositry;

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

		when(loansRepositry.save(obj)).thenReturn(obj);
		System.out.println("Test Proghram Start" +  obj.toString());
		Loans loans = loansService.saveLoans(obj);
		System.out.println("Test program End"+ loans);

		assertEquals(obj.getLoanvendor(), loans.getLoanvendor());
	}


	@Test
	public void updateLoans() throws Exception {

		when(loansRepositry.save(obj)).thenReturn(obj);
		System.out.println("Test Proghram Start" +  obj.toString());
		Loans loans = loansService.updateLoans(obj);
		System.out.println("Test program End"+ loans);

		assertEquals(obj.getLoanvendor(), loans.getLoanvendor());
	}

	
	@Test
	public void getLoans() throws Exception {

		List<Loans> list = new ArrayList();
		list.add(obj);
		
		when(loansRepositry.findAll()).thenReturn(list);
		System.out.println("Test Proghram Start" +  obj.toString());
		List<Loans> list2 = loansService.retrieveLoans();
		System.out.println("Test program End"+ list2);
		assertEquals( 1 , list2.size());
		
	}
	
	@Test
	public void getLoansById() throws Exception {

		when(loansRepositry.findById(2L)).thenReturn(obj);
		System.out.println("Test Proghram Start" +  obj.toString());
		Loans loans = loansService.retrieveLoansById(2L);
		System.out.println("Test program End"+ loans);

		assertEquals(obj.getLoanvendor(), loans.getLoanvendor());
	}
	
	
	@Test
	public void deleteLoan() throws Exception {

		System.out.println("Test Proghram Start" +  obj.toString());
		loansService.deleteLoans(2);
		verify(loansRepositry, times(1)).delete(obj);
		
	}
	
}
