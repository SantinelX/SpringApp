package com.SDA.company.repository;

import com.SDA.company.models.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
}
