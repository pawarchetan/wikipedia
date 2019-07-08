package com.sahaj.wikipedia;

public class Answer {

    private Statement statement;

    private Answer(Statement statement) {
        this.statement = statement;
    }

    public static Answer from(String answer) {
        Statement statement = Statement.from(answer);
        return new Answer(statement);
    }

    public Statement getStatement() {
        return statement;
    }

    public String getContent() {
        return statement.getContent();
    }

}
