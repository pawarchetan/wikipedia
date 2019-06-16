package com.sahaj.model;

import com.sahaj.parser.WikipediaParser;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuestionTest {

    private Question question;
    private WikipediaInput wikipediaInput;

    @Before
    public void setUp() {
        WikipediaParser wikipediaParser = new WikipediaParser(getTestWikipediaContent());
        wikipediaInput = wikipediaParser.parseWikipediaContent();
        question = new Question("Which Zebras are endangered");
    }

    @Test
    public void shouldReturnAllMatchingAnswers() {
        Question expectedQuestion = getExpectedQuestion();
        Question actualQuestion = question.findMatchingAnswer(wikipediaInput);

        assertNotNull(actualQuestion);
        assertEquals(expectedQuestion.getQuestionContent(), actualQuestion.getQuestionContent());
        assertEquals(expectedQuestion.getMatches(), actualQuestion.getMatches());
        assertEquals(expectedQuestion.getScore(), actualQuestion.getScore());
    }

    @Test
    public void shouldReturnPotentialMatchFromAllMatches() {
        Answer expectedAnswer = new Answer("Grévy's zebra and the mountain zebra");
        Question actualQuestion = question.findMatchingAnswer(wikipediaInput);
        Answer actualAnswer = actualQuestion.potentialMatch();

        assertNotNull(actualAnswer);
        assertEquals(expectedAnswer.getAnswerString(), actualAnswer.getAnswerString());
    }

    private Question getExpectedQuestion() {
        Question question = new Question("Which Zebras are endangered");
        question.setScore(0.3333333333333333);
        Set<Answer> answers = new HashSet<>();
        Answer answer = new Answer("Grévy's zebra and the mountain zebra");
        answer.setScore(0.3333333333333333);
        answers.add(answer);
        Answer answer1 = new Answer("the plains zebra, the Grévy's zebra and the mountain zebra");
        answer1.setScore(0.25);
        answers.add(answer1);
        question.setMatches(answers);
        return question;
    }

    private String getTestWikipediaContent() {
        return "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes. Their " +
                "stripes come in different patterns, unique to each individual. They are generally social animals that live in small " +
                "harems to large herds. Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated. " +
                "There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The plains zebra and the" +
                " mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus. The" +
                " latter resembles an ass, to which it is closely related, while the former two are more horse-like. All three belong to " +
                "the genus Equus, along with other living equids. The unique stripes of zebras make them one of the animals most familiar" +
                " to people. They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, " +
                "and coastal hills. However, various anthropogenic factors have had a severe impact on zebra populations, in particular " +
                "hunting for skins and habitat destruction. Grévy's zebra and the mountain zebra are endangered. While plains zebras are " +
                "much more plentiful, one subspecies - the Quagga - became extinct in the late 19th century. Though there is currently a " +
                "plan, called the Quagga Project, that aims to breed zebras that are phenotypically similar to the Quagga, in a process " +
                "called breeding back.\n" +
                "Which Zebras are endangered?\n" +
                "subgenus Hippotigris; the plains zebra, the Grévy's zebra and the mountain zebra;horses and donkeys;aims to breed zebras" +
                 " that are phenotypically similar to the quagga; Grévy's zebra and the mountain zebra";
    }

}