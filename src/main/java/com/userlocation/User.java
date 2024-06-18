package com.userlocation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "User")
public class User {

	@Id  
   // @GeneratedValue(strategy = GenerationType.IDENTITY)  
	 // @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_generator")

    private int id;  
    private String username;  
    private String name; 
    private String pass;  
    private String email;
   
    @ManyToOne(targetEntity = Location.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
    //@ManyToOne(targetEntity = Location.class,fetch = FetchType.LAZY)
   // @JoinColumn(name = "L_ID")
    @JoinColumn(name = "L_ID", referencedColumnName = "L_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Location loc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", pass=" + pass + ", email=" + email
				+ ", loc=" + loc + "]";
	}

}