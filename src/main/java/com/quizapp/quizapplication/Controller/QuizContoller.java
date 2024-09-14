package com.quizapp.quizapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import com.quizapp.quizapplication.Model.Response;
import com.quizapp.quizapplication.Model.QuestionWrapper;
import com.quizapp.quizapplication.Service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizContoller {
    @Autowired
    QuizService quizService;
    
    @PostMapping("/createquiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numOfQuestions, @RequestParam String title)
    {
        return quizService.createQuiz(category,numOfQuestions,title);
    }

    //get quiz

    @GetMapping("/get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int quizId)
   
    {
        return quizService.getquiz(quizId);
    }

    // Calculating marks. user sends list of repsonses along with id [{id:option}] and quiz id.
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz (@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculateScore(id, responses);
    }



    
}
