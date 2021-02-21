package com.SDA.company.service.impl;

import com.SDA.company.exception.CompanyNotFoundException;
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
import java.util.Optional;

@Service
public class CompanySeviveceImpl implements CompanyService {


    @Autowired
    private CompanyRepository companyRepository; // field injection -> NOT RECOMMENDED !!!

    @Override
    public Company createCompany(Company company, String userName) {
        company.setCreatedBy(userName);
        company.getCreatedAt();
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

    @Override
    public Company findCompanyById(Integer id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElseThrow(()->new CompanyNotFoundException("Company with Id: " + id + " dose not exists."));
    }
}
