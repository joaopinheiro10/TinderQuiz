package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.View;

public abstract class AbstractController implements Controller {

    protected View view;

    private Controller nextController;

    public void setNextController ( Controller nextController ) {
        this.nextController = nextController;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void execute () {
        view.show();
    }
}
