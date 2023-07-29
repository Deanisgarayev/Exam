package sky.pro.java.course2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import sky.pro.java.course2.Exceptions.OutOfQuestionsException;
import sky.pro.java.course2.interfaces.ExaminerService;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;
import sky.pro.java.course2.service.ExaminerServiceImpl;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExaminerServiceImplTest {
    private ExaminerService out;
    private QuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionService = Mockito.mock(QuestionService.class);
        out = new ExaminerServiceImpl(questionService);
    }

    @Test
    public void getQuestionsTest() {
        Question question1 = new Question("first", "first");
        Question question2 = new Question("second","second");
        Question question3 = new Question("third", "third");
        when(questionService.getAll()).thenReturn(List.of(question1, question2, question3));
        when(questionService.getRandomQuestion())
                .thenReturn(question2)
                .thenReturn(question1)
                .thenReturn(question3)
                .thenReturn(question1);
        Collection<Question> questions = out.getQuestions(3);
        assertEquals(3,questions.size());
        verify(questionService, times(3)).getRandomQuestion();
    }

    @Test
    public void ShouldThrowExceptionWhenRequireMoreAmountThanHave() {
        Question question1 = new Question("first", "first");
        Question question2 = new Question("second","second");
        Question question3 = new Question("third", "third");
        when(questionService.getAll()).thenReturn(List.of(question1, question2, question3));
        assertThrows(OutOfQuestionsException.class,
                () -> out.getQuestions(4));
    }
}
