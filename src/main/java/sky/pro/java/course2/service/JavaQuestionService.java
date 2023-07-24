package sky.pro.java.course2.service;


import org.springframework.stereotype.Service;
import sky.pro.java.course2.Exceptions.ItAlreadyExistsException;
import sky.pro.java.course2.Exceptions.ItIsAbsentException;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.repository.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    public Set<Question> questSet = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);
        if (questSet.contains(quest)) {
            throw new ItAlreadyExistsException("You can't add it again");
        }
        questSet.add(quest);
        return quest;
    }

    @Override
    public Question add(Question question) {
        if (questSet.contains(question)) {
            throw new ItAlreadyExistsException("You can't add it again");
        }
        questSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questSet.contains(question)) {
             questSet.remove(question);
            return question;
        }
        throw new ItIsAbsentException("You can't remove that isn't there");
    }

    @Override
    public Question remove(String question, String answer) {
        Question quest = new Question(question, answer);
        if (questSet.contains(quest)) {
            questSet.remove(quest);
            return quest;
        }
        throw new ItIsAbsentException("You can't remove that isn't there");
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questSet);
    }

    @Override
    public Collection<Question> getRandomQuestion() {
        Random random = new Random();
         random.nextInt(0, 100);
        return getAll();
        }
    }
