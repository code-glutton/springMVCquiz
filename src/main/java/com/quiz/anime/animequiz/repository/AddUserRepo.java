package com.quiz.anime.animequiz.repository;

import com.quiz.anime.animequiz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddUserRepo extends JpaRepository<User,String> {
    Optional<User> findByUserName(String username);
}
