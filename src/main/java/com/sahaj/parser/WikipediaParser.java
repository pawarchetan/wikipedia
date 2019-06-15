package com.sahaj.parser;

import com.sahaj.model.WikipediaInput;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WikipediaParser {

    public WikipediaInput parseWikipediaContent(String wikipediaContent) {
        List<String> statements = getAllStatements(wikipediaContent);
        String paragraphContent = getParagraph(statements);
        List<String> questions = getQuestions(statements);
        List<String> answers = getAnswers(statements);
        return new WikipediaInput(paragraphContent, questions,  answers);
    }

    private List<String> getAllStatements(String wikipediaContent) {
        return Arrays.asList(wikipediaContent.split("\\n", 0));
    }

    private String getParagraph(List<String> wikipediaStatements) {
        return wikipediaStatements.stream()
                .findFirst()
                .orElse(null);
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
                .flatMap(Pattern.compile(";")::splitAsStream)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
