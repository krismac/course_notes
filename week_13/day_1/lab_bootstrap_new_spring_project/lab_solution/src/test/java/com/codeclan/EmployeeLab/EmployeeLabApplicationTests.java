package com.codeclan.EmployeeLab;

import com.codeclan.EmployeeLab.models.Employee;
import com.codeclan.EmployeeLab.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployee() {
		Employee dilbert = new Employee("dilbert", 35, 535698, "dilbert@yahoo.com");
		employeeRepository.save(dilbert);
	}
}
