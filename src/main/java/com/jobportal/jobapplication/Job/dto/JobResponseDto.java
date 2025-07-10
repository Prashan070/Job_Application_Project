package com.jobportal.jobapplication.Job.dto;

import com.jobportal.jobapplication.Company.dto.CompanyResponseDto;
import com.jobportal.jobapplication.Company.entity.Company;
import lombok.Data;

@Data
public class JobResponseDto {
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private double minSalary;
    private double maxSalary;
    private String jobApplication;
    private Company company;

}
