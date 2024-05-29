package com.oshada.quizapp.service;

import com.oshada.quizapp.model.Question;
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

    /*public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    } */

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

   public List<Question> getQuestionByDifficulty(String option3) {
        return questionDao.findByOption3(option3);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> deleteQuestion(Question question) {
        try {
            questionDao.delete(question);
            return new  ResponseEntity<> ("deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("updated",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);

    }
}