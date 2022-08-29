package com.demo.loanclearence.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@RunWith(SpringRunner.class)
@WebMvcTest(value = LoansController.class)
@ContextConfiguration(classes={SpringBootApplication.class})
public class LoanClearenceControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void fetechLoans()  {

		try {

			// execute
			// MvcResult result = mockMvc.perform(get("/v1/fetchloans").accept(MediaType.APPLICATION_JSON)).andReturn();

			MvcResult result = mockMvc.perform(get("/v1/fetchloans").accept(MediaType.APPLICATION_JSON)).andReturn();

			// verify
			int status = result.getResponse().getStatus();
			System.out.println(status);
			assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);

			// verify that service method was called once
			String resp = result.getResponse().getContentAsString();

			System.out.println("Response :"+ resp);

			assertNotNull(resp);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
