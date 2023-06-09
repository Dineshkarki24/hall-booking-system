package com.hrutility.hrutilityjava.controller;

import com.hrutility.hrutilityjava.model.Employee;
import com.hrutility.hrutilityjava.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
    return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }
}
