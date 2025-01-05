package com.jobportal.jobapplication.Company.controller;

import com.jobportal.jobapplication.Company.entity.Company;
import com.jobportal.jobapplication.Company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@RequestBody Company company, @PathVariable("id") Long id) {
        boolean isUpdated = companyService.updateCompanyById(company, id);
        if (isUpdated) {
            return new ResponseEntity<>("Company has been updated", HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody Company company){
        boolean isSaved = companyService.saveCompany(company);
        if(isSaved){
            return new ResponseEntity<>("Company is saved", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
