package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO { // dto는 화면에 뿌려줄때 필요

    private String mid;

    private String pw;

    private String name;

    private String email;

    private String like_food;

    private long m_grade;

    private String dagim_message;

    private String dagim_yn;

    private LocalDateTime regDate, modDate;

}
