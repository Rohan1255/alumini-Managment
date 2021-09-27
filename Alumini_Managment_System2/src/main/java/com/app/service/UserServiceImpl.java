package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.UserHandlingException;
import com.app.dao.AluminiRepository;
import com.app.dao.CourseRepository;
import com.app.dao.EventsRepository;
import com.app.dao.UpdatesRepository;
import com.app.pojos.Alumini;
import com.app.pojos.Course;
import com.app.pojos.Event;
import com.app.pojos.Update;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private EventsRepository eventRepo;
	@Autowired
	private UpdatesRepository updateRepo;
	@Autowired
	private AluminiRepository aluminiRepo;
	@Autowired
	CourseRepository courseRepo;

	@Override
	public Alumini authenticateAlumini(String email, String password) {
		return aluminiRepo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new UserHandlingException("invlid email/password"));
	}

	@Override
	public List<Course> findAllACourses() {
		return courseRepo.findAll();
	}

	@Override
	public Alumini addAlumini(Alumini alumini) {
		if (aluminiRepo.findByEmail(alumini.getEmail()).isPresent())
			throw new UserHandlingException(alumini.getEmail() + "is already present");
		Course course = courseRepo.findByCourseName(alumini.getCourse().getCourseName())
				.orElseThrow(() -> new UserHandlingException("invlid Course"));
		alumini.setCourse(course);
		return aluminiRepo.save(alumini);
	}
	
	@Override
	public Alumini editAlumini(int id, Alumini alumini1) {
		Alumini alumini = aluminiRepo.findById(id).orElseThrow(() -> new UserHandlingException("Invalid id"));
		alumini.setAddress(alumini1.getAddress());
		alumini.setEmail(alumini1.getEmail());
		alumini.setMobileNo(alumini1.getMobileNo());
		alumini.setPassword(alumini1.getPassword());
		return aluminiRepo.save(alumini);
	}
	
	@Override
	public Update addUpdate(Update update, int aluminiId) {
		Alumini alumini = aluminiRepo.findById(aluminiId).orElseThrow(() -> new UserHandlingException("Invalid id"));
		update.setAlumini(alumini);
		return updateRepo.save(update);
	}

	@Override
	public Update editUpdate(int updateId, Update update) {
		Update update1 = updateRepo.findById(updateId).orElseThrow(()->new UserHandlingException("invalid update id"));
		update1.setTitle(update.getTitle());
		update1.setJobDescription(update.getJobDescription());
		return updateRepo.save(update1);
	}
	
	@Override
	public String deleteJobUpdate(int updateId) {
		Update update1 = updateRepo.findById(updateId).orElseThrow(() -> new UserHandlingException("invalid update id"));
		updateRepo.delete(update1);
		return "Update deleted";
	}

	@Override
	public List<Update> findAllUpdates() {
		return updateRepo.findAll();
	}

	@Override
	public List<Event> findAllEvent() {
		return eventRepo.findAll();
	}

}