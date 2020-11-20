package com.quiz.anime.animequiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String getIndexPage(Model model){

        return "index";
    }

    @RequestMapping("/quiz")
    public String errorPage(Model model){
        return "quiz";
    }
}
