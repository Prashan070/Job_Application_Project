package com.jobportal.jobapplication.Company.service;

import com.jobportal.jobapplication.Company.entity.Company;

import java.util.List;

public interface CompanyService {

    public List<Company> getAllCompany();

    public boolean updateCompanyById (Company company, Long id);

    public boolean saveCompany(Company company);
}
