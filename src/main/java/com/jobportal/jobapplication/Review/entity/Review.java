package com.jobportal.jobapplication.Review.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobportal.jobapplication.Company.entity.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;


}
