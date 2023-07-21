package sky.pro.java.course2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
@Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
    return null;
//        questionService.getAll().stream().collect(Collectors.toMap(e -> amount, e -> e.toString()));
//        amount = 5;
//        for (int i = 0; i < amount; i++) {
//
//        }


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
