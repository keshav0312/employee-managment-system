package com.employee.employeemanagementsystem.reposistory;

import com.employee.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    boolean existsByEmail(String email);

    Employee findByFirstName(String firstName);
}
