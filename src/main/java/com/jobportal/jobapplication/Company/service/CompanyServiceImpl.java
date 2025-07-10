package com.jobportal.jobapplication.Company.service;

import com.jobportal.jobapplication.Company.dto.CompanyRequestDto;
import com.jobportal.jobapplication.Company.dto.CompanyResponseDto;
import com.jobportal.jobapplication.Company.entity.Company;
import com.jobportal.jobapplication.Company.mapper.CompanyMapper;
import com.jobportal.jobapplication.Company.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
