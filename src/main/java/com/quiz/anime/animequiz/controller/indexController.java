package com.quiz.anime.animequiz.controller;

import com.quiz.anime.animequiz.models.Login;
import com.quiz.anime.animequiz.models.QuizScore;
import com.quiz.anime.animequiz.models.User;
import com.quiz.anime.animequiz.repository.AddUserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;


import java.util.HashSet;
import java.util.Optional;
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

    @RequestMapping("/home")
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
        return "signUp";

    }

    @PostMapping("/")
    public String greetingSubmit(@Valid @ModelAttribute User user, Model model, BindingResult bindingResult) {
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

}
