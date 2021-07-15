package com.axelor.hiberDemo.db;

import javax.persistence.*;

@Entity
@Table(
	uniqueConstraints =  @UniqueConstraint(
		    name = "uc_address",
	        columnNames = {
	            "city",
	            "state",
	            "street"
	        })
)

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String street;
	String state;
	String city;

	public Address() {	}

	
	public Address(String street, String city, String state) {
		 this.street = street; 
	      this.city = city; 
	      this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
	      return street;
	   }
	   
	   public void setStreet( String street ) {
	      this.street = street;
	   }
	   
	   public String getCity() {
	      return city;
	   }
	   
	   public void setCity( String city ) {
	      this.city = city;
	   }
	   
	   public String getState() {
	      return state;
	   }
	   
	   public void setState( String state ) {
	      this.state = state;
	   }
	    

}
