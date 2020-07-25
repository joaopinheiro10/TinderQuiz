package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.View;

public abstract class AbstractController implements Controller {

    protected View view;


    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void execute () {
        view.show();
    }
}
