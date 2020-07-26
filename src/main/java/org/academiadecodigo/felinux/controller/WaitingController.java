package org.academiadecodigo.felinux.controller;


import org.academiadecodigo.felinux.view.View;

public class WaitingController extends AbstractController{

    private View scoreView;

    @Override
    public void execute() {
        welcomeView.show();
        scoreView.show();
        view.show();
    }

    public void setScoreView(View scoreView) {
        this.scoreView = scoreView;
    }
}
