package com.telusko.quizzapp.Service;

import com.telusko.quizzapp.Dao.QuestionDao;
import com.telusko.quizzapp.Dao.QuizDao;
import com.telusko.quizzapp.Question.Questiondb;
import com.telusko.quizzapp.Question.QuestiondbWrapper;
import com.telusko.quizzapp.Question.Quiz;
import com.telusko.quizzapp.Question.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int QNo, String title){

        List<Questiondb> questions = questionDao.findRandomQuestionsByCategory(category,QNo);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestiondbWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questiondb> questionfromDb = quiz.get().getQuestions();
        List<QuestiondbWrapper> questionForUser = new ArrayList<>();
        for(Questiondb q : questionfromDb){
            QuestiondbWrapper qw = new QuestiondbWrapper(q.getId(),q.getQuestion_title(),
                                    q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);

        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Questiondb> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if (response.getResponse().equals(questions.get(i).getCorrect_answer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
