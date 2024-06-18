package com.userlocation;



public class UserLocationDTO {

	private int userId; 
	 private long locationId;
	private String username;  
    private double latitude;  
    private double longitude;  
    private String place;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "UserLocationDTO [userId=" + userId + ", locationId=" + locationId + ", username=" + username
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", place=" + place + "]";
	}
}
