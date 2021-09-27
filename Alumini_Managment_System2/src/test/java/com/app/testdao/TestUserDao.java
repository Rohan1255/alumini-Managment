package com.app.testdao;

import static com.app.pojos.Role.ALUMINI;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.customexception.UserHandlingException;
import com.app.pojos.Alumini;
import com.app.pojos.Course;
import com.app.pojos.Role;
import com.app.service.IAdminService;
import com.app.service.IUserService;

@SpringBootTest
public class TestUserDao {
	@Autowired
	private IUserService userSerivce;
	@Autowired
	private IAdminService adminService;

	@Test
	public void TestRegisterAlumini() {
		Alumini alumini = new Alumini("Prasad", "Talekar", "pra@123", "prasad213", "123445", "1234", "2020", ALUMINI,
				null, new Course("eDAC"),null,null);
		userSerivce.addAlumini(alumini);
		Alumini al = adminService.findByEmail("pra@123");
		assertTrue(al.getEmail().equals("pra@123"));
	}

	@Test
	public void TestLogin() {
		Alumini al = userSerivce.authenticateAlumini("pra@123", "1234");
		assertTrue(al != null && al.getRole() == Role.ALUMINI);
	}

	@Test
	public void testLoginWithInvalidCredentials() {
		try {
			userSerivce.authenticateAlumini("pra@123123", "1234");
			assertTrue(false);
		} catch (UserHandlingException e) {
			assertTrue(e.getMessage().equals("invlid email/password"));
		}
	}

}
