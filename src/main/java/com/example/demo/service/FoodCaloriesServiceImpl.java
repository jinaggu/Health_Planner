package com.example.demo.service;

import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.entity.FoodCalories;
import com.example.demo.entity.MemberInfo;
import com.example.demo.repository.FoodCaloriesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class FoodCaloriesServiceImpl implements FoodCaloriesService{
    private final FoodCaloriesRepository foodCaloriesRepository;

    @Override
    public List<FoodCaloriesDTO> getListOfCalories(String FoodName) {
        log.info(FoodName);
        List<FoodCalories> result = foodCaloriesRepository.getFoodCalories(FoodName);

        //List<FoodCalories> res = foodCaloriesRepository.findByFoodnameContaining()

        log.info(result);
        return result.stream().map(FoodCalories -> entitiesToDTO(FoodCalories)).collect(Collectors.toList());
    }
}
