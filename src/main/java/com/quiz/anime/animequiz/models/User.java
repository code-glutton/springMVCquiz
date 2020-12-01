package com.quiz.anime.animequiz.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @NotEmpty
    private String userName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=5)
    private String password;

    private int score;


    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(@NotEmpty String userName, @NotBlank @Email String email, @NotBlank @Size(min = 5) String password, int score) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }
}
