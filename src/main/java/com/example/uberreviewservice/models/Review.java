package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookingreview")
public class Review extends BaseModel {

  @Column(nullable = false)
  private String content;

  private Double rating;

  @Override
  public String toString() {
    return "Review: " + this.content + " " + this.rating + " ";
  }
}
