package edu.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAOUpdate {
	
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
		
		UserDTO userToBeUpdated = entityManager.find(UserDTO.class, 4); // first fetch the properties that you want to updated.
		if(userToBeUpdated != null) { // check if that user is present or not
			System.out.println(userToBeUpdated);
			userToBeUpdated.setPassword("Jonny@1234"); // set the new properties that you want to updated
			entityTransaction.begin(); // begin the transaction in order to perform DML operation
			entityManager.persist(userToBeUpdated); // after setting the new properties then persist(saving data for longer time)
			entityTransaction.commit(); // after that commit the transaction.
		}
		else
			System.out.println("User not found , Invalid user Id");
		
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
