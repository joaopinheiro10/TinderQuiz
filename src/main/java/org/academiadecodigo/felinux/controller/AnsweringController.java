package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.View;

public class AnsweringController extends AbstractController {

    private boolean isAnswer;
    private View scoreView;

    @Override
    public void execute() {
        welcomeView.show();
        scoreView.show();
        view.show();
    }


    public void validateAnswer(String answer) {
        isAnswer = gameController.checkAnswer(answer);
        gameController.upDateResult(isAnswer);
    }

    public void setScoreView(View scoreView) {
        this.scoreView = scoreView;
    }
}
