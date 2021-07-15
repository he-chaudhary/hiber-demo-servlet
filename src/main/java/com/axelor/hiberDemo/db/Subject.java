package com.axelor.hiberDemo.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Subject {

	@Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)		        	
	Long id;

	@ManyToMany(mappedBy = "sub" , cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Student> subjects = new ArrayList<>();
	
	String sname;
	public Subject() {}

	
	public Subject(String sname) {
		this.sname = sname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return sname;
	}

	public void setName(String sname) {
		this.sname = sname;
	}
	
	public List<Student> getOwners() {
        return subjects;
      }

}
