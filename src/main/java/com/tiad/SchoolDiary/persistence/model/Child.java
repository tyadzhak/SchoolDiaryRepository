package com.tiad.SchoolDiary.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="children")
public class Child {
	
	@Id
	@Column(name="recid", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name="children_sequence")
	private long id;
	
	
}
