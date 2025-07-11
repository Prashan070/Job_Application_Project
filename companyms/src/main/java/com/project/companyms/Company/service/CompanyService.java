package com.project.companyms.Company.service;



import com.project.companyms.Company.dto.CompanyRequestDto;
import com.project.companyms.Company.dto.CompanyResponseDto;

import java.util.List;

public interface CompanyService {

    public List<CompanyResponseDto> getAllCompany();

    public CompanyResponseDto updateCompanyById (CompanyRequestDto companyRequestDto, Long id);

    public CompanyResponseDto saveCompany(CompanyRequestDto companyRequestDto);

    public String deleteCompanyById(Long id);

    public CompanyResponseDto getCompanyById(Long id);
}
