package com.sahaj.matcher;

import com.sahaj.model.Answer;
import com.sahaj.model.Question;
import com.sahaj.model.WikipediaInput;
import com.sahaj.parser.WikipediaParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuestionAnswerMatcherTest {

    private QuestionAnswerMatcher questionAnswerMatcher;
    private WikipediaInput wikipediaInput;

    @Before
    public void setUp() {
        WikipediaParser wikipediaParser = new WikipediaParser(getTestWikipediaContent());
        questionAnswerMatcher = new QuestionAnswerMatcher();
        wikipediaInput = wikipediaParser.parseWikipediaContent();
    }

    @Test
    public void shouldReturnProcessedQuestionsWithScoreAndMatchedAnswers() {
        List<Question> expectedQuestions = getExpectedProcessedQuestions();

        List<Question> actualQuestions = questionAnswerMatcher.calculateScoreOfEachQuestion(wikipediaInput);

        assertNotNull(actualQuestions);
        assertEquals(expectedQuestions, actualQuestions);
    }

    @Test
    public void shouldReturnMatchingAnswersForQuestions() {
        List<Answer> expectedAnswers = new ArrayList<>();
        expectedAnswers.add(getTestAnswer());
        List<Answer> actualAnswers = questionAnswerMatcher.findMatchingAnswer(wikipediaInput);

        assertNotNull(actualAnswers);
        assertEquals(expectedAnswers, actualAnswers);
    }

    private List<Question> getExpectedProcessedQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(getQuestion());
        return questions;
    }

    private Answer getTestAnswer() {
        Answer answer = new Answer("the plains zebra, the Grévy's zebra and the mountain zebra");
        answer.setScore(0.75);
        return answer;
    }

    private Question getQuestion() {
        Question question = new Question("Which are the three species of zebras?");
        Set<Answer> matches = new HashSet<>();
        matches.add(getTestAnswer());
        question.setMatches(matches);
        question.setScore(0.75);
        return question;
    }

    private String getTestWikipediaContent() {
        return "There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The plains zebra and the" +
        " mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus.\n" +
        "Which are the three species of zebras?\n" +
         "the plains zebra, the Grévy's zebra and the mountain zebra;Grévy's zebra and the mountain zebra";
    }
}
