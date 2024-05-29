package com.oshada.quizapp.controller;

import com.oshada.quizapp.model.Question;
import com.oshada.quizapp.service.QuestionService;
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
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

     @GetMapping("option3/{option3}")
    public List<Question> getQuestionByDifficulty(@PathVariable String option3) {
        return questionService.getQuestionByDifficulty(option3);
    }

    @PostMapping("add")
    public ResponseEntity<String>  addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String>  deleteQuestion(@RequestBody Question question) {
        return questionService.deleteQuestion(question);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }
}