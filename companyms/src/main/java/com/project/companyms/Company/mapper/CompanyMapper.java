package com.project.companyms.Company.mapper;


import com.project.companyms.Company.dto.CompanyRequestDto;
import com.project.companyms.Company.dto.CompanyResponseDto;
import com.project.companyms.Company.entity.Company;

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



}
