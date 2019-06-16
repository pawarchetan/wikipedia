package com.sahaj.model;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sahaj.Constants.DOUBLE_MULTIPLIER;
import static com.sahaj.Constants.SEPARATOR_PATTERN;
import static com.sahaj.Constants.SPACE_SEPARATOR_PATTERN;
import static com.sahaj.Constants.specialCharactersList;
import static com.sahaj.Constants.stopWordsList;

public class Sentence {

    private String content;

    public Sentence(String content) {
        this.content = content;
    }

    Double similarityScore(String sentence2) {
        Sentence sentence = new Sentence(sentence2);
        List<String> stemmedSentence1 = this.stem();
        List<String> stemmedSentence2 = sentence.stem();
        return intersection(stemmedSentence1, stemmedSentence2).size() * DOUBLE_MULTIPLIER/ stemmedSentence2.size();
    }

    List<String> intersection(List<String> list, List<String> otherList) {
        return list.stream()
                .filter(otherList::contains)
                .collect(Collectors.toList());
    }

    private List<String> stem() {
        return Stream.of(content)
                .flatMap(Pattern.compile(SPACE_SEPARATOR_PATTERN)::splitAsStream)
                .map(this::removeKeywordsWords)
                .map(this::removeSpecialCharacters)
                .map(this::transformToSingular)
                .filter(s -> !s.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }

    String removeKeywordsWords(String sentence) {
        return Stream.of(sentence)
                .flatMap(Pattern.compile(SPACE_SEPARATOR_PATTERN)::splitAsStream)
                .filter(s -> !stopWordsList.contains(s))
                .collect(Collectors.joining(SPACE_SEPARATOR_PATTERN));
    }

    String removeSpecialCharacters(String sentence) {
        return Stream.of(sentence)
                .flatMap(Pattern.compile(SEPARATOR_PATTERN)::splitAsStream)
                .filter(s -> !specialCharactersList.contains(s))
                .collect(Collectors.joining());
    }

    String transformToSingular(String sentence) {
        if (sentence.endsWith("s")) {
            return sentence.substring(0, sentence.length() - 1);
        }
        return sentence;
    }

}
