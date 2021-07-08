package com.example.samplespringboot.payroll.Employee;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "SELECT s FROM Employee s")
public class Employee {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String name;
    private String role;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

}