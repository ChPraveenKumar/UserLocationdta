package com.userlocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {  
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)  
	 // @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "location_generator")
	 @Id
	 @Column(name="L_ID",length = 12)
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id; 
	   
	    @Column(name="latitude",length = 12)
	    private double latitude; 
	    @Column(name="longitude",length = 12)
	    private double longitude;
	    @Column(name="placeName",length = 12)
	    private String placeName;
	    @Column(name="des",length = 12)
	    private String des;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		public String getPlaceName() {
			return placeName;
		}
		public void setPlaceName(String placeName) {
			this.placeName = placeName;
		}
		public String getDes() {
			return des;
		}
		public void setDes(String des) {
			this.des = des;
		}
		@Override
		public String toString() {
			return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", placeName="
					+ placeName + ", des=" + des + "]";
		}
		
}
