package com.example.Employee.Repository;

import com.example.Employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long > {
}
