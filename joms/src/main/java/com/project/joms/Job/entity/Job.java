package com.project.joms.Job.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private double minSalary;

   @Positive
    private double maxSalary;

    private String jobApplication;
    private Long companyId;



}
