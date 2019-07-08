package com.sahaj.wikipedia;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statement {

    private final String content;
    private final Set<String> stem;

    private static final Set<String> stopWords = new HashSet<>(
            Arrays.asList("where", "what", "when", "who", "whose", "by", "their", "and", "in", "to", "each", "they",
                    "are", "that", "have", "been", "there", "of", "the", "but", "is", "an", "it", "while", "all",
                    "with", "other", "them", "most", "a", "such", "however", "had", "on", "for", "much", "more"));

    public static Statement from(String line) {
        return new Statement(line);
    }

    private Statement(String content) {
        this.content = content.trim();
        this.stem = generateStem(this.content);
    }

    private Set<String> generateStem(String line) {
        return Stream.of(line.split(" "))
                .map(s -> s.trim().replaceAll("[,:;'?()]", ""))
                .filter(s -> !stopWords.contains(s))
                .collect(Collectors.toSet());
    }

    public double similarityScore(Statement other) {
        Set<String> intersection = new HashSet<>(this.stem);
        intersection.retainAll(other.stem);
        return intersection.size() * (1.0 / other.stem.size());
    }

    public String getContent() {
        return content;
    }

    public Set<String> getStem() {
        return stem;
    }

    @Override
    public String toString() {
        return content;
    }
}
