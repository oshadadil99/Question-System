package com.oshada.quizapp.service;

import com.oshada.quizapp.Question;
import com.oshada.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestion() {
       return questionDao.findAll();
    }
}
