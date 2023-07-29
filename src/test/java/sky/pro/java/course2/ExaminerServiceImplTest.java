package sky.pro.java.course2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import sky.pro.java.course2.Exceptions.OutOfQuestionsException;
import sky.pro.java.course2.repository.Question;
import sky.pro.java.course2.service.ExaminerServiceImpl;
import sky.pro.java.course2.service.JavaQuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(questSet());
    }

    private Set<Question> questSet() {
        return Set.of( new Question("first", "first"),
                new Question("second","second"),
                new Question("third", "third"),
                new Question("forth", "forth"),
                new Question("fifth", "fifth"),
                new Question("sixth", "sixth"),
                new Question("seventh", "seventh")
        );
    }

    @Test
//    Set<Question>questionSet=new HashSet<>()
    public void getQuestionsTest() {
        assertNotNull(out.getQuestions(2));
    }

    @Test
    public void ShouldThrowExceptionWhenRequireMoreAmountThanHave() {
        assertThrows(OutOfQuestionsException.class,
                () -> out.getQuestions(10));
    }
}
