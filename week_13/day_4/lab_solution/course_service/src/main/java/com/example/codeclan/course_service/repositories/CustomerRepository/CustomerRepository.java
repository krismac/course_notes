package com.example.codeclan.course_service.repositories.CustomerRepository;

import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
    List<Course> getAllCoursesForCustomer(Long customerId);
}
