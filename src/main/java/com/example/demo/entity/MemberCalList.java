package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "mem_cal_list")
public class MemberCalList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx; // 인덱스

    @Column(name = "mid")
    private String mid; // 멤버 아이디

    @Column(name = "food_cd")
    private String foodCd; // 음식코드

    @Column(name = "food_nm")
    private String foodNm; // 음식이름

    @Column(name = "calorie")
    private String calorie; // 음식칼로리

    @Column(name = "meal_type")
    private String mealType; // 식사종류 - 아침,점심,저녁,간식

    // 아침 : M , 점심 : L , 저녁 : D , 간식 : S

}