package edu.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAOInsert {
	
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	// to initialize the object that is created above
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");//Persistence utility class provided by JPA used to create entityManagerFactory .
		entityManager = entityManagerFactory.createEntityManager(); // entity manager factory create entity manager to manage the entity
		entityTransaction = entityManager.getTransaction(); // through entity manager entity transaction is created for perform DML operation.
	}
	
	public static void main(String[] args) {
		
		UserDTO userDTO = new UserDTO(); // create object of UserDTO so that we can access the properties
		userDTO.setName("Jonny"); // set user name
		userDTO.setEmail("jonny@gmail.com"); // set email 
		userDTO.setMobile(9878675644l); // set mobile
		userDTO.setPassword("Jonny@123"); // set password
		
		openConnection(); // call open connection method to establish the connection
		entityTransaction.begin(); // begin the transaction so that manipulation would be performed
		entityManager.persist(userDTO); // persist()- saving the data for the longer time
		entityTransaction.commit(); // commit()-save the changes permanently in the database
		closeConnection(); // call closeConnection() to close the connection.
		
	}
	
	// close the connection to avoid resource leakage.
	private static void closeConnection() {
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
		if(entityTransaction != null){
			if(entityTransaction.isActive()) // check if entityTransaction is active or not if active then rollback.
				entityTransaction.rollback();
		}
			
	}

}
