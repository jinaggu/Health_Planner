package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "member_info")
public class MemberInfo extends BaseEntity{

    @Id
    private String mid; // 아이디

    private String gender; //

    private String date_of_birth; // 생년월일

    private String height; // 키

    private String weight; // 몸무게

    private String bmi; // bmi 수치

    private String target_weight; // 목표 체중

    private String start_diet_ym; // 다이어트 시작일

    private String bmr; // 기초대사량

    public void changeGender(String gender) { this.gender = gender; };
    public void changeDateOfBirth(String date_of_birth) { this.date_of_birth = date_of_birth; }
    public void changeHeight(String height) { this.height = height; }
    public void changeWeight(String weight) { this.weight = weight; }
    public void changeBmi(String bmi) { this.bmi = bmi; }
    public void changeTargetWeight(String target_weight) { this.target_weight = target_weight; }
    public void changeStartDietYm(String start_diet_ym) { this.start_diet_ym = start_diet_ym; }
    public void changeBmr(String bmr) { this.bmr = bmr; }

}
