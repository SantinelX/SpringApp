package com.SDA.company.component;

import com.SDA.company.models.Company;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class CustomFaker {
    public List<Company> autogenerateCompanyList(){
        Faker faker = new Faker();
        List<Company> companyList = new ArrayList<>();

        for(int i = 0; i<300; i++){
         Company company =new Company();
         company.setName(faker.company().name());
         company.setAddress(faker.address().fullAddress());
         company.setEmail(faker.bothify("?????##@yahoo.com"));
         company.setPhoneNumber(faker.phoneNumber().cellPhone());
         company.setRegistrationNumber(faker.number().randomNumber(8,true));

         companyList.add(company);
        }
        return companyList;
    }
}
