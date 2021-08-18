package com.example.samplespringboot.payroll.services;

import com.example.samplespringboot.payroll.Employee.Employee;
import com.example.samplespringboot.payroll.Employee.EmployeeRepository;
import com.example.samplespringboot.payroll.beans.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {
    @Autowired
    EmployeeRepository repository;

//    @Autowired
//    private Template<String, String> kafkaTemplate;

    public List<EmployeeBean> getEmployeeList() {
        List<Employee> employeeList =  repository.findAll();
        List<EmployeeBean> employeeBeans = new ArrayList<>();
        for(Employee employee : employeeList) {
            EmployeeBean employeeBean = new EmployeeBean();
            employeeBean.setId(employee.getId());
            employeeBean.setName(employee.getName());
            employeeBean.setRole(employee.getRole());
            employeeBeans.add(employeeBean);
        }
        return employeeBeans;
    }

}
