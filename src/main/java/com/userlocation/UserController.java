package com.userlocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/createUsers")
	public ResponseEntity<User> create(@RequestBody User user){
	 return new ResponseEntity<User>(service.create(user),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		return new ResponseEntity<>(service.getUserLocationById(id),HttpStatus.OK);
	}
	
	@GetMapping(value = "getUserByIdDTO/{id}")
	public ResponseEntity <UserLocationDTO> getUserByIdDTO(@PathVariable("id") int id){
		return new ResponseEntity<>(service.getUserByIdDTO(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsersLocation")
	public ResponseEntity<List<User>> getAllUsersLocation(){
		return new ResponseEntity<List<User>>(service.getAllUsersLocation(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUserLocationsDTO")
	public ResponseEntity<List<UserLocationDTO>> getAllUserLocations(){
		return new ResponseEntity<>(service.getAllUserLocations(),HttpStatus.OK);
	}
	
	@GetMapping("getUserRequestToResponse/{id}")
	public ResponseEntity<UserResponse> getUserRequestToResponse(@PathVariable("id") int id){
		return new ResponseEntity<>(service.getUserRequestToResponse(id),HttpStatus.OK);
	}
	
	@PutMapping("updateById/{id}")
	public ResponseEntity<User>  updateById(@RequestBody User user,@PathVariable("id") int id){
		return new ResponseEntity<User>(service.updateById(user,id),HttpStatus.OK);	
	}
	
	@PutMapping(value = "updateByIdDTO/{id}")
	public ResponseEntity<UserLocationDTO> updateByIdDTO(@RequestBody User user,@PathVariable("id") int id){
		return new ResponseEntity<UserLocationDTO>(service.updateByIdDTO(user,id),HttpStatus.OK);
	}
	
	@PutMapping("/updateAllUsers")
	public ResponseEntity<List<User>> updateAllUsersData(){
		return new ResponseEntity<List<User>>(service.updateAllUsersData(),HttpStatus.OK);
	}
	@DeleteMapping(value = "deleteUserById{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") int id){
	  service.deleteUserById(id);
	 return new ResponseEntity<>("User deleted Successfully",HttpStatus.OK);
	}
}
