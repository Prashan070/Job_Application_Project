package com.jobportal.jobapplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;


   @NotBlank(message = "Please Add Job Title")
    private String jobTitle;

   @Length(min = 0, max = 1000)
    private String jobDescription;

   @Positive
    private String minSalary;

   @Positive
    private String maxSalary;
    private String jobApplication;


}
