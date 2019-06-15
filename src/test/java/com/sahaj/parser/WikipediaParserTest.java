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
        wikipediaParser = new WikipediaParser();
        wikipediaContent = TestData.wikipediaParagraph();

    }

    @Test
    public void shouldGetParagraphTextFromWikipediaContent() {
        String expectedParagraphContent = TestData.getParagraphContent();
        WikipediaInput wikipediaInput = wikipediaParser.parseWikipediaContent(wikipediaContent);

        assertNotNull(wikipediaInput);
        assertEquals(expectedParagraphContent, wikipediaInput.getParagraphString());
    }

    @Test
    public void shouldGetQuestionsFromWikipediaContent() {
        List<String> expectedQuestions = TestData.getTestQuestions();
        WikipediaInput wikipediaInput = wikipediaParser.parseWikipediaContent(wikipediaContent);

        assertNotNull(wikipediaContent);
        assertEquals(expectedQuestions, wikipediaInput.getQuestions());
    }

    @Test
    public void shouldGetAnswersFromWikipediaContent() {
        List<String> expectedAnswers = TestData.getTestAnswers();
        WikipediaInput wikipediaInput = wikipediaParser.parseWikipediaContent(wikipediaContent);

        assertNotNull(wikipediaContent);
        assertEquals(expectedAnswers, wikipediaInput.getAnswers());
    }
}
