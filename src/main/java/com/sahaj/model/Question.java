package com.sahaj.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Question {

    private String questionContent;
    private Set<Answer> matches;
    private Double score;

    public Question(String questionString) {
        this.questionContent = questionString;
        this.score = 0.0;
        this.matches = new HashSet<>();
    }

    public void setMatches(Set<Answer> matches) {
        this.matches = matches;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    String getQuestionContent() {
        return questionContent;
    }

    Set<Answer> getMatches() {
        return matches;
    }

    Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionContent, question.questionContent) &&
                Objects.equals(matches, question.matches) &&
                Objects.equals(score, question.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionContent, matches, score);
    }

    public Question findMatchingAnswer(WikipediaInput wikipediaInput) {
        //get all answers from wikipedia input
        List<Answer> answerList = wikipediaInput.getAnswers()
                .stream()
                .map(Answer::new)
                .collect(Collectors.toList());

        //get all matching answers for a question
        answerList.forEach(a -> allMatchingAnswers(a, wikipediaInput));
        return this;
    }

    private void allMatchingAnswers(Answer answer, WikipediaInput wikipediaInput) {
        wikipediaInput.getSentences().stream()
                .map(Sentence::new)
                .forEach(sentence -> {
                    Double scoreProduct = sentence.similarityScore(answer.getAnswerString()) * sentence.similarityScore(questionContent) ;
                    if (scoreProduct > this.score) {
                        answer.setScore(scoreProduct);
                        this.score = scoreProduct;
                        matches.add(answer);
                    }
                });
    }

    //get potential match from all matches for a question.
    public Answer potentialMatch() {
        return matches.stream()
                .min((a, b) -> b.getScore().compareTo(a.getScore()))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionContent='" + questionContent + '\'' +
                ", matches=" + matches +
                ", score=" + score +
                '}';
    }
}
