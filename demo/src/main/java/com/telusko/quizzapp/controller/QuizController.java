package com.telusko.quizzapp.controller;

import com.telusko.quizzapp.Question.Questiondb;
import com.telusko.quizzapp.Question.QuestiondbWrapper;
import com.telusko.quizzapp.Question.Response;
import com.telusko.quizzapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int QNo,
                                             @RequestParam String title) {
        return quizService.createQuiz(category, QNo, title);
    }

    @GetMapping("Get/{id}")
    public ResponseEntity<List<QuestiondbWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<
            Response> responses){
        return quizService.calculateResult(id,responses);


    }
    }






