package net.javaguides.springoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "email")
	private String email;
	
    private String password;
    
    @Column(name = "Name")
	private String name;
    
    @Column(name = "Dob")
	private char dob;
    
    @Column(name = "Place")
	private String place;
	
	public Registration(int id, String email, String password, String name, char dob, String place) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.place = place;
	}
		
	public Registration() {
		
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(char dob) {
		this.dob = dob;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
}
