package com.userlocation;

public class UserResponse {
	
	private String username;
	private String email;
	private String placeName;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	@Override
	public String toString() {
		return "UserResponse [username=" + username + ", email=" + email + ", placeName=" + placeName + "]";
	} 
}
