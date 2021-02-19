package com.SDA.company.service;

import com.SDA.company.models.Employee;
import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> createAll(List<Employee> employees);

    Employee getEmployee(Employee employee);

    List<Employee> getAllEmploies ();

    Employee updateEmploye(Employee employee);

    Employee deleteEmployee(Employee employee);


}
