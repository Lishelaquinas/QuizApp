package com.quizapp.quizapplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.quizapplication.Model.Question;
import com.quizapp.quizapplication.Repository.QuestionRepository;

@Service
public class QuestionService {
   @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<?> getAllquestions()
    {
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
         }
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public ResponseEntity<String> addProduct(Question question) {
        if (questionRepository.save(question) != null){
            return new ResponseEntity<>("sucess", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> updateProduct(Question question) {
        if (questionRepository.save(question) != null){
            return new ResponseEntity<>("sucess", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteProduct(int productId) {
     try{
        questionRepository.deleteById(productId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
     }
     catch(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }

   
    
}
