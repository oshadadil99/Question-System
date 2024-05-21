package com.oshada.quizapp.service;

import com.oshada.quizapp.Question;
import com.oshada.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestion() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

   /* public List<Question> getQuestionByDifficulty(String difficulty) {
        return questionDao.findByDifficulty(difficulty);
    } */

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public String deleteQuestion(Question question) {
        questionDao.delete(question);
        return "deleted";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "updated";
    }
}
