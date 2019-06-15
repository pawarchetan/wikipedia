package com.sahaj.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WikipediaInputTest {

    private WikipediaInput wikipediaInput;

    @Before
    public void setUp() {
        List<String> questions = getQuestions();
        List<String> answers = getAnswers();
        wikipediaInput = new WikipediaInput("Wikipedia Test Paragraph", questions, answers);
    }

    @Test
    public void shouldTestConstructorAndGetter() {
        assertNotNull(wikipediaInput);
        assertEquals("Wikipedia Test Paragraph", wikipediaInput.getParagraphString());
        assertEquals(2, wikipediaInput.getQuestions().size());
        assertEquals(2, wikipediaInput.getAnswers().size());
    }

    private List<String> getQuestions() {
        List<String> questions = new ArrayList<>();
        questions.add("Which Zebras are endangered?");
        questions.add("Which are the three species of zebras?");
        return questions;
    }

    private List<String> getAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("Grévy's zebra and the mountain zebra");
        answers.add("the plains zebra, the Grévy's zebra and the mountain zebra");
        return answers;
    }
}
