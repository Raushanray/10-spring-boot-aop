package com.codewithraushan.aopdemo;

import com.codewithraushan.aopdemo.dao.AccountDAO;
import com.codewithraushan.aopdemo.dao.MembershipDAO;
import com.codewithraushan.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService){
		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);

			//demoTheAferAdvice(theAccountDAO);
			
			//demoTheAroundAdvice(theTrafficFortuneService);

			demoTheAroundAdviceHandleException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("calling getFortune");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune : " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("calling getFortune");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune : " + data);

		System.out.println("Finished");
	}

	private void demoTheAferAdvice(AccountDAO theAccountDAO) {

		//call method to find account
		List<Account> theAccounts = null;
		try{
			//add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\nMain program : ...catch Exception : " + exc);

		}

		//display the account
		System.out.println("\n\nMain program : demoTheAferAdvice");
		System.out.println("-------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		//call method to find account
		List<Account> theAccounts = null;
		try{
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
			 theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\nMain program : ...catch Exception : " + exc);

		}

		//display the account
		System.out.println("\n\nMain program : demoTheAfterThrowingAdvice");
		System.out.println("-------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		//call method to find account
		List<Account> theAccounts = theAccountDAO.findAccounts();

		//display the account
		System.out.println("\n\nMain program : demoTheAfterReturningAdvice");
		System.out.println("-------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		//call the business method
		Account myAccount = new Account();
		myAccount.setName("Ravi");
		myAccount.setLevel("platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		//call the accountDao getters/setters method
		theAccountDAO.setName("Ravi");
		theAccountDAO.setServiceCode("Gold");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();


		//call the Membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
	}

}
