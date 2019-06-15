package com.sahaj.model;

import java.util.List;

public class WikipediaInput {
    private String paragraphString;
    private List<String> questions;
    private List<String> answers;

    public WikipediaInput(String paragraphString, List<String> questions, List<String> answers) {
        this.paragraphString = paragraphString;
        this.questions = questions;
        this.answers = answers;
    }

    public String getParagraphString() {
        return paragraphString;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
