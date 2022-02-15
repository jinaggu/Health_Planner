package com.example.demo.service;

import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.entity.FoodCalories;

import java.util.List;

public interface FoodCaloriesService {

    List<FoodCaloriesDTO> getListOfCalories(String FoodName);

    default FoodCaloriesDTO entitiesToDTO(FoodCalories foodCalories) {
        FoodCaloriesDTO foodCaloriesDTO = FoodCaloriesDTO.builder()
                .FOOD_CD(foodCalories.getFOOD_CD())
                .FOOD_NM(foodCalories.getFOOD_NM())
                .NUTR_CONT1(foodCalories.getNUTR_CONT1())
                .NUTR_CONT2(foodCalories.getNUTR_CONT2())
                .NUTR_CONT3(foodCalories.getNUTR_CONT3())
                .NUTR_CONT4(foodCalories.getNUTR_CONT4())
                .NUTR_CONT5(foodCalories.getNUTR_CONT5())
                .NUTR_CONT6(foodCalories.getNUTR_CONT6())
                .NUTR_CONT7(foodCalories.getNUTR_CONT7())
                .NUTR_CONT8(foodCalories.getNUTR_CONT8())
                .NUTR_CONT9(foodCalories.getNUTR_CONT9())
                .build();
        return foodCaloriesDTO;
    }

    default FoodCalories dtoToEntities(FoodCaloriesDTO foodCaloriesDTO) {
        FoodCalories foodCalories = FoodCalories.builder()
                .FOOD_CD(foodCaloriesDTO.getFOOD_CD())
                .FOOD_NM(foodCaloriesDTO.getFOOD_NM())
                .NUTR_CONT1(foodCaloriesDTO.getNUTR_CONT1())
                .NUTR_CONT2(foodCaloriesDTO.getNUTR_CONT2())
                .NUTR_CONT3(foodCaloriesDTO.getNUTR_CONT3())
                .NUTR_CONT4(foodCaloriesDTO.getNUTR_CONT4())
                .NUTR_CONT5(foodCaloriesDTO.getNUTR_CONT5())
                .NUTR_CONT6(foodCaloriesDTO.getNUTR_CONT6())
                .NUTR_CONT7(foodCaloriesDTO.getNUTR_CONT7())
                .NUTR_CONT8(foodCaloriesDTO.getNUTR_CONT8())
                .NUTR_CONT9(foodCaloriesDTO.getNUTR_CONT9())
                .build();

        return foodCalories;
    }

}
