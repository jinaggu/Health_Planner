package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

import java.util.HashMap;
import java.util.Map;

public interface MemberService {

    String setMember(MemberDTO memberDTO); // 회원가입 후 멤버등록

    MemberDTO getMember(String mid, String pw); // 로그인
    
    MemberDTO getMemberInfo(String mid); // 회원정보 조회

    void modifyMemberInfo(MemberDTO memberDTO); //회원정보 수정

    default MemberDTO entitiesToDTO(Member member) {

        MemberDTO memberDTO = MemberDTO.builder()
                                .mid(member.getMid())
                                .pw(member.getPw())
                                .name(member.getName())
                                .email(member.getEmail())
                                .like_food(member.getLike_food())
                                .m_grade(member.getM_grade())
                                .dagim_message(member.getDagim_message())
                                .dagim_yn(member.getDagim_yn())
                                .regDate(member.getRegDate())
                                .modDate(member.getModDate())
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
                        .dagim_message(memberDTO.getDagim_message())
                        .dagim_yn(memberDTO.getDagim_yn())
                        .build();

        entityMap.put("member", member);

        return entityMap;
    }

}
