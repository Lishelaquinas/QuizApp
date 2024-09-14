package com.quizapp.quizapplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.quizapp.quizapplication.Model.Question;
import com.quizapp.quizapplication.Model.QuestionWrapper;
import com.quizapp.quizapplication.Model.Quiz;
import com.quizapp.quizapplication.Model.Response;
import com.quizapp.quizapplication.Repository.QuestionRepository;
import com.quizapp.quizapplication.Repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> createQuiz(String category, int numOfQuestions, String title) {

        List<Question> questions = questionRepository.findQuestionsbyCategory(category, numOfQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getquiz(int quizId) {
       Optional<Quiz> quiz = quizRepository.findById(quizId);
       //get all the questions from quixz object. We use get() then getQuestions() because we have used Optional parameter.
       List<Question> questions = quiz.get().getQuestions();
       //convert then into QuestionWrapper.
       List<QuestionWrapper> questionsForUsers = new ArrayList<>();
       for(Question q: questions)   {
        QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
        questionsForUsers.add(qw);
       }          

       return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);



    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get(); // get is used instead of optional.
        List<Question> questions = quiz.getQuestions();
        int marks = 0;
        int i = 0;
        for (Response response: responses)
        {
            if (response.getResponse() .equals(questions.get(i).getRightAnswer())){
                marks++;
            }
            i++;
        }
        
        return new ResponseEntity<>(marks, HttpStatus.OK);
        }

}
