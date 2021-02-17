package com.SDA.company.service;

import com.SDA.company.models.Company;

import java.util.List;

public interface CompanyService {

    Company createCompany(Company company);

    List<Company> getAllCompanies();

    List<Company> createAll(List<Company> companies);

    List<Company> getSorted(Integer pageNumber, Integer pageSize, String sortby);
}
