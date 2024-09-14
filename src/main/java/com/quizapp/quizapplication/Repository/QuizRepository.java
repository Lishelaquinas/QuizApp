package com.quizapp.quizapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.quizapplication.Model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {


    
}