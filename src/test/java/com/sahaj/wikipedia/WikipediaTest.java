package com.sahaj.wikipedia;

import com.sahaj.TestData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WikipediaTest {

    @Test
    public void shouldCreateEmptyWikipediaFromNullObject() {
        Wikipedia actualWikipedia = Wikipedia.of(null,  null);

        assertNotNull(actualWikipedia);
        assertEquals(0, actualWikipedia.getAnswers().size());
        assertEquals(0, actualWikipedia.getSentences().size());
    }

    @Test
    public void shouldCreateEmptyWikipediaFromEmptyInput() {
        Wikipedia actualWikipedia = Wikipedia.of(new ArrayList<>(), new ArrayList<>());

        assertNotNull(actualWikipedia);
        assertEquals(0, actualWikipedia.getAnswers().size());
        assertEquals(0, actualWikipedia.getSentences().size());
    }

    @Test
    public void shouldCreateWikipediaFromInputSentences() {
        List<String> input = TestData.getInputSentences();
        List<String> answers = TestData.getTestAnswers();
        Wikipedia actualWikipedia = Wikipedia.of(input, answers);

        assertNotNull(actualWikipedia);
        assertEquals(5, actualWikipedia.getAnswers().size());
        assertEquals(14, actualWikipedia.getSentences().size());
        assertEquals("Zebras are several species of African equids (horse family) united by their distinctive black and white stripes",
                actualWikipedia.getSentences().get(0).toString());
        assertEquals("Though there is currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically " +
                "similar to the Quagga, in a process called breeding back", actualWikipedia.getSentences().get(13).toString());
    }

    @Test
    public void shouldReturnEmptyObjectForInvalidQuestion() {
        List<String> input = TestData.getInputSentences();
        List<String> answers = TestData.getTestAnswers();
        Wikipedia actualWikipedia = Wikipedia.of(input, answers);

        Optional<Answer> answer = actualWikipedia.ask(null);
        assertFalse(answer.isPresent());

        Optional<Answer> answer2 = actualWikipedia.ask("");
        assertFalse(answer2.isPresent());
    }

    @Test
    public void shouldReturnAnAnswerForAskedQuestion1() {
        List<String> input = TestData.getInputSentences();
        List<String> answers = TestData.getTestAnswers();

        Wikipedia wikipedia = Wikipedia.of(input, answers);
        Optional<Answer> actualAnswer = wikipedia.ask("Which Zebras are endangered?");

        assertTrue(actualAnswer.isPresent());
        assertEquals("Grévy's zebra and the mountain zebra", actualAnswer.get().getStatement().toString());
    }

    @Test
    public void shouldReturnAnAnswerForAskedQuestion2() {
        List<String> input = TestData.getInputSentences();
        List<String> answers = TestData.getTestAnswers();

        Wikipedia wikipedia = Wikipedia.of(input, answers);
        Optional<Answer> actualAnswer = wikipedia.ask("What is the aim of the Quagga Project?");

        assertTrue(actualAnswer.isPresent());
        assertEquals("aims to breed zebras that are phenotypically similar to the quagga", actualAnswer.get().getStatement().toString());
    }

}
