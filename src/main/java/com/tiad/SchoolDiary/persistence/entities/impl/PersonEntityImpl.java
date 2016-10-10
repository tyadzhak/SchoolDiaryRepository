package com.tiad.SchoolDiary.persistence.entities.impl;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tiad.SchoolDiary.model.Gender;
import com.tiad.SchoolDiary.model.Role;
import com.tiad.SchoolDiary.persistence.entities.PersonEntity;

@Entity
//@MappedSuperclass
@Table(name="person", schema="schoolDiary")
public /*abstract*/ class PersonEntityImpl implements PersonEntity {
	/**
	 * serial
	 */
	private static final long serialVersionUID = 5449087078308201630L;
	
	@Id
	@Column(name="recId", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="person_sequence", schema="schoolDiary")
	private long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dob")
	//@Temporal(TemporalType.DATE)
	private LocalDate dob;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
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

	@Override
	public Role getRole() {
		return role;
	}
	
	@Override
	public void setRole(Role role) {
		this.role = role;
	}

}
