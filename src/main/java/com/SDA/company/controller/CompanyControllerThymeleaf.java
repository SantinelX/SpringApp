package com.SDA.company.controller;

import com.SDA.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CompanyControllerThymeleaf {

    private final CompanyService companyService;

    @Autowired
    public CompanyControllerThymeleaf(CompanyService companyService) {
        this.companyService = companyService;
    }
}
