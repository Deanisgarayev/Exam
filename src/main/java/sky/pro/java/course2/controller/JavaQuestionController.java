package sky.pro.java.course2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    QuestionService service;
@Autowired
    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }
    @GetMapping(value = "/add" )
    Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }
//    @GetMapping(value = "/add" )
//    Question add(@RequestParam String question, @RequestParam String answer) {
//        return service.add(new Question(question, answer));
//    }
    @GetMapping("/getAll")
    Collection<Question> getAll() {
        return service.getAll();
    }
    @GetMapping("/remove")
    Question remove(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question, answer);
    }
//    @GetMapping("/remove")
//    Question remove(@RequestParam String question, @RequestParam String answer) {
//        return service.remove(new Question(question, answer));
//    }

}
