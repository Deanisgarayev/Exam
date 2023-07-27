package sky.pro.java.course2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.Exceptions.OutOfQuestionsException;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;

import java.util.*;

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
        if (amount > total) {
            throw new OutOfQuestionsException("you require from us more questions than we have");
        }
        Set<Question> questionSet = new HashSet<>();
        int i = 0;
        while (i == amount) {
            i++;
            questionSet.add(questionService.getRandomQuestion());

        }
        return Collections.unmodifiableCollection(questionSet);
    }



}


