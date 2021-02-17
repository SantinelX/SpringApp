package com.SDA.company.controller;

import com.SDA.company.component.CustomFaker;
import com.SDA.company.models.Company;
import com.SDA.company.models.Employee;
import com.SDA.company.service.CompanyService;
import com.SDA.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

//    @Autowired
//    private CustomFaker customFaker;

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Company>>getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/populate")
    public ResponseEntity<String> populateDB(){
        CustomFaker customFaker = new CustomFaker();
        int numberOfCompanies = companyService.createAll(customFaker.autogenerateCompanyList()).size();
        return ResponseEntity.ok("The list has been populated with " +  numberOfCompanies + " companies.");
    }

    @GetMapping("/getSorted")
    public ResponseEntity<List<Company>>getSorted(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
        return ResponseEntity.ok(companyService.getSorted(pageNumber, pageSize, sortBy));
    }




}
