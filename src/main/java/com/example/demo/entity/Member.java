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

    private String pw;

    private String name;

    private String email;

    private String like_food;

    private long m_grade;

    private String dagim_message;

    private String dagim_yn;

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
