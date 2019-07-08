package com.sahaj.wikipedia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnswerTest {

    @Test
    public void shouldReturnCorrectContentForAnswer() {
        Answer answer = Answer.from("subgenus Hippotigris");

        assertEquals("subgenus Hippotigris", answer.getContent());
    }
}
