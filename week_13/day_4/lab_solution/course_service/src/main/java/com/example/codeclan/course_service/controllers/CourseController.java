package com.example.codeclan.course_service.controllers;

import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.models.Customer;
import com.example.codeclan.course_service.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/stars/{rating}")
    public List<Course> coursesForStarRating(@PathVariable int rating){
       return courseRepository.getCoursesForStarRating(rating);
    }

    @GetMapping(value = "/{id}/customers")
    public List<Customer> customersForCourse(@PathVariable Long id){
        return courseRepository.getAllCustomersForCourse(id);
    }

    @GetMapping(value = "{id}/customers/town/{town}")
    public List<Customer> customersForCourseInTown(@PathVariable Long id,
                                                       @PathVariable String town){
        return courseRepository.getAllCustomersForCourseInTown(id, town);
    }
}
