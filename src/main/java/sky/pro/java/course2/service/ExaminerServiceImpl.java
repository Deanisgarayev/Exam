package sky.pro.java.course2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.Exceptions.OutOfQuestionsException;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private final Random random;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService, Random random) {
        this.questionService = questionService;
        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int total = questionService.getAll().size();
        if (amount <= total) {
            amount = total;
            for (int i = 0; i < amount; i++) {
                return Collections.unmodifiableCollection(questionService.getRandomQuestion());
            }
        }
            throw new OutOfQuestionsException("you require from us more questions than we have");

        }
    }

