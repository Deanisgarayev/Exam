package sky.pro.java.course2.interfaces;


import sky.pro.java.course2.repository.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();
    Question getRandomQuestion(String question, String answer);

}
