package com.SDA.company.controller;

import com.SDA.company.component.CustomFaker;
import com.SDA.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/populate")
    public ResponseEntity<String> populateDB() {
        CustomFaker customFaker = new CustomFaker();
        int numberOfEmploies = employeeService.createAll(customFaker.autogenerateEmployeList()).size();
        return ResponseEntity.ok("The list has been populated with " + numberOfEmploies + " emploies.");
    }
}
