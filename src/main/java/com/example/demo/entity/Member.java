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

}
