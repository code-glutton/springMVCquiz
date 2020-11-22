package com.quiz.anime.animequiz.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentResult {
    private Integer responseCode;

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

    @Override
    public String toString() {
        return "ParentResult{" +

                "responseCode=" + responseCode +
                ", results=" + results +
                '}';
    }
}

