package net.javaguides.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	public Object getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public void setFirstName(String firstName2) {
		// TODO Auto-generated method stub
		this.firstName = firstName2;
		
	}

	public Object getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public void setLastName(String lastName2) {
		// TODO Auto-generated method stub
		this.lastName = lastName2;
		
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		this.email = email2;
		
	}

}