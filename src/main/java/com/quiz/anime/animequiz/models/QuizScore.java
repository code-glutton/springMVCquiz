package com.quiz.anime.animequiz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class QuizScore {

    private int userScore;

    public QuizScore() {
    }

    public QuizScore(int userScore) {
        this.userScore = userScore;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    @Override
    public String toString() {
        return "QuizScore{" +
                "userScore=" + userScore +
                '}';
    }
}
