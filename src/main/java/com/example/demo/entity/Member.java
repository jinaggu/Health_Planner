package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "member")
public class Member extends BaseEntity{

    @Id
    /*@GeneratedValue(strategy =  GenerationType.IDENTITY)*/
    private String mid; // 아이디

    private String pw; // 비밀번호

    private String name; // 이름

    private String email; // 이메일

    private String like_food; // 좋아하는 음식

    private long m_grade; // 회원등급

    private String dagim_message; // 다짐메세지

    private String dagim_yn; // 다짐메세지 비공개 여부

    public void changePw(String pw) {
        this.pw = pw;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changeLike_food(String like_food) {
        this.like_food = like_food;
    }

    public void changeGrade(int m_grade) {
        this.m_grade = m_grade;
    }

    public void changeDagim_message(String dagim_message) {
        this.dagim_message = dagim_message;
    }

    public void changeDagim_yn(String dagim_yn) {
        this.dagim_yn = dagim_yn;
    }

}
