package org.academiadecodigo.felinux.view;

public enum Quiz {

    QUESTION_0(0,"quem é o maior?", new String[] {"Benfica"}, "Benfica");

    private final String question;
    private final String[] options;
    private final String correctAnswer;
    private final int questionNumber;

    Quiz(int questionNumber, String question, String[] options, String correctAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
