package edu.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jspiders.hibernate.dto.UserDTO;



public class UserDAOFetchCustomQueryBasedEmailAndPassword {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	private static void closeConnection() {
		
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
	}

	public static void main(String[] args) {

		openConnection();
		
		Query query = entityManager.createQuery("SELECT user FROM UserDTO  as user WHERE user.email = ?1 AND user.password = ?2") ;
		query.setParameter(1, "sinni@gmail.com");
		query.setParameter(2, "Sinni@123");
		
		// if user set correct Parameter then get the answer properly but if by mistake user set wrong parameter get exception "NoResultException" so we have to handled it
		try {
			
			UserDTO user = (UserDTO) query.getSingleResult(); // get the single result as output because email is unique in nature
			System.out.println(user);	
		} catch (Exception e) {
			System.out.println("Invalid email and password please check it again");
		}
		
		closeConnection();

	}

}
