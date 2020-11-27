package com.quiz.anime.animequiz.controller;

import com.quiz.anime.animequiz.models.QuizScore;
import com.quiz.anime.animequiz.models.User;
import com.quiz.anime.animequiz.repository.AddUserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.*;


import java.util.HashSet;
import java.util.Set;

@Controller
public class indexController {
    private AddUserRepo addUserRepo;
    private Set<QuizScore> quizScores = new HashSet<>();

    public indexController(AddUserRepo addUserRepo) {
        this.addUserRepo = addUserRepo;
    }

    public Set<QuizScore> getQuizScores() {
        return quizScores;
    }

    public void setQuizScores(Set<QuizScore> quizScores) {
        this.quizScores = quizScores;
    }

    @RequestMapping("/Home")
    public String getIndexPage(Model model){
        return "index";
    }

    @RequestMapping("/")
    public String errorPage(Model model){
        model.addAttribute("user",new User());
        QuizScore quizScore = new QuizScore();
        quizScore.setScore(1);
        getQuizScores().add(quizScore);
        User user = new User("Ace","emmyodia@gmail.com","Dinesh");
//        addUserRepo.save(user);
        return "signInUp";

    }

    @PostMapping("/")
    public String greetingSubmit(@Valid @ModelAttribute User user, Model model, BindingResult bindingResult) {
        System.out.println(user);
        if(bindingResult.hasErrors()){
            return "signInUp";
        }
        model.addAttribute("user", user);
        addUserRepo.save(user);
        return "redirect:/Home";
    }

}
