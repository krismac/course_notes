package com.example.codeclan.course_service.repositories.CourseRepository;

import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.models.Customer;

import java.util.List;

public interface CourseRepositoryCustom {
    List<Course> getCoursesForStarRating(int rating);
    List<Customer> getAllCustomersForCourse(Long id);

    List<Customer> getAllCustomersForCourseInTown(Long id, String town);

    List<Customer> getAllCustomersForRestInTownOverAge(Long courseId, String town, int age);
}
