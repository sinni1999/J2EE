package edu.jspiders.hibernate.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.jspiders.hibernate.dto.UserDTO;

public class UserDAOFindByScanner {
	
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id that you want to fetch/find details");
		UserDTO userDTO = entityManager.find(UserDTO.class, scanner.nextInt());
		if(userDTO != null)
			System.out.println(userDTO);
		else
			System.out.println("User not found, Invalid user id");
		closeConnection();
		
		scanner.close();
	}
	
	

}
