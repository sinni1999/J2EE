package edu.jspiders.hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAODelete {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
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

	public static void main(String[] args) {

		openConnection();
		
		Scanner scanner  =new Scanner(System.in);
		System.out.println("Enter the user id that you want to deleted :");
		UserDTO userToBeDeleted = entityManager.find(UserDTO.class, scanner.nextInt()); // before remove first fetch the record that you want to delete.
		
		if(userToBeDeleted != null) { // check if user is present or not
			
			entityTransaction.begin(); // delete is a DML opeation so begin the transaction first
			entityManager.remove(userToBeDeleted); // remove()- delete the record from the database
			entityTransaction.commit(); // after deleting commit the transaction so that changes in database permanently.
			
			System.out.println("User is deleted successfully");
		}else
			System.out.println("User not found , Invalid user id"); // if user is not present that you want to delete.
		
		scanner.close();
		
		closeConnection();	

	}

}
