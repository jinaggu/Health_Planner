package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDTO {

    private String mid; // 아이디

    private String gender; //

    private String date_of_birth; // 생년월일

    private String height; // 키

    private String weight; // 몸무게

    private String bmi; // bmi 수치

    private String target_weight; // 목표 체중

    private String start_diet_ym; // 다이어트 시작일

    private String bmr; // 기초대사량

}
