package com.codeclan.EmployeeLab.controllers;

import com.codeclan.EmployeeLab.models.Employee;
import com.codeclan.EmployeeLab.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
