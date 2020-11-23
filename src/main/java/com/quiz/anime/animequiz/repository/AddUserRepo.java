package com.quiz.anime.animequiz.repository;

import com.quiz.anime.animequiz.models.User;
import org.springframework.data.repository.CrudRepository;

public interface AddUserRepo extends CrudRepository<User,Long> {
}
