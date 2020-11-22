package com.quiz.anime.animequiz.controller;

import com.quiz.anime.animequiz.models.ParentResult;
import com.quiz.anime.animequiz.service.ApiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class indexController {
    private ApiService apiService;

    public indexController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public String getIndexPage(Model model){

        return "index";
    }

    @RequestMapping("/quiz")
    public String errorPage(Model model){

        return "quiz";

    }

    @RequestMapping("/signup")
    public String signUpOrIn(Model model){
        return "signInUp";
    }
}
