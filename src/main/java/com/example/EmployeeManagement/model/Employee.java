package com.example.EmployeeManagement.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    private String name;
    private String department;
    private Double salary;
    private String status;

    public Employee() {}

    public Employee(Integer id, String name, String department, Double salary, String status) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

