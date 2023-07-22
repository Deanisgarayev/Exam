package sky.pro.java.course2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.Exceptions.OutOfQuestionsException;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;

import java.util.Collection;
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
        int total = questionService.getRandomQuestion();
        if (amount <= total) {
            for (int i = 0; i < amount; i++) {
                questionService.getRandomQuestion();
            }
        }
            throw new OutOfQuestionsException("you require us more questions than we have");

//        Его задача: создать коллекцию и заполнить её с помощью вызова getRandomQuestion у QuestionService случайными вопросами.
//
//                Учтите:
//
//        1.  Вопросы должны быть уникальные, следовательно, для получения 5 вопросов может потребоваться более 5 вызовов
//        метода getRandomQuestion сервиса вопросов.
//        2. Если запрошено большее количество вопросов, чем хранится в сервисе, нужно выкинуть исключение. Для этого,
//        соответственно, нужно написать свое исключение со статусом BAD_REQUEST.
        }
    }

