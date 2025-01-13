package edu.jspiders.hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAOUpdateByScanner {
	
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
		System.out.println("Enter the user id that you want to update :");
		UserDTO userToBeUpdated = entityManager.find(UserDTO.class, scanner.nextInt());
		
		if(userToBeUpdated != null) {
			System.out.println("Enter the new property for the user :");
			userToBeUpdated.setPassword(scanner.next());
			entityTransaction.begin();
			entityManager.persist(userToBeUpdated);
			entityTransaction.commit();	
		}else
			System.out.println("User not found, Invalid user id");
		
		scanner.close();
		
		closeConnection();

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
