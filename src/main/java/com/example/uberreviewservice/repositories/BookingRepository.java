package com.example.uberreviewservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.uberreviewservice.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
