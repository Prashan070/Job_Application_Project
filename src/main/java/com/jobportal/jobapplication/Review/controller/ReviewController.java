package com.jobportal.jobapplication.Review.controller;

import com.jobportal.jobapplication.Review.dto.ReviewRequestDto;
import com.jobportal.jobapplication.Review.dto.ReviewResponseDto;
import com.jobportal.jobapplication.Review.entity.Review;
import com.jobportal.jobapplication.Review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewResponseDto>> getAllReview(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReview(companyId),HttpStatus.OK);
    }


    @PostMapping("/reviews")
    public ResponseEntity<ReviewResponseDto> saveReview(@RequestBody ReviewRequestDto reviewRequestDto, @PathVariable Long companyId) {
       return new ResponseEntity<>(reviewService.saveReview(reviewRequestDto,companyId),HttpStatus.OK);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long id) {
        Optional<Review> isReviewAvaiable = reviewService.getReviewById(id);
        if (isReviewAvaiable.isPresent()) {
            return new ResponseEntity<>(isReviewAvaiable.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> updateReviewById(@RequestBody Review review, @PathVariable Long id) {
        boolean isUpdated = reviewService.updateReviewById(review, id);
        if (isUpdated) {
            return new ResponseEntity<>("Review has been updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deletedReviewWithId(@PathVariable Long id) {
        boolean isDeleted = reviewService.deletedReviewWithId(id);
        if (isDeleted) {
            return new ResponseEntity<>("Review has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
