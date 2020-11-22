package com.quiz.anime.animequiz.service;

import com.quiz.anime.animequiz.models.ParentResult;
import com.quiz.anime.animequiz.models.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class ApiServiceImpl implements ApiService{
    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Set<Result> getResult(){
        ParentResult parentResult = restTemplate.getForObject("https://opentdb.com/api.php?amount=10&category=17&difficulty=hard&type=multiple",ParentResult.class);
        return parentResult.getResults();
    }
}
