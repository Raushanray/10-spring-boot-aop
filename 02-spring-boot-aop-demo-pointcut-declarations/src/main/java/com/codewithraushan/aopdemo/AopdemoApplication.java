package com.codewithraushan.aopdemo;

import com.codewithraushan.aopdemo.dao.AccountDAO;
import com.codewithraushan.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		//call the business method
		Account myAccount = new Account();
		myAccount.setName("Kriti Rani");
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
