package com.example.demo.service;

import com.example.demo.dto.MemCalListDTO;
import com.example.demo.entity.MemberCalList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MemberCalListService {

    void setMemCalList(List<Map<String, Object>> memCalList);

    default MemCalListDTO entitiesToDTO(MemberCalList memberCalList) {
        MemCalListDTO memCalListDTO = MemCalListDTO.builder()
                .mid(memberCalList.getMid())
                .food_cd(memberCalList.getFood_cd())
                .food_nm(memberCalList.getFood_nm())
                .calories(memberCalList.getCalorie())
                .meal_type(memberCalList.getMeal_type())
                .build();
        return memCalListDTO;
    }

    default Map<String, Object> dtoToEntity(MemCalListDTO memCalListDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        MemberCalList memberCalList = MemberCalList.builder()
                .mid(memCalListDTO.getMid())
                .food_cd(memCalListDTO.getFood_cd())
                .food_nm(memCalListDTO.getFood_nm())
                .calorie(memCalListDTO.getCalories())
                .meal_type(memCalListDTO.getMeal_type())
                .build();
        entityMap.put("memCalList", memberCalList);

        return entityMap;
    }

}
