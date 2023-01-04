package com.meusestudos.curso.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meusestudos.curso.entities.User;



@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"msascvxvxcvxcvxcvxvxvvcas","fdfsf","fsdffsdf","125");
		return ResponseEntity.ok().body(u);
	}
}
