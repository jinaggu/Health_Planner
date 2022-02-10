package com.example.demo.service;

import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.entity.MemberInfo;
import com.example.demo.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberInfoServiceImpl implements MemberInfoService{

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public void setMemberInfo(MemberInfoDTO memberInfoDTO) {
        Map<String, Object> entityMap = dtoToEntity(memberInfoDTO);
        MemberInfo memberInfo = (MemberInfo) entityMap.get("memberInfo");

        memberInfoRepository.save(memberInfo);
    }
}
