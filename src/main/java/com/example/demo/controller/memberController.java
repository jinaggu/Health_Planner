package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public void loginPage() {
        log.info("loginPage...............");
    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO, Model model) {
        log.info("signup.....");
        String mid = memberService.setMember(memberDTO);
        model.addAttribute("mid", mid);

        log.info(mid);

        return "/member/signupSuccess";
    }

    @PostMapping("/login")
    public String login(MemberDTO memberDTO, HttpServletRequest req, RedirectAttributes rttr) {
        String mid = memberDTO.getMid();
        String pw = memberDTO.getPw(); // todo : pw 가리기, jwt로 로그인 구현
        MemberDTO member = memberService.getMember(mid, pw);
        log.info(member);
        if (member != null) {
            HttpSession session = req.getSession();
            session.setAttribute("mid", member.getMid());
            session.setAttribute("mName", member.getName());
            log.info("login ok...............");
            return "redirect:/main";
        } else {
            rttr.addFlashAttribute("loginMsg","empty");
            return "redirect:/member/loginPage";
        }
    }

    @GetMapping("/myPage")
    public String myPage(HttpServletRequest req, Model model) {
        Object mid = req.getSession().getAttribute("mid");
        Object mName = req.getSession().getAttribute("mName");
        log.info("mid : " + mid);

        model.addAttribute("mName", mName);
        return "/member/myPage";
    }

    @GetMapping("/myInfoPage")
    public String myInfo(HttpServletRequest req, Model model) {
        Object mid = req.getSession().getAttribute("mid");
        Object mName = req.getSession().getAttribute("mName");
        log.info("mid : " + mid);

        model.addAttribute("mName", mName);
        return "/member/myInfoPage";
    }

}
