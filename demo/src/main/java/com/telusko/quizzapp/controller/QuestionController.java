package com.telusko.quizzapp.controller;

import com.telusko.quizzapp.Question.Questiondb;
import com.telusko.quizzapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Questiondb>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questiondb>> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questiondb questiondb){
        return questionService.addQuestion(questiondb);

    }
    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Questiondb questiondb) {
        return questionService.deleteQuestion(questiondb);


    }
}
