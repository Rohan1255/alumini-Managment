package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Alumini;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
	@Autowired
	private IUserService userService;

	@GetMapping("/courses")
	public ResponseEntity<?> getAllCourses() {
		return ResponseEntity.ok(userService.findAllACourses());
	}

	@PostMapping("/login")
	public ResponseEntity<Alumini> findbyEmailAndPassword(@RequestBody Alumini alumini) {
		return ResponseEntity.ok(userService.authenticateAlumini(alumini.getEmail(), alumini.getPassword()));
	}

	@PostMapping("/register")
	public ResponseEntity<Alumini> RegisterAlumini(@RequestBody @Valid Alumini alumini) {
		return ResponseEntity.ok(userService.addAlumini(alumini));
	}

}
