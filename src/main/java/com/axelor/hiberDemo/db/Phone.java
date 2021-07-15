package com.axelor.hiberDemo.db;

import javax.persistence.*;

@Entity
@Table
public class Phone {

	@Id
	
	  @GeneratedValue( strategy = GenerationType.SEQUENCE, generator =
	  "sequence-generator" )
	  
	  @SequenceGenerator( name = "sequence-generator", sequenceName =
	  "phone_sequence" )
	 
	Long id;

	@Column(length=10)
	Long number;

	public Phone() {}
	
	public Phone(Long number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long num) {
		number=num;
	}


}
