package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.object.Person;
import com.example.demo.service.FirebaseService;

@RestController
public class UserController {
	
	@Autowired
	FirebaseService fireBaseService;
	
	@GetMapping("/getUserDetails")
	public Person getUserDetail(@RequestHeader String name) throws InterruptedException, ExecutionException {
	//return "Requesting Detail of User "+name;
		return fireBaseService.getUserDetails(name);
	}
	
	@PostMapping("/createUser")
	public String createNewUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
	//return "Created new User "+person.getName();
		return fireBaseService.saveUserDetails(person);
	}
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
	//return "Updated user "+person.getName();
		return fireBaseService.updateUserDetails(person);
	}
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestHeader String name) {
	//return "Deleted User "+person.getName();
		return fireBaseService.deleteUser(name);
	}
}
