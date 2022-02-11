package com.example.demo.service;

import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberInfo;
import com.example.demo.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberInfoServiceImpl implements MemberInfoService{

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public String setMemberInfo(MemberInfoDTO memberInfoDTO) {
        Map<String, Object> entityMap = dtoToEntity(memberInfoDTO);
        MemberInfo memberInfo = (MemberInfo) entityMap.get("memberInfo");

        memberInfoRepository.save(memberInfo);
        return memberInfo.getBmi();
    }

    @Override
    public MemberInfoDTO getMemberInfo(String mid) {
        Optional<MemberInfo> result = memberInfoRepository.findById(mid);
        if (result.isPresent()) {
            MemberInfo memberInfo = result.get();
            MemberInfoDTO memberInfoDTO = entitiesToDTO(memberInfo);
            return memberInfoDTO;
        } else {
            return null;
        }
    }

    @Override
    public void updateMemberInfo(MemberInfoDTO memberInfoDTO) {
        Optional<MemberInfo> result = memberInfoRepository.findById(memberInfoDTO.getMid());

        if(result.isPresent()) {
            MemberInfo memberInfo = result.get();
            memberInfo.changeDateOfBirth(memberInfoDTO.getDate_of_birth());
            memberInfo.changeHeight(memberInfoDTO.getHeight());
            memberInfo.changeWeight(memberInfoDTO.getWeight());
        }
    }

}
