package com.sahaj.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnswerTest {

    private Answer answer;

    @Before
    public void setUp() {
        answer = new Answer("test answer");
        answer.setScore(2.0);
    }

    @Test
    public void shouldSetAndGetAnswer() {
        assertEquals("test answer", answer.getAnswerString());
        assertEquals(2.0d, answer.getScore(), 0.0);
    }

}