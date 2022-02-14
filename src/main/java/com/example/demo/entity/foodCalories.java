package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "food_calories")
public class foodCalories extends BaseEntity{

    // 식품코드 (pk)
    // 식품이름
    // 총내용량
    // 열량(kcal)(1회제공량당)


