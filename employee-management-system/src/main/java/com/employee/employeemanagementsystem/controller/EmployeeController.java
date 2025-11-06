package com.employee.employeemanagementsystem.controller;


import com.employee.employeemanagementsystem.model.Employee;
import com.employee.employeemanagementsystem.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private  final EmployeeService employeeService;

    @GetMapping("/test")
    public  String test(){
        return "test";
    }

    @GetMapping("/employee")
    public  ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employee/{id}")
      public  ResponseEntity<Employee> getEmployee(@PathVariable  Long id){
        Employee employee = employeeService.findById(id);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> savedEmployee(@Valid  @RequestBody Employee employee){
        Employee employee1 = employeeService.createEmployee(employee);
        return ResponseEntity.ok(employee1);

    }

    @GetMapping("/employee/search/{name}")
    public ResponseEntity<Employee> employeeByName( @PathVariable String name){
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    @PutMapping("/employee/{id}")
    public  ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable Long id){
        return  ResponseEntity.ok(employeeService.updateEmployee(employee, id));
    }


    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable  Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().body("Employee deleted");
    }
}
