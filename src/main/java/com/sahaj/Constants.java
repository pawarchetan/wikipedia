package com.sahaj;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String SENTENCE_SEPARATOR_PATTERN = "\\.";
    public static final String NEW_LINE_PATTERN = "\n";
    public static final String SEMI_COLON_SEPARATOR_PATTERN = ";";
    public static final String SPACE_SEPARATOR_PATTERN =  " ";
    public static final String SEPARATOR_PATTERN = "";
    public static final Double DOUBLE_MULTIPLIER = 1.0;

    public static final List<String> specialCharactersList = Arrays.asList(",", ";", ":", ".", "'", "?");
    public static final List<String> stopWordsList = Arrays.asList("where", "what", "when", "who", "whose", "by", "their", "and", "in", "to",
            "each", "they", "are", "that", "have", "been", "there", "of", "the", "but", "is", "an", "it", "while", "all", "with", "other"
            , "them", "most", "a", "such", "however", "had", "on","for", "much",  "more");
}
