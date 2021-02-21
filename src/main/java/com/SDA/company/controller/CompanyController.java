package com.SDA.company.controller;

import com.SDA.company.component.CustomFaker;
import com.SDA.company.models.Company;
import com.SDA.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/company")
public class CompanyController{

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

//    @Autowired
//    private CustomFaker customFaker;

    @PostMapping("/create")
//    @RequestMapping(value = "/create", method = RequestMethod.POST) // <-metoda Clasica (veche)
    public ResponseEntity<Company> createCompany(@RequestBody Company company, Principal principal){
        return ResponseEntity.ok(companyService.createCompany(company,principal.getName()));
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

    @GetMapping("/getById")
    public ResponseEntity<Company> findById (@RequestParam Integer id){
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCompany(@RequestBody Company company){
        companyService.deleteCompany(company);
        return ResponseEntity.ok(company.getName() + " have been deleted.");
    }






}
