package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor // final , @notnull 인것에대해서 자동으로 생성자 만들어줌.
public class memberController {

    private final MemberService memberService;

    @GetMapping("/signupPage")
    public void signupPage() {
        log.info("signUp...............");
    }

    @GetMapping("/signupSuccess")
    public void signupSuccess() {
        log.info("signupSuccess...............");
    }

    @GetMapping("/loginPage")
    public void login() {
        log.info("loginPage...............");
    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO, Model model) {
        log.info("signup.....");
        String mid = memberService.setMember(memberDTO);
        model.addAttribute("mid", mid);

        return "/member/signupSuccess";
    }

}
