package com.quiz.anime.animequiz.controller;

import com.quiz.anime.animequiz.models.ParentResult;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class indexController {

    @RequestMapping("/")
    public String getIndexPage(Model model){

        return "index";
    }

    @RequestMapping("/quiz")
    public String errorPage(Model model){
        final String uri = "https://opentdb.com/api.php?amount=10&category=31&type=multiple";

        RestTemplate restTemplate = new RestTemplate();
        ParentResult result = restTemplate.getForObject(uri, ParentResult.class);
        System.out.println(result.toString());
        return "quiz";

    }

    @RequestMapping("/signup")
    public String signUpOrIn(Model model){
        return "signInUp";
    }
}
