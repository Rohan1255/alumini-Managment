package com.app.service;

import java.util.List;

import com.app.pojos.Alumini;
import com.app.pojos.Course;
import com.app.pojos.Event;
import com.app.pojos.Update;

public interface IUserService {

	Alumini authenticateAlumini(String email, String password);

	Alumini addAlumini(Alumini alumini);

	List<Course> findAllACourses();
	
	List<Update> findAllUpdates();

	List<Event> findAllEvent();

	Update addUpdate(Update update, int aluminiId);

	Alumini editAlumini(int id, Alumini alumini);

	String deleteJobUpdate(int updateId);
	
	Update editUpdate(int updateId,Update update);
}
