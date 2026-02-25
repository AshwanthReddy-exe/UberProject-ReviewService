package com.example.uberreviewservice.models;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {

  private String name;

  @Column(nullable = false, unique = true)
  private String licenseNumber;

  @OneToMany(mappedBy = "driver")
  private List<Booking> bookings = new ArrayList<>();

}
