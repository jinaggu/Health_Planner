package com.example.demo.controller;

import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.service.FoodCaloriesService;
import com.example.demo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mealRecord")
@Log4j2
@RequiredArgsConstructor
public class mealRecordController {

    private final MemberInfoService memberInfoService;
    private final FoodCaloriesService foodCaloriesService;

    @GetMapping("/mealRecordPage")
    public String mealRecordPage() {
        log.info("mealRecordPage...........");
        return "/mealRecord/mealRecordPage";
    }

    @GetMapping("/mealRecord")
    public String mealRecord() {
        log.info("mealRecord...........");
        return "/mealRecord/mealRecord";
    }

    @GetMapping("/caloriesDiagosis")
    public String caloriesDiagosis() {
        log.info("caloriesDiagosis...........");

        return "/mealRecord/caloriesDiagosis";
    }

    @ResponseBody
    @GetMapping("/memberInfoCheck")
    public MemberInfoDTO memberInfoCheck(HttpServletRequest req) {
        Object mid = req.getSession().getAttribute("mid");

        if (mid != null) {
            log.info("not null");
            MemberInfoDTO memberInfoDTO = memberInfoService.getMemberInfo(mid.toString());
            log.info(memberInfoDTO);
            return memberInfoDTO;
        } else {
            log.info("null");
            return null;
        }
    }

    @ResponseBody
    @PostMapping("/memberInfoSave")
    public String memberInfoSave(MemberInfoDTO memberInfoDTO) {
        log.info("memberInfoSave...........");
        log.info(memberInfoDTO.getBmi());

        String bmi = memberInfoService.setMemberInfo(memberInfoDTO);
        return bmi;
    }

    @ResponseBody
    @GetMapping("/getFoodCalorieInfo")
    public List<FoodCaloriesDTO> getFoodCalorieInfo(@RequestParam("foodName") String foodName) {
        log.info(foodName);
        List<FoodCaloriesDTO> foodCaloriesDTO = foodCaloriesService.getListOfCalories(foodName);
        log.info(foodCaloriesDTO);
        return foodCaloriesDTO;
    }


}
