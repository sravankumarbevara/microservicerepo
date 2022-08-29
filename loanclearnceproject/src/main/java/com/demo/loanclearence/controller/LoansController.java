package com.demo.loanclearence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.loanclearence.bean.Loans;
import com.demo.loanclearence.service.LoansService;



@RestController
@RequestMapping("/v1/")
public class LoansController {

	//@Autowired
	//private Configuration configuration;

	@Autowired
	private LoansService loansService;

	@Autowired
	private Environment environment;

    @Autowired
    private ResourceBundleMessageSource source;

	@GetMapping("fetchloans")
	public List<Loans> retrieveLoans()
	{

		/*String port = environment.getProperty("local.server.port");
		Loans obj = new Loans();
		obj.setLoanAmount(configuration.getLoanAmount());
		obj.setLoanName(configuration.getLoanName() );
		obj.setEnvironment(port) ; */

		List<Loans>  loans = loansService.retrieveLoans();
		if(loans == null)
		{
			throw new RuntimeException("NO DATA FOUND");
		}

		return loans;

	}

	@GetMapping("fetchloansbyid/{loanid}")
	public Loans retrieveLoansById(@PathVariable long loanid)
	{

		Loans  loan = loansService.retrieveLoansById(loanid);
		if(loan == null)
		{
			throw new RuntimeException("NO DATA FOUND");
		}

		return loan;

	}

	@PostMapping("saveloans/{loanname}/{loanamount}/{startdate}/{tenure}/{yrmoday}/"
			+ "{interstrate}/{loanvendor}/{typeofloan}")
	public Loans saveLoans(
			@PathVariable String loanname , @PathVariable String loanamount ,
			@PathVariable String startdate , @PathVariable String tenure,
			@PathVariable String yrmoday , @PathVariable String interstrate ,
			@PathVariable String loanvendor , @PathVariable String typeofloan )
	{

		String port = environment.getProperty("local.server.port");

		Loans obj = new Loans();
		obj.setLoanAmount( loanamount );
		obj.setLoanName( loanname );
		obj.setEnvironment(port) ;
		obj.setStartDate(startdate);
		obj.setTenure(tenure);
		obj.setYrmo(yrmoday);
		obj.setInterstrate(interstrate);
		obj.setLoanvendor(loanvendor);
		obj.setTypeofloan(typeofloan);

		obj = loansService.saveLoans(obj);

		return obj;

	}


	@DeleteMapping("deleteloans/{loanid}")
	public void deleteLoans( @PathVariable long loanid )
	{
		loansService.deleteLoans(loanid);
	}

	@PutMapping("modifyloans/{loanid}")
	public Loans modifyLoans( @PathVariable long loanid , @RequestBody Loans loans  )
	{

		String port = environment.getProperty("local.server.port");
		loans.setEnvironment(port) ;
		loans.setId(loanid);
		System.out.println("sravan update loans |" + loans.toString());
		return loansService.updateLoans(loans);

	}


	@GetMapping("getprojectname")
	public String getProjectName( )
	{

		System.out.println(LocaleContextHolder.getLocale());
		String name = source.getMessage( "projectname" , null,  LocaleContextHolder.getLocale() );

		return name;

	}


}
