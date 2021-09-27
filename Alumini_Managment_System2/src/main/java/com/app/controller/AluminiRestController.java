package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Alumini;
import com.app.pojos.Feedback;
import com.app.pojos.Update;
import com.app.service.IAluminiService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/alumini")
@CrossOrigin
public class AluminiRestController {
	@Autowired
	private IAluminiService aluminiService;
	@Autowired
	private IUserService userService;

	@PutMapping("/profile/{id}")
	public ResponseEntity<Alumini> editAlumini(@PathVariable int id, @RequestBody Alumini alumini) {
		return ResponseEntity.ok(userService.editAlumini(id, alumini));
	}

	@GetMapping("/updates")
	public ResponseEntity<?> getAllUpdates() {
		return ResponseEntity.ok(userService.findAllUpdates());
	}

	@GetMapping("/events")
	public ResponseEntity<?> getAllEvents() {
		return ResponseEntity.ok(userService.findAllEvent());
	}

	@PostMapping("/myupdates/{id}")
	public ResponseEntity<Update> addJobUpdate(@PathVariable int id, @RequestBody @Valid Update update) {
		return ResponseEntity.ok(userService.addUpdate(update, id));
	}

	@DeleteMapping("/myupdates/{id}")
	public ResponseEntity<String> deleteJobUpdate(@PathVariable int id) {
		return ResponseEntity.ok(userService.deleteJobUpdate(id));
	}

	@PutMapping("/myupdates/{id}")
	public ResponseEntity<?> editUpdate(@RequestBody @Valid Update update,@PathVariable int id){
		return ResponseEntity.ok(userService.editUpdate(id, update));
	}
	
	@PostMapping("/feedback/{id}")
	public ResponseEntity<Feedback> giveFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
		return ResponseEntity.ok(aluminiService.giveFeedback(id, feedback));
	}
}
