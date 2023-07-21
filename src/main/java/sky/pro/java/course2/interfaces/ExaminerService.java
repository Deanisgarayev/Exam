package sky.pro.java.course2.interfaces;



import sky.pro.java.course2.repository.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
