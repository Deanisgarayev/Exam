package sky.pro.java.course2.service;


import org.springframework.stereotype.Service;
import sky.pro.java.course2.Exceptions.ItAlreadyExistsException;
import sky.pro.java.course2.Exceptions.ItIsAbsentException;
import sky.pro.java.course2.interfaces.QuestionService;
import sky.pro.java.course2.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {


    public Set<Question> questSet = new HashSet<>();

//    adds question and answer
    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);
        if (questSet.contains(quest)) {
            throw new ItAlreadyExistsException("You can't add it again");
        }
        questSet.add(quest);
        return quest;
    }

//    remove question and answer
    @Override
    public Question remove(String question, String answer) {
        Question quest = new Question(question, answer);
        if (questSet.contains(quest)) {
            questSet.remove(quest);
            return quest;
        }
        throw new ItIsAbsentException("You can't remove that isn't there");
    }

//    gets all questions and answers
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questSet);
    }

    @Override

//    gets random question and answer
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questions = new ArrayList<>(getAll());
        return questions.get(random.nextInt(questions.size()));
        }
    }
