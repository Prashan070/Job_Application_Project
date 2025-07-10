package com.jobportal.jobapplication.Job.entity;


import com.jobportal.jobapplication.Company.entity.Company;
import jakarta.persistence.*;
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
    private double minSalary;

   @Positive
    private double maxSalary;

    private String jobApplication;


    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;



}
