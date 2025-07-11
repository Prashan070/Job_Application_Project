package com.project.companyms.Company.service;


import com.project.companyms.Company.dto.CompanyRequestDto;
import com.project.companyms.Company.dto.CompanyResponseDto;
import com.project.companyms.Company.entity.Company;
import com.project.companyms.Company.mapper.CompanyMapper;
import com.project.companyms.Company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyResponseDto> getAllCompany() {
        return companyRepository.findAll().stream().map(CompanyMapper::mapEntityToCompanyRequestDto).toList();
    }

    @Override
    public CompanyResponseDto saveCompany(CompanyRequestDto companyRequestDto) {
        Company company = CompanyMapper.mapCompanyRequestDtoToEntity(companyRequestDto);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapEntityToCompanyRequestDto(savedCompany);
    }

    @Override
    public String deleteCompanyById(Long id) {
        companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not available"));
        companyRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public CompanyResponseDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not available"));
        return CompanyMapper.mapEntityToCompanyRequestDto(company);
    }


    @Override
    public CompanyResponseDto updateCompanyById(CompanyRequestDto companyRequestDto, Long id) {
        Company savedCompany = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not available"));
        Company company = CompanyMapper.mapCompanyRequestDtoToEntity(companyRequestDto);
        savedCompany.setId(company.getId());
        savedCompany.setName(company.getName());
        savedCompany.setDescription(company.getName());
        Company updatedCompany = companyRepository.save(savedCompany);
        return CompanyMapper.mapEntityToCompanyRequestDto(updatedCompany);
    }
}
