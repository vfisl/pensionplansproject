package com.vfislk.training;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vfislk.training.model.Agent;
import com.vfislk.training.model.Coverage;
import com.vfislk.training.model.Customer;
import com.vfislk.training.model.Nominee;
import com.vfislk.training.model.Occupation;
import com.vfislk.training.model.Plans;
import com.vfislk.training.model.Relationship;
import com.vfislk.training.service.IAgentService;
import com.vfislk.training.service.ICustomerService;
import com.vfislk.training.service.INomineeService;
import com.vfislk.training.service.IPlansService;

@SpringBootApplication
public class SpringPensionplanProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringPensionplanProjectApplication.class, args);
	}

	@Autowired
	IAgentService agentService;

	@Autowired
	ICustomerService customerService;

	@Autowired
	IPlansService plansService;

	@Autowired
	INomineeService nomineeService;

	@Override
	public void run(String... args) throws Exception {

		Nominee nominee1 = new Nominee("Virat", 35, "6360359939", Relationship.BROTHER);
		Nominee nominee2 = new Nominee("Rahul", 25, "7562323939", Relationship.BROTHER);
		Nominee nominee3 = new Nominee("Pramod", 60, "8660458636", Relationship.FATHER);
		Nominee nominee4 = new Nominee("Joe", 45, "6360359939", Relationship.FATHER);
		Nominee nominee5 = new Nominee("Sita", 28, "7562323958", Relationship.SISTER);
		Nominee nominee6 = new Nominee("Nikita", 30, "7660458621", Relationship.SISTER);
		Nominee nominee7 = new Nominee("Surekha", 40, "6360359945", Relationship.MOTHER);
		Nominee nominee8 = new Nominee("Sita", 46, "8772323939", Relationship.MOTHER);
		Nominee nominee9 = new Nominee("Poornima", 35, "4660458620", Relationship.WIFE);
		Nominee nominee10 = new Nominee("Root", 48, "9660458645", Relationship.HUSBAND);

//		nomineeService.addNominee(nominee1);
//		nomineeService.addNominee(nominee2);
//		nomineeService.addNominee(nominee3);
//		nomineeService.addNominee(nominee4);
//		nomineeService.addNominee(nominee5);
//		nomineeService.addNominee(nominee6);
//		nomineeService.addNominee(nominee7);
//		nomineeService.addNominee(nominee8);
//		nomineeService.addNominee(nominee9);
//		nomineeService.addNominee(nominee10);

		Set<Nominee> nominees1 = new HashSet<>(Arrays.asList(nominee1, nominee2));
		Set<Nominee> nominees2 = new HashSet<>(Arrays.asList(nominee3, nominee4));
		Set<Nominee> nominees3 = new HashSet<>(Arrays.asList(nominee5, nominee6));
		Set<Nominee> nominees4 = new HashSet<>(Arrays.asList(nominee7, nominee8));
		Set<Nominee> nominees5 = new HashSet<>(Arrays.asList(nominee9, nominee10));

		Customer customer1 = new Customer("Pramod", "Anachimath", "14/06/1999", "pramodanachimath@gmail.com",
				"9695632144", 23, Occupation.SALARIED, nominees1);
		Customer customer2 = new Customer("Virat", "Kohli", "05/011/1988", "viratkohli@gmail.com", "6895632145", 32,
				Occupation.SALARIED, nominees2);
		Customer customer3 = new Customer("Guru", "Itagi", "11/10/1998", "Pramod@gmail.com", "5895632142", 24,
				Occupation.SELFEMPLOYEED, nominees3);
		Customer customer4 = new Customer("Rahul", "Dravid", "11/01/1973", "rahuldravid@gmail.com", "4895632143", 45,
				Occupation.SELFEMPLOYEED, nominees4);
		Customer customer5 = new Customer("Rohit", "Sharma", "30/04/1987", "rohitsharma@gmail.com", "3895632144", 33,
				Occupation.STUDENT, nominees5);
		
//		customerService.addCustomer(customer1);
//		customerService.addCustomer(customer2);
//		customerService.addCustomer(customer3);
//		customerService.addCustomer(customer4);
//		customerService.addCustomer(customer5);
		
		
		Set<Customer> customers=new HashSet<>(Arrays.asList(customer1,customer2));
		Agent agent1 = new Agent("Root", "Karnataka", "6360355939", customers);
		agentService.addAgent(agent1);
		
		
		
		Set<Customer> ncustomers=new HashSet<>(Arrays.asList(customer3,customer4));
		Agent agent2 = new Agent("Joe", "Hydrabad", "7895631149", ncustomers);
		agentService.addAgent(agent2);
		
		
		
		Set<Customer> mcustomers=new HashSet<>(Arrays.asList(customer5));
		Agent agent3 = new Agent("Amith", "Karnataka", "8762323939", mcustomers);
		agentService.addAgent(agent3);

		
		Set<Agent> agents=new HashSet<>(Arrays.asList(agent1,agent2));
		Set<Agent> nagents=new HashSet<>(Arrays.asList(agent3));
		Plans plans1 = new Plans("Aditya Birla Sunlife Empower Pension Plan", 25, "5-30", 18000, 500000,
				Coverage.PARENTS, agents);
		
		Plans plans2 = new Plans("Aegon Life Guaranteed Income Advantage Plan", 20, "25-55", 10000, 200000,
				Coverage.SHARING, nagents);


		plansService.addPlans(plans1);
		plansService.addPlans(plans2);


		System.out.println("Get All");
		agentService.getAllAgents().forEach(System.out::println);
	
	}

}
