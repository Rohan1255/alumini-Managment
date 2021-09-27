package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.UserHandlingException;
import com.app.dao.AluminiRepository;
import com.app.dao.FeedbackRepository;
import com.app.pojos.Alumini;
import com.app.pojos.Feedback;

@Service
@Transactional
public class AluminiServiceImpl implements IAluminiService {
	
	@Autowired
	private AluminiRepository aluminiRepo;
	@Autowired
	private FeedbackRepository feedbackRepo;
	private Alumini alumini;


	@Override
	public Feedback giveFeedback(int id, Feedback feedback) {
		alumini = aluminiRepo.findById(id).orElseThrow(() -> new UserHandlingException("Invalid id"));
		feedback.setAlumini(alumini);
		return feedbackRepo.save(feedback);
	}

}
