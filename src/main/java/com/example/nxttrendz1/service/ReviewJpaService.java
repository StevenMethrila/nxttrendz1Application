package com.example.nxttrendz1.service;

import com.example.nxttrendz1.service.ReviewJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ReviewJpaRepository;
import com.example.nxttrendz1.model.Review;

import com.example.nxttrendz1.repository.ProductJpaRepository;

import java.util.*;

public class ReviewJpaService implements ReviewRepository {

    @Autowired
    ReviewJpaRepository RJR;

    @Autowired
    ProductJpaRepository PJR;


    public ArrayList<Review> getAllReviews() {
        List<Review> l = RJR.findAll();
        ArrayList<Review> arr = new ArrayList<>(l);
        return arr;
    }

    public Review getAllReviewsById(int reviewId) {
        try {
            Review r = RJR.findById(reviewId).get();
            return r;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Review createReview(Review review) {
        Product product = review.getProduct();
        int productId = product.getProductId();
        try {
            product = PJR.findById(productId).get();
            review.setProduct();
            return RJR.save(review);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Review UpdateReview(int reviewId, Review review) {
        try {
            Review r = RJR.findById(reviewId).get();
            if (review.getReviewContent() != null) {
                r.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                r.setRating(review.getRating());
            }
            return RJR.save(r);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void DeleteReview(int reviewId) {
        try {
            RJR.deleteById(reviewId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}