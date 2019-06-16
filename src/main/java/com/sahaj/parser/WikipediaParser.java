package com.sahaj.parser;

import com.sahaj.model.WikipediaInput;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sahaj.Constants.NEW_LINE_PATTERN;
import static com.sahaj.Constants.SEMI_COLON_SEPARATOR_PATTERN;
import static com.sahaj.Constants.SENTENCE_SEPARATOR_PATTERN;

public class WikipediaParser {

    private String contentToParse;

    public WikipediaParser(String contentToParse) {
        this.contentToParse = contentToParse;
    }

    public WikipediaInput parseWikipediaContent() {
        List<String> statements = getAllStatements(contentToParse);
        List<String> sentences = getParagraph(statements);
        List<String> questions = getQuestions(statements);
        List<String> answers = getAnswers(statements);
        return new WikipediaInput(sentences, questions,  answers);
    }

    private List<String> getAllStatements(String wikipediaContent) {
        return Arrays.asList(wikipediaContent.split(NEW_LINE_PATTERN));
    }

    private List<String> getParagraph(List<String> wikipediaStatements) {
        return Stream.of(wikipediaStatements.stream()
                .findFirst()
                .orElse(null))
                .flatMap(Pattern.compile(SENTENCE_SEPARATOR_PATTERN)::splitAsStream)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<String> getQuestions(List<String> wikipediaStatements) {
        return wikipediaStatements.stream()
                .skip(1)
                .limit(wikipediaStatements.size() - 2)
                .collect(Collectors.toList());
    }

    private List<String> getAnswers(List<String> wikipediaStatements) {
        return wikipediaStatements.stream()
                .skip(wikipediaStatements.size() - 1)
                .flatMap(Pattern.compile(SEMI_COLON_SEPARATOR_PATTERN)::splitAsStream)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
