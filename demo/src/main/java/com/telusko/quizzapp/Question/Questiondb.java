package com.telusko.quizzapp.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Questiondb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct_answer;
    private String difficulty;
    private String category;

}
