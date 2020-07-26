package org.academiadecodigo.felinux.controller;

public class AnsweringController extends AbstractController {

    private boolean isAnswer;
/*
    @Override
    public void execute() {
        view.show();
    }
*/
    public void validateAnswer(String answer) {
        isAnswer = gameController.checkAnswer(answer);
        gameController.upDateResult(isAnswer);
    }

    public boolean isAnswer() {
        return isAnswer;
    }
}
