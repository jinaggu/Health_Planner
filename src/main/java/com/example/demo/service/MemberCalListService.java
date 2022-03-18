package com.example.demo.service;

import com.example.demo.dto.MemCalListDTO;
import com.example.demo.entity.MemberCalList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MemberCalListService {

    void setMemCalList(List<Map<String, Object>> memCalList);
    List<MemCalListDTO> getMemberCalList(String mid,String mealType);

    default MemCalListDTO entitiesToDTO(MemberCalList memberCalList) {
        MemCalListDTO memCalListDTO = MemCalListDTO.builder()
                .idx(memberCalList.getIdx())
                .mid(memberCalList.getMid())
                .foodCd(memberCalList.getFoodCd())
                .foodNm(memberCalList.getFoodNm())
                .calories(memberCalList.getCalorie())
                .mealType(memberCalList.getMealType())
                .build();
        return memCalListDTO;
    }

    default Map<String, Object> dtoToEntity(MemCalListDTO memCalListDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        MemberCalList memberCalList = MemberCalList.builder()
                .mid(memCalListDTO.getMid())
                .foodCd(memCalListDTO.getFoodCd())
                .foodNm(memCalListDTO.getFoodNm())
                .calorie(memCalListDTO.getCalories())
                .mealType(memCalListDTO.getMealType())
                .build();
        entityMap.put("memCalList", memberCalList);

        return entityMap;
    }

}
