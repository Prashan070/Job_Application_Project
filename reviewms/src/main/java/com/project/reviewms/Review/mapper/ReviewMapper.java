package com.project.reviewms.Review.mapper;


import com.project.reviewms.Review.dto.ReviewRequestDto;
import com.project.reviewms.Review.dto.ReviewResponseDto;
import com.project.reviewms.Review.entity.Review;

public class ReviewMapper {
    public static Review mapReviewRequestDtoToEntity(ReviewRequestDto reviewRequestDto) {
        Review review = new Review();
        review.setTitle(reviewRequestDto.getTitle());
        review.setRating(reviewRequestDto.getRating());
        review.setDescription(reviewRequestDto.getDescription());
        review.setCompanyId(reviewRequestDto.getCompanyId());
        return review;
    }

    public static ReviewResponseDto mapEntityToReviewRequestDto(Review review) {
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setTitle(review.getTitle());
        reviewResponseDto.setRating(review.getRating());
        reviewResponseDto.setDescription(review.getDescription());
        reviewResponseDto.setCompanyId(review.getCompanyId());
        reviewResponseDto.setId(review.getId());
        return reviewResponseDto;
    }
}
