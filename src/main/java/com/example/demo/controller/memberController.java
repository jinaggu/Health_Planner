package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Log4j2
public class memberController {

    @GetMapping("/signUp")
    public void signUp() {
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

}
