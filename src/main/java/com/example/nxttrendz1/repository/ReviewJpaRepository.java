package com.example.nxttrendz1.repository;

import com.example.nxttrendz1.repository.ReviewJpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nxttrendz1.model.Review;

public interface ReviewJpaRepository extends JpaRepository<Review, Integer> {

}