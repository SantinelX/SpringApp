package com.SDA.company.controller;

import com.SDA.company.models.Company;
import com.SDA.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class CompanyControllerThymeleaf {

    private final CompanyService companyService;

    @Autowired
    public CompanyControllerThymeleaf(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllCompanies(Model model){
        List<Company> companyList = companyService.getAllCompanies();
        model.addAttribute("list",companyList);
        return "companyTable";
    }
}
