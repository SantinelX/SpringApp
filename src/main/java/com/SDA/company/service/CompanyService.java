package com.SDA.company.service;

import com.SDA.company.models.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);

    List<Company> getAllCompanies();
}
