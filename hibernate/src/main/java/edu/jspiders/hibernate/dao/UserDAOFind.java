package edu.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAOFind {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	
	private static void openConnection() {
		// Although find() is not DML operation so we don't need entityTransaction. simply we fetch the data 
		// Persistence is utility class provided by JPA. it is used to create EntityManagerFactory.based on setting define in persistence.xml
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");// hibernate is the name of persistence unit defined in persistence.xml configuration file.
		
		entityManager = entityManagerFactory.createEntityManager();
	}


	public static void main(String[] args) {
		
		openConnection();
		UserDTO userDTO = entityManager.find(UserDTO.class, 5); // find()- fetch the data from the database 
		if(userDTO != null) // check if user is null or not 
			System.out.println(userDTO); // if user is not null then return the user details according to user choice.
		else
			System.out.println("User not found, Invalid user id"); // if user is null then print this message.
		closeConnection();
	}
	
	private static void closeConnection() {
		
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
	}

}
