package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.model.Product;

import com.example.nxttrendz1.model.Review;
import java.util.*;

public interface ReviewRepository {

    public ArrayList<Review> getAllReviews();

    public Review getAllReviewsById(int reviewId);

    public Review createReview(Review review);

    public Review UpdateReview(int reviewId, Review review);

    public void DeleteReview(int reviewId);
    
    public Product getReviewProduct(int reviewId);