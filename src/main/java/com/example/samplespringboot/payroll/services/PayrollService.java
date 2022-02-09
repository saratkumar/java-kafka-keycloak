package com.example.samplespringboot.payroll.services;

import com.example.samplespringboot.payroll.beans.UserBean;
import com.example.samplespringboot.payroll.beans.UserPojo;
import com.example.samplespringboot.payroll.entities.Employee;
import com.example.samplespringboot.payroll.Employee.EmployeeRepository;
import com.example.samplespringboot.payroll.beans.EmployeeBean;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
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

    @Async
    public CompletableFuture<EmployeeBean> findUser(Integer id) throws InterruptedException {
        Optional<Employee> employee = repository.findById(id);
        EmployeeBean employeeBean = null;
        if(employee.isPresent()) {
            employeeBean = new EmployeeBean();
            employeeBean.setId(employee.get().getId());
            employeeBean.setName(employee.get().getName());
            employeeBean.setName(employee.get().getRole());
        }
        Thread.sleep(5000L);
        return CompletableFuture.completedFuture(employeeBean);
    }

    public EmployeeBean saveEmployee(Employee employee) {
        if(employee.getName() == null || employee.getName() == "") {
            new RuntimeException("User name is avaialble");
        }
        Employee empResponse = new Employee();
        EmployeeBean employeeBean = null;
        empResponse = repository.save(employee);
        if(empResponse != null) {
            employeeBean = new EmployeeBean();
            employeeBean.setId(empResponse.getId());
            employeeBean.setName(empResponse.getName());
            employeeBean.setRole(empResponse.getRole());
        }
        return employeeBean;
    }

}
