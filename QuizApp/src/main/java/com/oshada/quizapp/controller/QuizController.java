package com.oshada.quizapp.controller;

import com.oshada.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class QuizController {

    @Autowired
    QuizService quizService;
    /*@PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,@RequestParam String title) {
        return quizService.createQuiz(category,numQ,title);
    } */
}
