package com.epam.producing.testProject.repository;

import com.epam.producing.testProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
