package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

import java.util.HashMap;
import java.util.Map;

public interface MemberService {

    String setMember(MemberDTO memberDTO); // 회원가입 후 멤버등록

    MemberDTO getMember(String mid); // 로그인, 회원가입시 중복 id 방지조회 용도

    default MemberDTO entitiesToDTO(Member member) {

        MemberDTO memberDTO = MemberDTO.builder()
                                .mid(member.getMid())
                                .pw(member.getPw())
                                .name(member.getName())
                                .email(member.getEmail())
                                .like_food(member.getLike_food())
                                .m_grade(member.getM_grade())
                                .build();

        return memberDTO;
    }

    default Map<String, Object> dtoToEntity(MemberDTO memberDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        Member member = Member.builder()
                        .mid(memberDTO.getMid())
                        .pw(memberDTO.getPw())
                        .name(memberDTO.getName())
                        .email(memberDTO.getEmail())
                        .like_food(memberDTO.getLike_food())
                        .m_grade(memberDTO.getM_grade())
                        .build();

        entityMap.put("member", member);

        return entityMap;
    }

}
