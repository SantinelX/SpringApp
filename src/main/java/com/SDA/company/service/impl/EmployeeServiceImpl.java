package com.SDA.company.service.impl;

import com.SDA.company.models.Company;
import com.SDA.company.models.Employee;
import com.SDA.company.repository.EmployeeRepository;
import com.SDA.company.service.CompanyService;
import com.SDA.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee){ //<-needs implementation.
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> createAll(List<Employee> employees){ //<-needs implementation.
        return (List<Employee>) employeeRepository.saveAll(employees);
    }

    @Override
    public Employee getEmployee(Employee employee){ //<-needs implementation.

        return null;
    }

    @Override
    public List<Employee> getAllEmploies (){ //<-needs implementation.
        return null;
    }

    @Override
    public Employee updateEmploye(Employee employee){ //<-needs implementation.
        return null;
    }

    @Override
    public void deleteEmployee(Employee employee) { //<-needs implementation.
         employeeRepository.delete(employee);
    }

}
