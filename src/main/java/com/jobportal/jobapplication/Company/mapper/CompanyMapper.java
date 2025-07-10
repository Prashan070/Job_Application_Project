package com.jobportal.jobapplication.Company.mapper;

import com.jobportal.jobapplication.Company.dto.CompanyRequestDto;
import com.jobportal.jobapplication.Company.dto.CompanyResponseDto;
import com.jobportal.jobapplication.Company.entity.Company;

public class CompanyMapper {

    public static Company mapCompanyRequestDtoToEntity(CompanyRequestDto companyRequestDto) {
        Company company = new Company();
        company.setName(companyRequestDto.getName());
        company.setDescription(companyRequestDto.getDescription());
        return company;
    }

    public static CompanyResponseDto mapEntityToCompanyRequestDto(Company company) {
        CompanyResponseDto companyResponseDto = new CompanyResponseDto();
        companyResponseDto.setId(company.getId());
        companyResponseDto.setCompany_name(company.getName());
        companyResponseDto.setDescription(company.getDescription());
        return companyResponseDto;
    }

    public static Company mapCompanyResponseDtoToEntity(CompanyResponseDto dto) {
        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getCompany_name());
        company.setDescription(dto.getDescription());
        return company;
    }

}
