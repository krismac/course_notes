package com.example.codeclan.course_service.repositories.CustomerRepository;

import com.example.codeclan.course_service.models.Course;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Course> getAllCoursesForCustomer(Long customerId);
}
