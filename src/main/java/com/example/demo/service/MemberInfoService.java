package com.example.demo.service;

import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.entity.MemberInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface MemberInfoService {

    String setMemberInfo(MemberInfoDTO memberInfoDTO);

    MemberInfoDTO getMemberInfo(String mid);

    void updateMemberInfo(MemberInfoDTO memberInfoDTO);

    default MemberInfoDTO entitiesToDTO(MemberInfo memberInfo) {
        MemberInfoDTO memberInfoDTO = MemberInfoDTO.builder()
                                        .mid(memberInfo.getMid())
                                        .gender(memberInfo.getGender())
                                        .start_diet_ym(memberInfo.getStart_diet_ym())
                                        .height(memberInfo.getHeight())
                                        .weight(memberInfo.getWeight())
                                        .bmi(memberInfo.getBmi())
                                        .date_of_birth(memberInfo.getDate_of_birth())
                                        .target_weight(memberInfo.getTarget_weight())
                                        .bmr(memberInfo.getBmr())
                                        .build();
        return memberInfoDTO;

    }

    default Map<String, Object> dtoToEntity(MemberInfoDTO memberInfoDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        MemberInfo memberInfo = MemberInfo.builder()
                                    .mid(memberInfoDTO.getMid())
                                    .gender(memberInfoDTO.getGender())
                                    .start_diet_ym(memberInfoDTO.getStart_diet_ym())
                                    .height(memberInfoDTO.getHeight())
                                    .weight(memberInfoDTO.getWeight())
                                    .bmi(memberInfoDTO.getBmi())
                                    .date_of_birth(memberInfoDTO.getDate_of_birth())
                                    .target_weight(memberInfoDTO.getTarget_weight())
                                    .bmr(memberInfoDTO.getBmr())
                                    .build();

        entityMap.put("memberInfo", memberInfo);

        return entityMap;
    }

}
