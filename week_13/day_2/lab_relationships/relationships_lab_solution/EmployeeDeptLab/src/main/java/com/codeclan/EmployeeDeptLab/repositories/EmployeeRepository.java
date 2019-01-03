package com.codeclan.EmployeeDeptLab.repositories;

import com.codeclan.EmployeeDeptLab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
