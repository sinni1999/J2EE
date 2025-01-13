package edu.jspiders.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jspiders.hibernate.dto.UserDTO;


public class UserFetchCustomQuery {
	
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
		
		Query query = entityManager.createQuery("SELECT users FROM UserDTO as users");
		@SuppressWarnings("unchecked")
		List<UserDTO> users = query.getResultList();
		if(users.size()>0) {
			for(UserDTO user : users) {
				System.out.println(user);
			}
		}else
			System.out.println("user not found");

		closeConnection();
		

	}

}
