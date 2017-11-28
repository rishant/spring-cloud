package com.spring.cloud.service.impl;

import com.spring.cloud.model.Employee;
import com.spring.cloud.service.EmployeeService;
import org.springframework.stereotype.Component;

/**
 * Created by rgupta on 11/28/2017.
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee getEmployee() {
        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);
        return emp;
    }
}
