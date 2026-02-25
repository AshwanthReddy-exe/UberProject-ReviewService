package com.example.uberreviewservice.services;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;

@Service
public class ReviewService implements CommandLineRunner {

  private ReviewRepository reviewRepository;

  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("********");
    Review r = Review
        .builder()
        .content("Amazing ride")
        .rating(5.0)
        .build();
    System.out.println(r);
    reviewRepository.save(r); // sql query here comes
    System.out.println(r.getId());
    List<Review> reviews = reviewRepository.findAll();

    for (Review review : reviews) {
      System.out.println(review.getContent());
    }

    reviewRepository.deleteById(3L);
  }
}
