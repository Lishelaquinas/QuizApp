package com.quizapp.quizapplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizapp.quizapplication.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {


    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numOfQuestions", nativeQuery = true)
    List<Question> findQuestionsbyCategory(String category, int numOfQuestions);

    List<Question> findByCategory(String category);

    
} 
