package com.example.samplespringboot.payroll.Employee;

//import com.example.samplespringboot.kafka.services.KafkaProducerService;

import com.example.samplespringboot.kafka.services.KafkaProducerService;
import com.example.samplespringboot.payroll.beans.EmployeeBean;
import com.example.samplespringboot.payroll.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    PayrollService payrollService;

    @Autowired
    KafkaProducerService producerService;

    @GetMapping("/employees")
    List<EmployeeBean> all() {
        List<EmployeeBean> employeeBeans = payrollService.getEmployeeList();
        this.producerService.sendMessage("Hello");
        this.producerService.sendMessage("Hello_How are you");
        return employeeBeans;
    }
}
