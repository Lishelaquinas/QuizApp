package com.quizapp.quizapplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.quizapplication.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    
} 
