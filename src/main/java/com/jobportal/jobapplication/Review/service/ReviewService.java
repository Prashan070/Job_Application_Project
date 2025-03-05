package com.jobportal.jobapplication.Review.service;

import com.jobportal.jobapplication.Review.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ReviewService {

    public  List<Review> getAllReview(Long companyId);


    public boolean saveReview(Review review, Long companyId);

    public Optional<Review> getReviewById(Long id);

    public boolean updateReviewById(Review review, Long id);

     public boolean deletedReviewWithId(Long id);
}
