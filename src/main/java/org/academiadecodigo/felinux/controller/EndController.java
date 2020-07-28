package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.View;

public class EndController implements Runnable {

    private View view;
    private Controller nextController;

    @Override
    public void run() {
        view.show();
        nextController.execute();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }
}
