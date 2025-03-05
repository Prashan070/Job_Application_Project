package com.jobportal.jobapplication.Company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.jobapplication.Job.entity.Job;
import com.jobportal.jobapplication.Review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

   @OneToMany(mappedBy = "company")
   private List<Review> reviews;


}
