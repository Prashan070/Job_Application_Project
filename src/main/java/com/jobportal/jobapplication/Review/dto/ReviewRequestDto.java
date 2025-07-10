package com.jobportal.jobapplication.Review.dto;

import com.jobportal.jobapplication.Company.entity.Company;
import lombok.Data;

@Data
public class ReviewRequestDto {


    private String title;
    private String description;
    private double rating;
    private Company company;

}
