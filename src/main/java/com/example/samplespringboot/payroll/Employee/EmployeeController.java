package com.example.samplespringboot.payroll.Employee;

//import com.example.samplespringboot.kafka.services.KafkaProducerService;

import com.example.samplespringboot.kafka.services.KafkaProducerService;
import com.example.samplespringboot.payroll.beans.EmployeeBean;
import com.example.samplespringboot.payroll.entities.Employee;
import com.example.samplespringboot.payroll.services.PayrollService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class EmployeeController {

    @Autowired
    PayrollService payrollService;

    @Autowired
    KafkaProducerService producerService;

    @GetMapping("/employees")
    List<EmployeeBean> all() {
        List<EmployeeBean> employeeBeans = payrollService.getEmployeeList();
//        this.producerService.sendMessage("Hello");
//        this.producerService.sendMessage("Hello_How are you");
        return employeeBeans;
    }

    @GetMapping("/employee/{id}")
    CompletableFuture<EmployeeBean> findUser(@PathVariable Integer id) throws InterruptedException {
        CompletableFuture<EmployeeBean> employeeBean =  payrollService.findUser(id);
        return employeeBean;
    }

    @PostMapping(value = "/employee", consumes="application/json", produces = "application/json")
    public EmployeeBean saveEmployee(@RequestBody Employee employee) {
        EmployeeBean empBean = payrollService.saveEmployee(employee);
        return empBean;
    }
//
//    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
//    public UserPojo login(@RequestBody UserBean user) {
//        return user.loginUser(user);
//    }


}
