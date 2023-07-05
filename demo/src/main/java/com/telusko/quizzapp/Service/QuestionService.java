package com.telusko.quizzapp.Service;

import com.telusko.quizzapp.Dao.QuestionDao;
import com.telusko.quizzapp.Question.Questiondb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questiondb> >getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questiondb> >getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questiondb questiondb) {
        questionDao.save(questiondb);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public String deleteQuestion(Questiondb questiondb) {
        int id = questiondb.getId();
        questionDao.deleteById(id);
        return "Id deleted succesfully";
    }
}
