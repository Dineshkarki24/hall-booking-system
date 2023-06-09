package com.hrutility.hrutilityjava.service;

import com.hrutility.hrutilityjava.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);
}
