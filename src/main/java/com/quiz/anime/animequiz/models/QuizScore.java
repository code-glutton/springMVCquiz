package com.quiz.anime.animequiz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class QuizScore {

    private int userScore;
    private String user;

    public QuizScore() {
    }

    public QuizScore(int userScore,String user) {
        this.userScore = userScore;
        this.user = user;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QuizScore{" +
                "userScore=" + userScore +
                '}';
    }
}
