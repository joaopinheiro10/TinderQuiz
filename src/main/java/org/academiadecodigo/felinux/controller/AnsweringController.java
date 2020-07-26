package org.academiadecodigo.felinux.controller;

public class AnsweringController extends AbstractController {

    private boolean isAnswer;

    public void validateAnswer(String answer) {
        isAnswer = gameController.checkAnswer(answer);
        gameController.upDateResult(isAnswer);
    }
}
