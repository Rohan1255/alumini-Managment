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
import com.app.pojos.Course;
import com.app.pojos.Event;
import com.app.pojos.Update;
import com.app.service.IAdminService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminRestController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUserService userService;

	@PostMapping("/alumini")
	public ResponseEntity<Alumini> addAlumini(@RequestBody @Valid Alumini alumini) {
		return ResponseEntity.ok(userService.addAlumini(alumini));
	}

	@GetMapping("/alumini")
	public ResponseEntity<?> getAllAlumini() {
		return ResponseEntity.ok(adminService.findAllAlumini());
	}
	
	@DeleteMapping("alumini/{id}")
	public ResponseEntity<String> deleteAlumini(@PathVariable int id) {
		return ResponseEntity.ok(adminService.deleteAlumini(id));
	}

	@GetMapping("/updates")
	public ResponseEntity<?> getAllUpdates() {
		return ResponseEntity.ok(userService.findAllUpdates());
	}
	
	@PostMapping("/updates/{id}")
	public ResponseEntity<Update> addUpdate(@RequestBody @Valid Update update,@PathVariable int id) {
		return ResponseEntity.ok(userService.addUpdate(update,id));
	}

	@PutMapping("/updates/{id}")
	public ResponseEntity<?> editUpdate(@RequestBody @Valid Update update,@PathVariable int id){
		return ResponseEntity.ok(userService.editUpdate(id, update));
	}
	
	@DeleteMapping("/updates/{id}")
	public ResponseEntity<String> deleteUpdate(@PathVariable int id) {
		return ResponseEntity.ok(userService.deleteJobUpdate(id));
	}

	@GetMapping("/events")
	public ResponseEntity<?> getAllEvents() {
		return ResponseEntity.ok(userService.findAllEvent());
	}

	@PostMapping("/events")
	public ResponseEntity<?> addEvent(@RequestBody @Valid Event event) {
		return ResponseEntity.ok(adminService.addEvent(event));
	}
	
	@DeleteMapping("/events/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable int id) {
		return ResponseEntity.ok(adminService.deleteEvent(id));
	}

	@GetMapping("/courses")
	public ResponseEntity<?> getAllCourse(){
		return ResponseEntity.ok(userService.findAllACourses());
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		return ResponseEntity.ok(adminService.addNewCourse(course));
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<?> getAllFeedback() {
		return ResponseEntity.ok(adminService.getAllFeedback());
	}
	
	@DeleteMapping("/feedback/{id}")
	public ResponseEntity<String> deleteFeedback(@PathVariable int id){
		return ResponseEntity.ok(adminService.deleteFeedback(id));
	}
	
	@GetMapping("/searchbycourse/{coursename}")
	public ResponseEntity<?> getAllAluminiByCourse(@PathVariable String coursename) {
		return ResponseEntity.ok(adminService.findAluminiByCourse(coursename));
	}

	@GetMapping("/searchbypassingyear/{year}")
	public ResponseEntity<?> getAllAluminiByPassingYear(@PathVariable String year) {
		return ResponseEntity.ok(adminService.findAluminiByPassingYear(year));
	}
	
	@GetMapping("/searchbylastname/{lastname}")
	public ResponseEntity<?> getallAluminiByLastName(@PathVariable String lastname){
		return ResponseEntity.ok(adminService.findByLastName(lastname));
	}
}
