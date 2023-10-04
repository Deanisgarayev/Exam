package sky.pro.java.course2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.Exceptions.OutOfQuestionsException;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

//    gets random question and answer
    @Override
    public Collection<Question> getQuestions(int amount) {
        int total = questionService.getAll().size();
        if (amount > total) {
            throw new OutOfQuestionsException("you require from us more questions than we have");
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }



}


