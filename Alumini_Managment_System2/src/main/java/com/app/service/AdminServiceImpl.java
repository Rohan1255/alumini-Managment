package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.UserHandlingException;
import com.app.dao.AluminiRepository;
import com.app.dao.CourseRepository;
import com.app.dao.EventsRepository;
import com.app.dao.FeedbackRepository;
import com.app.pojos.Alumini;
import com.app.pojos.Course;
import com.app.pojos.Event;
import com.app.pojos.Feedback;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AluminiRepository aluminiRepo;
	@Autowired
	private EventsRepository eventRepo;
	@Autowired
	private FeedbackRepository feedbackRepo;
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Alumini> findAllAlumini() {
		return aluminiRepo.findAll();
	}

	@Override
	public List<Alumini> findAluminiByCourse(String course) {
		return aluminiRepo.findByCourseCourseName(course);
	}

	@Override
	public List<Alumini> findAluminiByPassingYear(String year) {
		return aluminiRepo.findByPassingYear(year);
	}

	@Override
	public Alumini findByEmail(String email) {
		return aluminiRepo.findByEmail(email)
				.orElseThrow(() -> new UserHandlingException("alumini with email " + email + " does not exiets"));
	}

	@Override
	public List<Alumini> findByLastName(String lastName) {
		return aluminiRepo.findByLastName(lastName);
	}
		
	@Override
	public String deleteAlumini(int aluminiId) {
		aluminiRepo.deleteById(aluminiId);
		return "successfully deleted alumini with id " + aluminiId;

	}

	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackRepo.findAll();
	}
	
	@Override
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	
	@Override
	public String deleteEvent(int id) {
		eventRepo.deleteById(id);
		return "Event Deleted";
	}

	@Override
	public Course addNewCourse(Course course) {
		return courseRepo.save(course);
		
	}

	@Override
	public String deleteFeedback(int feedbackId) {
		 feedbackRepo.deleteById(feedbackId);
		 return "feedback with feedback id "+ feedbackId +" is deleted";
	}

	@Override
	public String deleteCourse(int courseId) {
		 courseRepo.deleteById(courseId);
		 return "Course with Course id "+ courseId +" is deleted";
	}
	
}
