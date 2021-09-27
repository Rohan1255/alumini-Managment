package com.app.testdao;

import static com.app.pojos.Role.ALUMINI;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Alumini;
import com.app.pojos.Course;
import com.app.pojos.Event;
import com.app.pojos.Update;
import com.app.service.IAdminService;
import com.app.service.IUserService;

@SpringBootTest
public class TestAdminDao {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private IUserService userService;

	@Test
	public void testAddUpdate() {
		Update update = new Update("update 1", "this is update 1", null, LocalDate.now());
		Update up = userService.addUpdate(update, 1);
		assertTrue(update.getTitle().equals(up.getTitle()) && update.getAlumini().getId() == up.getAlumini().getId());
	}

	@Test
	public void testFetchAllUpdates() {
		List<Update> list = userService.findAllUpdates();
		assertTrue(!list.isEmpty());
	}

	@Test
	public void testAddEvent() {
		Event event = new Event("Event1", "this is Event 1", LocalDate.now());
		Event ev = adminService.addEvent(event);
		assertTrue(event.getEventName().equals(ev.getEventName()));
	}

	@Test
	public void testFetchAllUpdatess() {
		List<Event> eventList = userService.findAllEvent();
		assertTrue(!eventList.isEmpty());
	}

	@Test
	public void TestSearch() {
		Alumini alumini = new Alumini("Prasad", "Talekar", "pra@123", "prasad213", "123445", "1234", "2022", ALUMINI,
				null, new Course("eDAC"),null,null);
				userService.addAlumini(alumini);
				Alumini al  = adminService.findByEmail("pra@123");
				assertTrue(al.getEmail()=="pra@123");
	}
	
}
