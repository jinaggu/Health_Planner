package com.example.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
public class mainController {

    @RequestMapping(value="/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String mainPage(HttpServletRequest req, Model model) {
        log.info("mainPage......");

        Object mid = req.getSession().getAttribute("mid");
        log.info("mid : " + mid);

        model.addAttribute("mid", mid);

        return "/main";
    }

}
