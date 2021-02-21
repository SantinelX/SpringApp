package com.SDA.company.service.impl;

import com.SDA.company.models.Employee;
import com.SDA.company.repository.EmployeeRepository;
import com.SDA.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> createAll(List<Employee> employees){
        return (List<Employee>) employeeRepository.saveAll(employees);
    }

    @Override
    public Employee getEmployee(Employee employee){ //<-needs implementation.
        return null;
    }

    @Override
    public List<Employee> getAllEmploies (){
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee updateEmploye(Employee employee){ //<-needs implementation.
        return null;
    }

    @Override
    public Employee deleteEmployee(Employee employee) {
         employeeRepository.delete(employee);
         return null;
    }

}
