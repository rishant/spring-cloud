package com.spring.cloud.controller;

import com.spring.cloud.model.Employee;
import com.spring.cloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rgupta on 11/28/2017.
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee firstPage() {
        return employeeService.getEmployee();
    }
}
