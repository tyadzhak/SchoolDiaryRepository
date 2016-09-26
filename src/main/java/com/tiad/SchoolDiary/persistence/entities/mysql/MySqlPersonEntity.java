package com.tiad.SchoolDiary.persistence.entities.mysql;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tiad.SchoolDiary.model.Person;
import com.tiad.SchoolDiary.model.PersonGender;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

@Entity
@Table(name="person")
public class MySqlPersonEntity implements PersonEntity {
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5449087078308201630L;
	
	@Id
	@Column(name="recId", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name="children_sequence")
	private long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="gender")
	private PersonGender gender;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public PersonGender getGender() {
		return gender;
	}
	
	public void setGender(PersonGender gender) {
		this.gender = gender;
	}

	

}
