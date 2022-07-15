package com.example.day3assigngreetingappdevelopment.repository;

import com.example.day3assigngreetingappdevelopment.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting,Integer> {
}
