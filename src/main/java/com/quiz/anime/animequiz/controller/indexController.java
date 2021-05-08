package com.quiz.anime.animequiz.controller;

import com.quiz.anime.animequiz.models.Login;
import com.quiz.anime.animequiz.models.QuizScore;
import com.quiz.anime.animequiz.models.User;
import com.quiz.anime.animequiz.repository.AddUserRepo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.*;


import java.util.*;

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


    @RequestMapping("/")
    public String errorPage(Model model){
        model.addAttribute("user",new User());
        return "signUp";

    }

    @PostMapping("/")
    public String greetingSubmit(@Valid @ModelAttribute User user, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "signUp";
        }else{
            Optional<User> userGotten = addUserRepo.findByUserName(user.getUserName());
            if(userGotten.isPresent()){
                System.out.println(true);
                model.addAttribute("userExist",new String("username Exists"));
                return "signUp";
            }else{
                addUserRepo.save(user);
                System.out.println(false);
                model.addAttribute("user", user);
                addUserRepo.save(user);
                return "redirect:/login";
            }
        }


    }

    @GetMapping("/login")
    public String loginGet(Model model){
        model.addAttribute("login",new Login());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute Login login, Model model, BindingResult bindingResult){
        Optional<User> userGotten = addUserRepo.findByUserName(login.getUserName());
        if(userGotten.isPresent()){
            if(userGotten.get().getPassword().equalsIgnoreCase(login.getPassword())){
                return "redirect:/home/"+login.getUserName();
            }
        }
            model.addAttribute("usernamedoesnotmatch",new String("username or password does not match"));
            return "login";

    }

    @GetMapping("/home/{user}")
    public String displayHomePage(@PathVariable String user, Model model){
        Optional<User> users = addUserRepo.findByUserName(user);
        System.out.println( users.get());
        model.addAttribute("user", users.get());
        return "index";
    }

    @GetMapping("/home/{user}/quiz")
    public String displayQuiz(@PathVariable String user ,Model model){
        Optional<User> users = addUserRepo.findByUserName(user);
        model.addAttribute("user", users.get().getUserName());
        return "quiz";
    }

    @PostMapping("/home/{user}/quiz")
    public void postQuizScore(@RequestBody QuizScore score){
        System.out.println(score.getUserScore());
        System.out.println(score.getUser());
        Optional<User> users = addUserRepo.findByUserName(score.getUser());
        System.out.println(users.get());
        User userUp = users.get();
       System.out.println(users.isPresent());
       if(userUp.getScore() < score.getUserScore()){
           userUp.setScore(score.getUserScore());
           addUserRepo.save(userUp);
       }
    }

    @GetMapping("/leaderboard")
    public String leaderBoard(Model model){
        List<User> users= addUserRepo.findAll();
        System.out.println(users);
        users.sort(Comparator.comparing(User::getScore).reversed());
        System.out.println(users);
        model.addAttribute("users",users);
        return "leaderBoard";
    }
}


