package edu.jspiders.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity // to make the class as entity class
@Table(name = " user ") // specifies the table name
@Data // generate getter and setter and noArgsConstructor and allArgsConstructor automatically.
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // asked database to provide id automatically
	private int id;
	@Column(nullable = false, unique = false) // apply constraints to the column.
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long mobile;
	@Column(nullable = false, unique = false)
	private String password;
	

}
