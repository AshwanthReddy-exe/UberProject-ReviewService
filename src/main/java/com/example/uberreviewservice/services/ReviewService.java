package com.example.uberreviewservice.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;

@Service
public class ReviewService implements CommandLineRunner {

  private ReviewRepository reviewRepository;
  private BookingRepository bookingRepository;

  public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
    this.reviewRepository = reviewRepository;
    this.bookingRepository = bookingRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("********");

    Review r = Review
        .builder()
        .content("Amazing ride")
        .rating(5.0)
        .build();

    Booking b = Booking.builder()
        .endTime(LocalDateTime.now())
        .review(r)
        .build();

    System.out.println(r);
    // reviewRepository.save(r); // sql query here comes
    bookingRepository.save(b);
    System.out.println(r.getId());
    List<Review> reviews = reviewRepository.findAll();

    for (Review review : reviews) {
      System.out.println(review.getContent());
    }

    Optional<Booking> b2 = bookingRepository.findById(5L);
    System.out.println(b2);
    if (b2.isPresent()) {
      bookingRepository.delete(b2.get());
    }
    // reviewRepository.deleteById(3L);
  }
}
