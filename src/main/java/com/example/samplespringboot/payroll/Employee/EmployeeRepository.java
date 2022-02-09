package com.example.samplespringboot.payroll.Employee;


import com.example.samplespringboot.payroll.beans.UserBean;
import com.example.samplespringboot.payroll.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Optional<Employee> findById(Integer id);
}