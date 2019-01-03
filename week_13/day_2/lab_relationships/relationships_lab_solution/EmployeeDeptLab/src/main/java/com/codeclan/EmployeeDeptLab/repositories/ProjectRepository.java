package com.codeclan.EmployeeDeptLab.repositories;

import com.codeclan.EmployeeDeptLab.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
