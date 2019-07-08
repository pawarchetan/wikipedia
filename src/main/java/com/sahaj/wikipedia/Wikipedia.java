package com.sahaj.wikipedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wikipedia {
    private List<Statement> sentences;
    private List<Answer> answers;

    private Wikipedia(List<String> inputSentences, List<String> answers) {
        this.sentences = formatSentences(inputSentences);
        this.answers = formatAnswers(answers);
    }

    public static Wikipedia of(List<String> wikipediaContent, List<String> answers) {
        return new Wikipedia(wikipediaContent, answers);
    }

    public Optional<Answer> ask(String askedQuestion) {
        if(askedQuestion == null || askedQuestion.isEmpty()) {
            System.err.println("Invalid Question : " + askedQuestion);
            return Optional.empty();
        }
        Question question = Question.from(askedQuestion);
        return findPotentialMatchFor(question);
    }

    private Optional<Answer> findPotentialMatchFor(Question question) {
        Answer finalAnswer = null;
        Double maxScore = 0.0;
        for (Answer answer : answers) {
            for (Statement sentence : sentences) {
                Double score = sentence.similarityScore(answer.getStatement()) * sentence.similarityScore(question.getStatement());
                if (score > maxScore) {
                    maxScore = score;
                    finalAnswer = answer;
                }
            }
        }
        return Optional.ofNullable(finalAnswer);
    }

    private List<Statement> formatSentences(List<String> sentences) {
        if(sentences == null || sentences.isEmpty()) return new ArrayList<>();
        return Stream.of(sentences.stream()
                .findFirst()
                .orElse(null))
                .flatMap(Pattern.compile("\\.")::splitAsStream)
                .map(Statement::from)
                .collect(Collectors.toList());
    }

    private List<Answer> formatAnswers(List<String> answers) {
        if(sentences.isEmpty()) return new ArrayList<>();
        return answers.stream()
                .filter(Objects::nonNull)
                .map(Answer::from)
                .collect(Collectors.toList());
    }

    public List<Statement> getSentences() {
        return sentences;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
