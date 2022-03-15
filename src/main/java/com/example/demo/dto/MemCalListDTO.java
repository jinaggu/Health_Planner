package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemCalListDTO {

    private Long idx;

    private String mid;

    private String food_cd;

    private String food_nm;

    private String calories;

    private String meal_type;

}
