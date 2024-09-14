package com.quizapp.quizapplication.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.quizapplication.Model.Question;
import com.quizapp.quizapplication.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionContoller {
    @Autowired
    private QuestionService questionService;
    
@GetMapping("/allquestions")
public ResponseEntity<?> getAllquestions(){
    return questionService.getAllquestions();
}

//Fetch Questions by category

@GetMapping("/bycategory/{category}")
public List<Question> getQuestionByCategory(@PathVariable String category)
{
    return questionService.getQuestionByCategory(category);
}

// Add questions

@PostMapping("/add")
public ResponseEntity<String> addProduct(@RequestBody Question question){
    return questionService.addProduct(question);
}

//Updating questions
@PutMapping("/update")
public ResponseEntity<String> updateProduct(@RequestBody Question question){
    return questionService.updateProduct(question);
}

@DeleteMapping("/delete/{productId}")
public ResponseEntity<String> deleteProduct(@PathVariable int productId)
    {
        return questionService.deleteProduct(productId);
    }
}

