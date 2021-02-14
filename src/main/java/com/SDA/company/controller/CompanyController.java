package com.SDA.company.controller;

import com.SDA.company.models.Company;
import com.SDA.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Company>>getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());git
    }


}
