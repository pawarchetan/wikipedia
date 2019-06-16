package com.sahaj.matcher;

import com.sahaj.model.Answer;
import com.sahaj.model.Question;
import com.sahaj.model.WikipediaInput;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionAnswerMatcher {

    public List<Answer> findMatchingAnswer(WikipediaInput wikipediaInput) {
        //get list of questions with calculated score
        List<Question> questions = calculateScoreOfEachQuestion(wikipediaInput);

        //get potential match based on score
        return questions.stream()
                .map(Question::potentialMatch)
                .collect(Collectors.toList());
    }

    List<Question> calculateScoreOfEachQuestion(WikipediaInput wikipediaInput) {
        return wikipediaInput.getQuestions()
                .stream()
                .map(Question::new)
                .map(question -> question.findMatchingAnswer(wikipediaInput))
                .collect(Collectors.toList());
    }
}
