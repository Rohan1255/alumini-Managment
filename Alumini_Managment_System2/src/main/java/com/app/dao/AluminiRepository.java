package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Alumini;

public interface AluminiRepository extends JpaRepository<Alumini,Integer>{
	
	Optional<Alumini> findByEmailAndPassword(String email,String password);
	
	List<Alumini> findByCourseCourseName(String courseName);
	
	List<Alumini>  findByPassingYear(String year);
	
	Optional<Alumini> findByEmail(String email);

	List<Alumini> findByLastName(String lastName);
	
	
}
