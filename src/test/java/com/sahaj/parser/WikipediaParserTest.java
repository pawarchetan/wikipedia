package com.sahaj.parser;

import com.sahaj.TestData;
import com.sahaj.model.WikipediaInput;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WikipediaParserTest {

    private WikipediaParser wikipediaParser;
    private String wikipediaContent;

    @Before
    public void setUp() {
        wikipediaContent = TestData.wikipediaParagraph();
        wikipediaParser = new WikipediaParser(wikipediaContent);
    }

    @Test
    public void shouldGetParagraphTextFromWikipediaContent() {
        List<String> expectedSentences = TestData.getParagraphContent();
        WikipediaInput wikipediaInput = wikipediaParser.parseWikipediaContent();

        assertNotNull(wikipediaInput);
        assertEquals(expectedSentences, wikipediaInput.getSentences());
    }

    @Test
    public void shouldGetQuestionsFromWikipediaContent() {
        List<String> expectedQuestions = TestData.getTestQuestions();
        WikipediaInput wikipediaInput = wikipediaParser.parseWikipediaContent();

        assertNotNull(wikipediaContent);
        assertEquals(expectedQuestions, wikipediaInput.getQuestions());
    }

    @Test
    public void shouldGetAnswersFromWikipediaContent() {
        List<String> expectedAnswers = TestData.getTestAnswers();
        WikipediaInput wikipediaInput = wikipediaParser.parseWikipediaContent();

        assertNotNull(wikipediaContent);
        assertEquals(expectedAnswers, wikipediaInput.getAnswers());
    }
}
