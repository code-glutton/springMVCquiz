package com.quiz.anime.animequiz.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class ParentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer responseCode;

    @OneToMany
    private Set<Result> results = new HashSet<>();

    public ParentResult() {
    }

    public ParentResult(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public ParentResult(Integer responseCode, Set<Result> results) {
        this.responseCode = responseCode;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}

