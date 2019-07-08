package com.sahaj.wikipedia;

public class Question {

    private Statement statement;

    private Question(Statement statement) {
        this.statement = statement;
    }

    public static Question from(String question) {
        Statement statement = Statement.from(question);
        return new Question(statement);
    }

    public Statement getStatement() {
        return statement;
    }
}
