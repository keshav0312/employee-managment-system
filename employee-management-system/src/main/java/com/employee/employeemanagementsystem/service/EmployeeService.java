package com.employee.employeemanagementsystem.service;


import com.employee.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);

    Employee findByName(String name);

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);
}
