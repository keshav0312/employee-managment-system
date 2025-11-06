package com.employee.employeemanagementsystem.service;

import com.employee.employeemanagementsystem.exception.ResourceNotFoundException;
import com.employee.employeemanagementsystem.model.Employee;
import com.employee.employeemanagementsystem.reposistory.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override


    //get employee by id
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id: " + id));
    }

    //this method help to find employee by name
    @Override
    public Employee findByName(String name) {
        Employee employee = employeeRepository.findByFirstName(name);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found with this name: " + name);
        }
        return employee;
    }

    //this method return list of employees
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("list is empty..");
        }
        return employees;
    }

    //this method handle logic to saved employee
    @Override
    public Employee createEmployee(Employee employee) {
        boolean check = employeeRepository.existsByEmail(employee.getEmail());
        if (check) {
            throw new ResourceNotFoundException("Employee already exists");
        } else {
            return employeeRepository.save(employee);
        }

    }

    //update employee by id
    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee employee1 = employeeRepository.findById(id).get();
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            employee1.setPhone(employee.getPhone());
            employee1.setSalary(employee.getSalary());
            employee1.setStatus(employee.getStatus());
            employee1.setDepartment(employee.getDepartment());
            employee1.setDesignation(employee.getDesignation());
            employeeRepository.save(employee1);
            return employee1;
        } else {
            throw new ResourceNotFoundException("Employee not found with this id: " + id);
        }
    }

    //method is used to delete employee by id
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
