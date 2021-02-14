package com.SDA.company.service.impl;

import com.SDA.company.models.Company;
import com.SDA.company.repository.CompanyRepository;
import com.SDA.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanySeviveceImpl implements CompanyService {


    @Autowired
    private CompanyRepository companyRepository; // field injection -> NOT RECOMMENDED !!!

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }
}
