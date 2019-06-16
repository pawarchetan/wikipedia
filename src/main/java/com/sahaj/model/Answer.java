package com.sahaj.model;

import java.util.Objects;

public class Answer {

    private String answerString;
    private Double score;

    public Answer(String answerString) {
        this.answerString = answerString;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAnswerString() {
        return answerString;
    }

    Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(answerString, answer.answerString) &&
                Objects.equals(score, answer.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerString, score);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerString='" + answerString + '\'' +
                ", score=" + score +
                '}';
    }
}
