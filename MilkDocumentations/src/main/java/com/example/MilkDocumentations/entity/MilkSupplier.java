package com.example.MilkDocumentations.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 
@Entity
public class MilkSupplier {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String firstName;
	
	@Column
	private String middleName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private LocalDate associationDate;
	
	@Column
	private String contactNo;
	public LocalDate getAssociationDate() {
		return associationDate;
	}
	public void setAssociationDate(LocalDate associationDate) {
		this.associationDate = associationDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public String getName() {
		return firstName+lastName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public MilkSupplier(long id, String firstName, String middleName, String lastName, String email, String contactNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
	}
	public MilkSupplier() {
		super();
	}
	
	
}
