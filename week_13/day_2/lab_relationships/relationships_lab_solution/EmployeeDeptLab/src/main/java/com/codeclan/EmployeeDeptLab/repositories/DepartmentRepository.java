package com.codeclan.EmployeeDeptLab.repositories;

import com.codeclan.EmployeeDeptLab.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
