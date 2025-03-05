package com.jobportal.jobapplication.Review.service;

import com.jobportal.jobapplication.Review.entity.Review;
import com.jobportal.jobapplication.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReview(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean saveReview(Review review, Long companyId) {
        return false;
    }

   // @Override
   // public boolean saveReview(Review review) {
    //    reviewRepository.save(review);
     //   return true;
   // }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public boolean updateReviewById(Review review, Long id) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review updatedReview = existingReview.get();
            updatedReview.setDescription(review.getDescription());
            updatedReview.setTitle(review.getTitle());
            updatedReview.setRating(review.getRating());
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletedReviewWithId(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
