package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.controller.ReviewController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.nxttrendz1.service.ReviewJpaService;
import com.example.nxttrendz1.model.Review;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewJpaService RJS;

    @GetMapping("/products/reviews")
    public ArrayList<Review> getMethod() {
        return RJS.getAllReviews();
    }

    @GetMapping("/products/reviews/{reviewId}")

    public Review getMethodById(@PathVariable("reviewId") int reviewId) {
        return RJS.getAllReviewsById(reviewId);
    }

    @PostMapping("/products/reviews")
    public Review PostMethod(@RequestBody Review Review) {
        return RJS.createReview(Review);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review putMethod(@PathVariable("reviewId") int reviewId, @RequestBody Review review) {
        return RJS.UpdateReview(reviewId, review);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void DeleteMethod(@PathVariable("reviewId") int reviewId) {
        RJS.DeleteReview(reviewId);
    }

    @GetMapping("/products/reviews/{reviewId}")
    public Product getReviewProduct(@PathVariable("reviewId") int reviewId){
        return RJS.getReviewProduct(reviewId);
    }

}