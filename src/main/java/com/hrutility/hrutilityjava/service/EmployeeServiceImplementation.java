package com.hrutility.hrutilityjava.service;
import com.hrutility.hrutilityjava.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmailId().isEmpty()){
          employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream().filter((employee) -> employee.getEmployeeId().equals(id)).findFirst().get();
    }
}
