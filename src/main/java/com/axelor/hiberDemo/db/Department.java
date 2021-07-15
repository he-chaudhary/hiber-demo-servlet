package com.axelor.hiberDemo.db;

import javax.persistence.*;

@Entity
public class Department {
	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)		        	
	Long id;

	String dname;
	
	public Department() {}

	
	public Department(String dname) {
		this.dname = dname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return dname;
	}

	public void setName(String dname) {
		this.dname = dname;
	}
}
