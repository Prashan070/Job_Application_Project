package com.jobportal.jobapplication.Company.service;

import com.jobportal.jobapplication.Company.dto.CompanyRequestDto;
import com.jobportal.jobapplication.Company.dto.CompanyResponseDto;
import com.jobportal.jobapplication.Company.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    public List<CompanyResponseDto> getAllCompany();

    public CompanyResponseDto updateCompanyById (CompanyRequestDto companyRequestDto, Long id);

    public CompanyResponseDto saveCompany(CompanyRequestDto companyRequestDto);

    public String deleteCompanyById(Long id);

    public CompanyResponseDto getCompanyById(Long id);
}
