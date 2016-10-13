package com.tiad.SchoolDiary.persistence.entities.impl;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

@MappedSuperclass
public abstract class PersonEntityImpl implements PersonEntity {
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5449087078308201630L;
	
	@Id()
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="person_sequence", schema="school_diary")
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
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
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String getMiddleName() {
		return middleName;
	}
	
	@Override
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public LocalDate getDob() {
		return dob;
	}
	
	@Override
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	@Override
	public Gender getGender() {
		return gender;
	}
	
	@Override
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
