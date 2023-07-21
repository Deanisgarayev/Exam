package sky.pro.java.course2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.repository.Question;

import java.util.Collection;

@RestController
@RequestMapping("/Exam")
public class ExamController {
    private final ExaminerService examinerService;
@Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/getQuestions")
    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }
}
