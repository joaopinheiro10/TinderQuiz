package org.academiadecodigo.felinux.controller;

public class AnsweringController extends AbstractController {

    private boolean isAnswer;

    @Override
    public void execute() {
        System.out.println("cheguei à answering controller");
        view.show();
    }

    public void validateAnswer(String answer) {
        System.out.println(answer);
        isAnswer = gameController.checkAnswer(answer);
        gameController.upDateResult(isAnswer);
    }

    public boolean isAnswer() {
        return isAnswer;
    }
}
