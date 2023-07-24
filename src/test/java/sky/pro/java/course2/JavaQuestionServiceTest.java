package sky.pro.java.course2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import sky.pro.java.course2.Exceptions.ItAlreadyExistsException;
import sky.pro.java.course2.Exceptions.ItIsAbsentException;
import sky.pro.java.course2.configuration.JavaConfiguration;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;
import sky.pro.java.course2.service.JavaQuestionService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private QuestionService out = new JavaQuestionService();

    @Test
    public void ShouldBeEqualWhenAdd() {
        Question quest = new Question("firstQuestion", "firstAnswer");
        Question result = out.add("firstQuestion", "firstAnswer");
        assertEquals(quest, result);
    }
        @Test
    public void ShouldThrowExceptionWhenAddSameThings() {
         out.add("firstQuestion", "firstAnswer");
        assertThrows(ItAlreadyExistsException.class,
                () -> out.add("firstQuestion", "firstAnswer"));
    }

    @Test
    public void removeTest() {
        Question quest = new Question("frQs", "frAw");
        Question result = out.add("frQs", "frAw");
         out.remove("frQs", "frAw");
        assertEquals(quest, result);
    }

    @Test
    public void shouldThrowExceptionWhenRemoveWhatDoesNotExist() {
        assertThrows(ItIsAbsentException.class,
                () -> out.remove("frQs", "frAw"));
    }

    @Test
    public void getAllTest() {
        Set<Question> result = new HashSet<>(Set.of(
                out.add("first", "first"),
                out.add("second", "second"),
                out.add("third", "third")
        ));
        Set<Question> getAll = new HashSet<>(out.getAll());
        Assertions.assertIterableEquals(result, getAll);
    }
}
