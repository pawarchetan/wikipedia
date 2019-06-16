package com.sahaj.model;

import java.util.List;

public class WikipediaInput {
    private List<String> sentences;
    private List<String> questions;
    private List<String> answers;

    public WikipediaInput(List<String> sentences, List<String> questions, List<String> answers) {
        this.sentences = sentences;
        this.questions = questions;
        this.answers = answers;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
