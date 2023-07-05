package com.telusko.quizzapp.Dao;

import com.telusko.quizzapp.Question.Questiondb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionDao extends JpaRepository<Questiondb, Integer> {
    List<Questiondb> findByCategory(String category);

    @Query(value = "SELECT * FROM questiondb q Where q.category=:category ORDER BY RANDOM() LIMIT :QNo",nativeQuery = true)
    List<Questiondb> findRandomQuestionsByCategory(String category, int QNo);


}
