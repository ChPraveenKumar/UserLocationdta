package com.userlocation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User create(User user) {
		return repo.save(user);
	}
	
	public User getUserLocationById(int id) {
		return repo.findById(id);
	}
	
   public UserLocationDTO getUserByIdDTO(int id) {
		
		return convertDataIntoUserDTO(repo.findById(id));
	}
	
	private UserLocationDTO convertDataIntoUserDTO(User user) {
		UserLocationDTO dto=new UserLocationDTO();
		dto.setUserId(user.getId());
		dto.setUsername(user.getName());
		Location loc = user.getLoc();
		dto.setLocationId(loc.getId());
		dto.setLatitude(loc.getLatitude());
		dto.setLongitude(loc.getLongitude());
		dto.setPlace(loc.getPlaceName());
		return dto;
	}
	public List<User> getAllUsersLocation() {
		return getAllUserData(repo.findAll());
	}
	
	private List<User> getAllUserData(List<User> user) {
		List<User> list=new ArrayList<User>();
		for(User users:user) {
			list.add(users);
		}
		return list;
	}
	
	public List<UserLocationDTO> getAllUserLocations() 
	{
		return convertDataIntoDTO(repo.findAll());
	}
	
	private List<UserLocationDTO> convertDataIntoDTO(List<User> user) {
		
		List<UserLocationDTO> list=new ArrayList<>();
		 for(User useres:user) {
			 list.add(convertDataToDTO(useres));
		 }
		return list;
	}
	
	private UserLocationDTO convertDataToDTO(User useres) {
		
		UserLocationDTO dto=new UserLocationDTO();
		dto.setUserId(useres.getId());
		dto.setUsername(useres.getName());
		dto.setUsername(useres.getUsername());
		Location loc = useres.getLoc();
		dto.setLocationId(loc.getId());
		dto.setLatitude(loc.getLatitude());
		dto.setLongitude(loc.getLongitude());
		dto.setPlace(loc.getPlaceName());
		
		return dto;
	}
	
	public void deleteUserById(int id) {
		
	 repo.deleteById(id);
	}
	public UserResponse getUserRequestToResponse(int id) {
		
		return getUserRequestToResponseDTO(repo.findById(id));
	}
	private UserResponse getUserRequestToResponseDTO(User user) {
		UserResponse response=new UserResponse();
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		Location loc = user.getLoc();
		response.setPlaceName(loc.getPlaceName());
		return response;
	}
	
	public User updateById(User user, int id) {
		User existingUser = repo.findById(user.getId());
		//existingUser.setId(user.getId());
		existingUser.setName(user.getName());
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPass(user.getPass());
		Location exitLoc = existingUser.getLoc();
		Location l=new Location();
		exitLoc.setPlaceName(l.getPlaceName());
		exitLoc.setLatitude(l.getLatitude());
		exitLoc.setLongitude(l.getLongitude());
		exitLoc.setDes(l.getDes());
		User save1 = repo.save(existingUser);
		return repo.save(save1);
	}
	
	public UserLocationDTO updateByIdDTO(User user, int id) {
		User existingUser = repo.findById(user.getId());
		existingUser.setId(user.getId());
		existingUser.setName(user.getName());
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPass(user.getPass());
		return convertDataToDTO(repo.save(existingUser));
	}
	
	public List<User> updateAllUsersData() {
		
		return getUpdateAllUsersData(repo.findAll());
	}
	private List<User> getUpdateAllUsersData(List<User> user) {
		List<User> list=new ArrayList<User>();
		for(User users:user) {
			list.add(updateAllUserData(users));
		}
		return list;
	}
	
	private User updateAllUserData(User users1) {
		User exist=new User();
		exist.setId(users1.getId());
		exist.setEmail(users1.getEmail());
		exist.setName(users1.getName());
		exist.setUsername(users1.getUsername());
		exist.setPass(users1.getPass());
		Location loc = users1.getLoc();
		exist.setLoc(loc);
		return repo.save(exist);
	}

}