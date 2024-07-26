package com.example.MilkDocumentations.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyEntity {

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
	
	@Column
	private String gender;

	@Column
	@ElementCollection
	private List<String> interests;

	@Column
	private String country;


	@Column
	private String profilePicturePath;


	public String getProfilePicturePath() {
	    return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
	    this.profilePicturePath = profilePicturePath;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public LocalDate getAssociationDate() {
		return associationDate;
	}

	public void setAssociationDate(LocalDate associationDate) {
		this.associationDate = associationDate;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
}
