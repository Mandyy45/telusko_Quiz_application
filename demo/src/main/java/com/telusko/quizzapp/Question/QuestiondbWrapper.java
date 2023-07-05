package com.telusko.quizzapp.Question;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class QuestiondbWrapper {

    private int id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
