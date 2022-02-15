package com.example.demo.repository;

import com.example.demo.entity.FoodCalories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCaloriesRepository extends JpaRepository<FoodCalories, String> {

}
