package com.project.reviewms.Review.service;


import com.project.reviewms.Review.dto.ReviewRequestDto;
import com.project.reviewms.Review.dto.ReviewResponseDto;
import com.project.reviewms.Review.entity.Review;

import java.util.List;
import java.util.Optional;


public interface ReviewService {

    public List<ReviewResponseDto> getAllReview(Long companyId);


    public ReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto, Long companyId);

    public Optional<Review> getReviewById(Long id);

    public boolean updateReviewById(Review review, Long id);

    public boolean deletedReviewWithId(Long id);
}
