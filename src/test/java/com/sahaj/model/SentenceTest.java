package com.sahaj.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SentenceTest {

    private Sentence sentence;

    @Before
    public void setUp() {
        sentence = new Sentence("there are three species of zebras: the plains zebra, the grévy's zebra and the mountain zebra");
    }

    @Test
    public void shouldReturnSentenceToQuestionSimilarityScore() {
        Double similarityScore  = sentence.similarityScore("Which are the three species of zebras?");

        assertNotNull(similarityScore);
        assertEquals(0.75, similarityScore, 0.0);
    }

    @Test
    public void shouldReturnSentenceToAnswerSimilarityScore() {
        Double similarityScore  = sentence.similarityScore("the plains zebra, the Grévy's zebra and the mountain zebra");

        assertNotNull(similarityScore);
        assertEquals(0.75, similarityScore, 0.0);
    }

    @Test
    public void shouldReturnIntersectionOfTwoLists() {
        List<String> expectedIntersection = getExpectedIntersection();
        List<String> firstList = getFirstList();
        List<String> secondList = getSecondList();
        List<String> actualIntersection = sentence.intersection(firstList, secondList);

        assertNotNull(actualIntersection);
        assertEquals(expectedIntersection, actualIntersection);
    }

    @Test
    public void shouldReturnSentenceAfterRemovingKeywords() {
        String sentenceAfterKeywordRemoval = sentence.removeKeywordsWords("there are three species of zebras: the plains zebra, the grévy's zebra and the mountain zebra");

        assertEquals("three species zebras: plains zebra, grévy's zebra mountain zebra", sentenceAfterKeywordRemoval);
    }

    @Test
    public void shouldReturnSentenceAfterRemovingSpecialCharacters() {
        String sentenceAfterSpecialCharacterRemoval = sentence.removeSpecialCharacters("there are three species of zebras: the plains zebra, the grévy's zebra and the mountain zebra");

        assertEquals("there are three species of zebras the plains zebra the grévys zebra and the mountain zebra", sentenceAfterSpecialCharacterRemoval);
    }

    @Test
    public void shouldReturnSingularSentence() {
        String singularSentence = sentence.transformToSingular("They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, and coastal hills");

        assertEquals("They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, and coastal hill", singularSentence);
    }

    private List<String> getExpectedIntersection() {
        List<String> expectedIntersection = new ArrayList<>();
        expectedIntersection.add("zebra");
        expectedIntersection.add("plain");
        expectedIntersection.add("grévy");
        expectedIntersection.add("mountain");
        return expectedIntersection;
    }

    private List<String> getFirstList() {
        List<String> firstList = new ArrayList<>();
        firstList.add("three");
        firstList.add("specie");
        firstList.add("zebra");
        firstList.add("plain");
        firstList.add("grévy");
        firstList.add("mountain");
        return firstList;
    }

    private List<String> getSecondList() {
        List<String> secondList = new ArrayList<>();
        secondList.add("plain");
        secondList.add("zebra");
        secondList.add("grévy");
        secondList.add("mountain");
        return secondList;
    }
}