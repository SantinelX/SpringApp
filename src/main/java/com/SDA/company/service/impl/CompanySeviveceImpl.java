package com.SDA.company.service.impl;

import com.SDA.company.models.Company;
import com.SDA.company.repository.CompanyRepository;
import com.SDA.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public List<Company> createAll(List<Company> companies) {
        return (List<Company>) companyRepository.saveAll(companies);
    }

    @Override
    public List<Company> getSorted(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Company> pageResult = companyRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @Override
    public Company deleteCompany (Company company){
       companyRepository.delete(company);
       return null;
    }


}
