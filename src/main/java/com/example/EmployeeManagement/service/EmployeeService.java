package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // GET ALL
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET BY ID
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setDepartment(updatedEmployee.getDepartment());
            emp.setSalary(updatedEmployee.getSalary());
            emp.setStatus(updatedEmployee.getStatus());
            return employeeRepository.save(emp);
        }).orElse(null);
    }

    // PATCH
    public Employee partialUpdate(int id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(emp -> {
            if (updatedEmployee.getName() != null)
                emp.setName(updatedEmployee.getName());
            if (updatedEmployee.getDepartment() != null)
                emp.setDepartment(updatedEmployee.getDepartment());
            if (updatedEmployee.getSalary() != null)
                emp.setSalary(updatedEmployee.getSalary());
            if (updatedEmployee.getStatus() != null)
                emp.setStatus(updatedEmployee.getStatus());
            return employeeRepository.save(emp);
        }).orElse(null);
    }

    // DELETE
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

