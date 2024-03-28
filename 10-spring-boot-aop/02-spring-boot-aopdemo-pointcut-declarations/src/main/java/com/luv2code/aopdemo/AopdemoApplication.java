package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import com.luv2code.aopdemo.service.TrafficFortuneServiceImpl;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAroundAdvice(theTrafficFortuneService);
//			demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
			
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\n The fortune is: " + data);

		System.out.println("finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;

		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\n The fortune is: " + data);

		System.out.println("finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\n The fortune is: " + data);

		System.out.println("finished");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\n Main program... caught exception: " + exc);
		}

		// display the accounts

		System.out.println("\n Main Program: demoTheAfterThrowingAdvice: ");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find accounts

		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts

		System.out.println("\n Main Program: demoTheAfterReturningAdvice: ");
		System.out.println("------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("John");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the account dao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();


	}
}
