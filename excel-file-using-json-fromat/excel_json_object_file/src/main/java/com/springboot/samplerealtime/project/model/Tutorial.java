package com.springboot.samplerealtime.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "excel")
public class Tutorial {
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	private String CurrentDateTime;
	
	public Tutorial() {
		
	}
	
	public Tutorial(String name,String email) {
		this.name=name;
		this.email=email;
	}
	
	public String getCurrentDateTime() {
		return CurrentDateTime;
	}

	public void setCurrentDateTime(String currentDateTime) {
		this.CurrentDateTime=currentDateTime;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Tutorial [id=" +id+ ",name=" +name+ ",email=" +email+ ", currentDateTime=" +CurrentDateTime+ "]";
	}

}
