package com.project.companyms.Company.controller;


import com.project.companyms.Company.dto.CompanyRequestDto;
import com.project.companyms.Company.dto.CompanyResponseDto;
import com.project.companyms.Company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {



    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponseDto>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CompanyResponseDto> saveCompany(@RequestBody CompanyRequestDto companyRequestDto) {
        return new ResponseEntity<>(companyService.saveCompany(companyRequestDto), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable("id") Long id) {
      return   new ResponseEntity<>(companyService.deleteCompanyById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDto> getCompanyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyResponseDto> updateCompanyById(@RequestBody CompanyRequestDto companyRequestDto, @PathVariable("id") Long id) {
      return new ResponseEntity<>(companyService.updateCompanyById(companyRequestDto,id),HttpStatus.OK);
    }

}
