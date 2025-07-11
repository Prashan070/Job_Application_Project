package com.project.joms.Job.dto;


import lombok.Data;

@Data
public class JobRequestDto {



    private String jobTitle;
    private String jobDescription;
    private double minSalary;
    private double maxSalary;
    private String jobApplication;
    private Long companyId;


}
