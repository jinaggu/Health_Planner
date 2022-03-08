package com.example.demo.repository;

import com.example.demo.entity.FoodCalories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodCaloriesRepository extends JpaRepository<FoodCalories, String> {

    @Query(value = "SELECT * FROM food_calories f WHERE f.food_nm LIKE %:FoodName%", nativeQuery = true)
    List<FoodCalories> getFoodCalories(@Param("FoodName") String FoodName);

}
