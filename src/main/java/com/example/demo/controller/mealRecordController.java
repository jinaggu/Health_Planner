package com.example.demo.controller;

import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mealRecord")
@Log4j2
@RequiredArgsConstructor
public class mealRecordController {

    private final MemberInfoService memberInfoService;

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
    @PostMapping("/memberInfoSave")
    public void memberInfoSave(MemberInfoDTO memberInfoDTO) {
        log.info("memberInfoSave...........");

        memberInfoService.setMemberInfo(memberInfoDTO);
    }


}
