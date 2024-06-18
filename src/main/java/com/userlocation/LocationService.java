package com.userlocation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	LocationRepo locationRepo;

	public List<Location> getAll() {
		return locationRepo.findAll();
	}
	
	/*
	private List<Location> getAllUserData(List<Location> location) {
		List<Location> list=new ArrayList<Location>();
		for(Location locations:location) {
			list.add(locations);
		}
		return list;
	}*/
/*
	private List<User> getAllUserData(List<User> user) {
		List<User> list=new ArrayList<User>();
		for(User users:user) {
			list.add(users);
		}
		return list;
	}
*/
	@Transactional
	public Location create(Location location) {
		return locationRepo.save(location);
	}

	public Location updateById(Location location, int id) {
		Location exitLoc = locationRepo.findById(location.getId());
		exitLoc.setLatitude(location.getLatitude());
		exitLoc.setLongitude(location.getLongitude());
		exitLoc.setPlaceName(location.getPlaceName());
		exitLoc.setDes(location.getDes());
		return locationRepo.save(exitLoc);
	}
}
