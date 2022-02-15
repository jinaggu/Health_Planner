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
@Table(name = "food_calories")
public class FoodCalories extends BaseEntity {

    @Id
    private String FOOD_CD;// 식품코드 (pk)
    private String FOOD_NM; // 식품이름
    private String SERVING_SIZE; // 총내용량
    private String NUTR_CONT1; // 열량(kcal)(1회제공량당)
    private String NUTR_CONT2; // 탄수화물(g)(1회제공량당)
    private String NUTR_CONT3; // 단백질(g)(1회제공량당)
    private String NUTR_CONT4; // 지방(g)(1회제공량당)
    private String NUTR_CONT5; // 당류(g)(1회제공량당)
    private String NUTR_CONT6; // 나트륨(mg)(1회제공량당)
    private String NUTR_CONT7; // 콜레스테롤(mg)(1회제공량당)
    private String NUTR_CONT8; // 포화지방산(g)(1회제공량당)
    private String NUTR_CONT9; // 트랜스지방(g)(1회제공량당)

}


