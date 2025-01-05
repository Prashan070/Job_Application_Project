package com.jobportal.jobapplication.Company.service;

import com.jobportal.jobapplication.Company.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    public List<Company> getAllCompany();

    public boolean updateCompanyById (Company company, Long id);

    public boolean saveCompany(Company company);

    public boolean deleteCompanyByid(Long id);

    public Optional<Company> getCompanyById(Long id);
}
