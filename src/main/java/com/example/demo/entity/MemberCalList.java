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
    private Long idx; // 인덱스

    private String mid; // 멤버 아이디

    private String food_cd; // 음식코드

    private String food_nm; // 음식이름

    private String calorie; // 음식칼로리

    private String meal_type; // 식사종류 - 아침,점심,저녁,간식

    // 아침 : M , 점심 : L , 저녁 : D , 간식 : S

}