package com.example.codeclan.course_service;


import com.example.codeclan.course_service.models.Booking;
import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.models.Customer;
import com.example.codeclan.course_service.repositories.BookingRepository.BookingRepository;
import com.example.codeclan.course_service.repositories.CourseRepository.CourseRepository;
import com.example.codeclan.course_service.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void canFindAllCourses(){
		List<Course> found = courseRepository.findAll();
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCoursesForStarRating(){
		List<Course> found = courseRepository.getCoursesForStarRating(5);
		assertEquals(1, found.size());
		assertEquals("Intro To Python", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForCourseIntroToPython() {
		List<Customer> found = courseRepository.getAllCustomersForCourse(1L);
		assertEquals(1, found.size());
		assertEquals("Bob", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForCourseJavaScriptForBeginners(){
		List<Customer> found = courseRepository.getAllCustomersForCourse(2L);
		assertEquals(3, found.size());
		assertEquals("Jeff", found.get(0).getName());
		assertEquals("Jackie", found.get(1).getName());
		assertEquals("Eric", found.get(2).getName());
	}

	@Test
	public void canGetAllCustomersForJavaScriptForBeginnersInTownNovato(){
		List<Customer> found = courseRepository.getAllCustomersForCourseInTown(2L, "novato");
		assertEquals("Jeff", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForIntroToPythonInTownModena(){
		List<Customer> found = courseRepository.getAllCustomersForCourseInTown(1L, "modena");
		assertEquals("Bob", found.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForIntroToPythonInSF() {
		List<Customer> found = courseRepository.getAllCustomersForCourseInTown(1L, "san francisco");
		assertEquals(0, found.size());
	}

	@Test
	public void canGetAllBookingsForDate(){
		List<Booking> found = bookingRepository.getAllBookingsForDate("24-12-2018");
		assertEquals(3, found.size());
	}

	@Test
	public void canGetAllResturantsForCustomer(){
		List<Course> found = customerRepository.getAllCoursesForCustomer(1L);
		assertEquals("Intro To Python", found.get(0).getName());
	}

	@Test
	public void canGetCustomersInModenaForIntroToPythonOverAge(){
		List<Customer> found = courseRepository.getAllCustomersForRestInTownOverAge(1L,"modena", 18);
		assertEquals("Bob", found.get(0).getName());

	}

	@Test
	public void canGetCustomersInNovatoForJavaScriptForBeginnersOverAge(){
		List<Customer> found = courseRepository.getAllCustomersForRestInTownOverAge(2L,"novato", 18);
		assertEquals(2, found.size());
		assertEquals("Jeff", found.get(0).getName());
		assertEquals("Eric", found.get(1).getName());

	}

}
