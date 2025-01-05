package com.jobportal.jobapplication.Company.service;

import com.jobportal.jobapplication.Company.entity.Company;
import com.jobportal.jobapplication.Company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompanyById(Company company, Long id) {
        Optional<Company> updateCompany = companyRepository.findById(id);

        if (updateCompany.isPresent()) {
            Company existingCompany = updateCompany.get();
            existingCompany.setDescription(company.getDescription());
            existingCompany.setName(company.getName());
            existingCompany.setJobs(company.getJobs());
            companyRepository.save(existingCompany);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean saveCompany(Company company) {
         companyRepository.save(company);
         return true;
    }
}
