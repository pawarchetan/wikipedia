package com.sahaj.wikipedia;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StatementTest {

    @Test
    public void shouldReturnStatementForGivenSentence() {
        String sentence = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes";
        Set<String> stem = new HashSet<>();
        stem.add("horse");
        stem.add("stripes");
        stem.add("distinctive");
        stem.add("white");
        stem.add("species");
        stem.add("united");
        stem.add("equids");
        stem.add("several");
        stem.add("black");
        stem.add("Zebras");
        stem.add("family");
        stem.add("African");

        Statement statement = Statement.from(sentence);

        assertNotNull(statement);
        assertEquals(sentence, statement.getContent());
        assertEquals(stem, statement.getStem());
    }

    @Test
    public void shouldReturnStatementForGivenAnswer() {
        String answer = "Grévy's zebra and the mountain zebra";
        Set<String> stem = new HashSet<>();
        stem.add("zebra");
        stem.add("mountain");
        stem.add("Grévys");

        Statement statement = Statement.from(answer);

        assertNotNull(statement);
        assertEquals(answer, statement.getContent());
        assertEquals(stem, statement.getStem());
    }

    @Test
    public void shouldReturnStatementForGivenQuestion() {
        String question = "What is the aim of the Quagga Project?";
        Set<String> stem = new HashSet<>();
        stem.add("Project");
        stem.add("Quagga");
        stem.add("aim");
        stem.add("What");

        Statement statement = Statement.from(question);

        assertNotNull(statement);
        assertEquals(question, statement.getContent());
        assertEquals(stem, statement.getStem());
    }

    @Test
    public void shouldReturnSentenceToQuestionSimilarityScore() {
        Statement sentence = Statement.from("there are three species of zebras: the plains zebra, the grévy's zebra and the mountain zebra");
        Statement question = Statement.from("Which are the three species of zebras?");

        double similarityScore = sentence.similarityScore(question);

        assertEquals(0.75, similarityScore, 0.0);
    }

    @Test
    public void shouldReturnSentenceToAnswerSimilarityScore() {
        Statement sentence = Statement.from("there are three species of zebras: the plains zebra, the grévy's zebra and the mountain zebra");
        Statement answer = Statement.from("the plains zebra, the Grévy's zebra and the mountain zebra");

        double similarityScore = sentence.similarityScore(answer);

        assertEquals(0.75, similarityScore, 0.0);
    }
}
