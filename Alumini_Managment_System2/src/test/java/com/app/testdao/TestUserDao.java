package com.app.testdao;

import static com.app.pojos.Role.ALUMINI;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.customexception.UserHandlingException;
import com.app.dao.AluminiRepository;
import com.app.pojos.Alumini;

@DataJpaTest
public class TestUserDao {
	
	@Autowired
	private AluminiRepository aluminiRepo;
	
	@BeforeEach
	public void Test1_RegisterAlumini() {
		Alumini alumini = new Alumini("Prasad", "Talekar", "prasad@gmail.com", "prasad213", "123445", "1234", "2020", ALUMINI,
				null,null,null,null);
		Alumini registeredAlumini = aluminiRepo.save(alumini);
		assertNotNull(registeredAlumini);
	}
	
	@Test
	public void test2_FindByemail() {
		String email = "prasad@gmail.com";
		Alumini alumini1 = aluminiRepo.findByEmail(email).orElseThrow(() -> new UserHandlingException("find by email failed"));
		assertTrue(alumini1.getEmail().equals(email));
	}
	@Test
	public void test3_FindByfindByLastName() {
		String lastName = "Talekar";
		List<Alumini> list= aluminiRepo.findByLastName(lastName);
		assertTrue(!list.isEmpty());
	}
	
	@Test
	public void test54_FindByPassingYear() {
		String passingYear = "2020";
		List<Alumini> list = aluminiRepo.findByPassingYear(passingYear);
		assertTrue(!list.isEmpty());
	}
	
	@Test
	public void test5_Login() {
		String email = "prasad@gmail.com";
		String password = "1234";
		Alumini loggedAlumini = aluminiRepo.findByEmailAndPassword(email, password).orElseThrow(()-> new UserHandlingException("login failed"));
		assertNotNull(loggedAlumini);
	}
	
}
