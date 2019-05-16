package com.swf.cairo.backlog.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swf.cairo.backlog.model.User;
import com.swf.cairo.backlog.service.UserService;

@RestController
@RequestMapping("/v2/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		/* User userCreated = */userService.saveUser(user);
		return new ResponseEntity<User>( HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{userName}")
	public ResponseEntity<User> getUSer(@PathParam(value ="userName" ) String userName) throws Exception {
		try {
		User user = userService.getUserByName(userName);
		
			return new ResponseEntity<User>(user, HttpStatus.OK); 
		}
		catch(Exception e ) {
			throw new Exception("an error happened !! ");
		}
	}
	
	

}
