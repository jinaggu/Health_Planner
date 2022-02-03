package com.example.demo.service;


import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public String setMember(MemberDTO memberDTO) {
        Map<String, Object> entityMap = dtoToEntity(memberDTO);
        Member member = (Member) entityMap.get("member");

        memberRepository.save(member);
        return member.getMid(); // 등록된 mid 반환
    }

    @Override
    public MemberDTO getMember(String mid, String pw) {
        Member member = memberRepository.findMember(mid, pw);
        log.info("serviceImple : " + member);
        if(member == null) {
            return null;
        } else {
            MemberDTO memberDTO = entitiesToDTO(member);
            return memberDTO;
        }
    }

    @Override
    public MemberDTO getMemberInfo(String mid) {
        Member member = memberRepository.findMemberInfo(mid);
        MemberDTO memberDTO = entitiesToDTO(member);
        return memberDTO;
    }
}
