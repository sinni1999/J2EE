package edu.jspiders.hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAOByScanner {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
	}
	

	
	public static void main(String[] args) {
		
		openConnection();
		
		Scanner scanner = new Scanner(System.in);
		
		UserDTO userDTO = new UserDTO();
		
		System.out.println("Enter the user name :");
		userDTO.setName(scanner.next());
		
		System.out.println("Enter the user email :");
		userDTO.setEmail(scanner.next());
		
		System.out.println("Enter the user mobile :");
		userDTO.setMobile(scanner.nextLong());
		
		System.out.println("Enter the user password");
		userDTO.setPassword(scanner.next());
		
		entityTransaction.begin();
		entityManager.persist(userDTO);
		entityTransaction.commit();
		closeConnection();
		
		scanner.close();			;
	}
	
	private static void closeConnection() {
		
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
		if(entityTransaction != null) {
			if(entityTransaction.isActive())
				entityTransaction.rollback();
		}
		
	}

}
