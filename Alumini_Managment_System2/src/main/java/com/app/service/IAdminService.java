package com.app.service;

import java.util.List;

import com.app.pojos.Alumini;
import com.app.pojos.Course;
import com.app.pojos.Event;
import com.app.pojos.Feedback;

public interface IAdminService {

	List<Alumini> findAllAlumini();

	List<Alumini> findAluminiByCourse(String course);

	List<Alumini> findAluminiByPassingYear(String year);

	String deleteAlumini(int aluminiId);

	List<Feedback> getAllFeedback();

	String deleteEvent(int id);

	Alumini findByEmail(String email);

	Event addEvent(Event event);
	
	Course addNewCourse(Course course);
	
	List<Alumini> findByLastName(String lastName);
	
	String deleteFeedback(int feedbackId);
	
	String deleteCourse(int courseId);
}
