package com.demo.loanclearence.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.demo.loanclearence.bean.Loans;
import com.demo.loanclearence.service.LoansService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = LoansController.class)
public class LoanClearenceMockControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoansService loansService;

	private Loans obj  = new Loans();

	private static ObjectMapper mapper = new ObjectMapper();

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
	public void retrieveLoans()  {

		try {

			List<Loans>  loans =  new ArrayList<Loans>();
			loans.add(obj);

			when(loansService.retrieveLoans()).thenReturn(loans);

			mockMvc.perform(get("/v1/fetchloans").accept(MediaType.APPLICATION_JSON)).
			andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
			.andExpect(jsonPath("$[0].loanvendor", Matchers.equalTo("BAJAJ")))
			.andExpect(jsonPath("$[0].typeofloan", Matchers.equalTo("FLEXY")));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	@Test
	public void retrieveLoansById()  {

		try {


			when(loansService.retrieveLoansById(2L)).thenReturn(obj);

			mockMvc.perform(get("/v1/fetchloansbyid/2").accept(MediaType.APPLICATION_JSON)).
			andExpect(status().isOk())
			.andExpect(jsonPath("$.loanvendor", Matchers.equalTo("BAJAJ")))
			.andExpect(jsonPath("$.typeofloan", Matchers.equalTo("FLEXY")));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test
	public void modifyloans()  {

		try {

			String json = mapper.writeValueAsString(obj);

			when(loansService.updateLoans(ArgumentMatchers.any())).thenReturn(obj);

			mockMvc.perform(put("/v1/modifyloans/2").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
					.content(json).accept(MediaType.APPLICATION_JSON)).
			andExpect(status().isOk())
			 .andExpect(jsonPath("$.loanvendor", Matchers.equalTo("BAJAJ")))
			.andExpect(jsonPath("$.typeofloan", Matchers.equalTo("FLEXY")));

			// have issue on the above need to check later

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	@Test
	public void deleteLoans()  {

		try {


			ResultActions response = mockMvc.perform(delete("/v1/deleteloans/{loanid}",2L));

			// then - verify the output
			response.andExpect(status().isOk());
					

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	@Test
	public void saveloans()  {

		try {

			when(loansService.saveLoans(ArgumentMatchers.any())).thenReturn(obj);

			/*
			 * ResultActions response = mockMvc.perform(post(
			 * "/v1/saveloans/{loanname}/{loanamount}/{startdate}/{tenure}/{yrmoday}/" +
			 * "{interstrate}/{loanvendor}/{typeofloan}",
			 * obj.getLoanName(),obj.getLoanAmount(),obj.getStartDate(),obj.getTenure(),obj.
			 * getYrmo(), obj.getInterstrate(),obj.getLoanvendor(),obj.getTypeofloan()
			 * ).accept(MediaType.APPLICATION_JSON));
			 */
			
			ResultActions response = mockMvc.perform(post( "/v1/saveloans/loanname/loanamount/startdate/tenure/yrmoday/"
					+ "interstrate/loanvendor/typeofloan" ).accept(MediaType.APPLICATION_JSON));

			// then - verify the output
			response.andExpect(status().isOk())
			.andExpect(jsonPath("$.loanvendor", Matchers.equalTo("BAJAJ")))
			.andExpect(jsonPath("$.typeofloan", Matchers.equalTo("FLEXY")));;
					

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	

}
