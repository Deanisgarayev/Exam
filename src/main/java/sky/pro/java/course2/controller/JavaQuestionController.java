package sky.pro.java.course2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.model.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    QuestionService service;
@Autowired
    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

//    add question and answer
    @PostMapping(value = "/add" )
    Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

//    get all questions and answers
    @GetMapping("/getAll")
    Collection<Question> getAll() {
        return service.getAll();
    }

//    delete random question and answer
    @DeleteMapping("/remove")
    Question remove(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question, answer);
    }


}
