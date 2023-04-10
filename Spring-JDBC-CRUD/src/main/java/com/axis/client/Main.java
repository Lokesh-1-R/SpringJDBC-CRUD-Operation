package com.axis.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.axis.config.PersonConfig;
import com.axis.dao.PersonDAO;
import com.axis.model.Person;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		 Scanner scanner = new Scanner(System.in);
	        boolean exit = false;
	        while (!exit) {
	            System.out.println("\nMenu:");
	            System.out.println("1. View Person By Id");
	            System.out.println("2. View All persons");
	            System.out.println("3. Create Person");
	            System.out.println("4. Update Person");
	            System.out.println("5. Delete Person");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice(1-6): \r\n");
	            int choice = scanner.nextInt();
		
		
	
	        switch (choice) {
			case 1:
				m.displayParticularId();
				break;
			case 2:
				m.displayAllPersons();
				break;
			case 3: 
				m.CreateNewPerson();
				break;
			case 4:
				m.updatePerson();
				break;
				
			case 5:
				m.deletePerson();
				
				break;
			case 6: 
				System.out.println("You're Exitted from application");
				exit =true;
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
	        
	        }    
	}
		
	AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(PersonConfig.class);
	
	PersonDAO personDAO = application.getBean(PersonDAO.class);
	Scanner sc= new Scanner(System.in);
	
	public void displayAllPersons() {
		System.out.println("List of person is");
		
		for(Person p :personDAO.getAllPersons()) {
			System.out.println(p);
		}
	}
	
	public void displayParticularId() {
		System.out.println("Enter the id to view");
		int getId = sc.nextInt();
		System.out.println("Details of id "+getId);
		Person person=personDAO.getPersonId(getId);
		System.out.println(person);
	}
	public void CreateNewPerson() {
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter First name");
			String firstName = sc.next();
			System.out.println("Enter lastName");
			String lastName = sc.next();
			System.out.println("Enter age");
			int age =sc.nextInt();
			Person person = new Person(id,firstName,lastName,age);
			personDAO.createPerson(person);
			System.out.println("Inserted successfully");

		}
	public void updatePerson() {
		System.out.println("Enter id to update");
		int updateid=sc.nextInt();
		Person person = personDAO.getPersonId(updateid);
		System.out.println("Enter First name");
		String firstName = sc.next();
		System.out.println("Enter lastName");
		String lastName = sc.next();
		System.out.println("Enter age");
		int age =sc.nextInt();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAge(age);
		personDAO.updatePerson(person);
		System.out.println("Updated successgfully");
		
	}
	
	public void deletePerson() {
		System.out.println("enter Person ID to delete");
		int dId=sc.nextInt();
		Person person = personDAO.getPersonId(dId);
		personDAO.deletePerson(person);
		System.out.println("Deleted successfully");
	}
	
	
	

}
