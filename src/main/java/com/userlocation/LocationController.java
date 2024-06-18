package com.userlocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@PostMapping("/create")
	public ResponseEntity<Location> createLocation(@RequestBody Location location){
		return new ResponseEntity<Location>(locationService.create(location),HttpStatus.CREATED);
	}
	@GetMapping("getAll")
	public ResponseEntity<List<Location>> getAll(){
		return new ResponseEntity<List<Location>>(locationService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping("updateById/{id}")
	public ResponseEntity<Location>  updateById(@RequestBody Location location,@PathVariable("id") int id){
		return new ResponseEntity<Location>(locationService.updateById(location,id),HttpStatus.OK);	
	}
}
