package com.SDA.company.controller;

import com.SDA.company.component.CustomFaker;
import com.SDA.company.models.Employee;
import com.SDA.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployes(){ // <- to be reevaluated.
        return ResponseEntity.ok(employeeService.getAllEmploies());
    }


    @GetMapping("/populate")
    public ResponseEntity<String> populateDB() {
        CustomFaker customFaker = new CustomFaker();
        int numberOfEmploies = employeeService.createAll(customFaker.autogenerateEmployeList()).size();
        return ResponseEntity.ok("The list has been populated with " + numberOfEmploies + " emploies.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployee(employee);
        return ResponseEntity.ok("The employe with ID: " + employee.getId() + " named: " + employee.getFirstname()
        + " was deleted.");
    }

}
