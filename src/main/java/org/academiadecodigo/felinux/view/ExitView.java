package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.controller.ExitController;

public class ExitView extends AbstractView {

    private ExitController exitController;

    public void setExitController ( ExitController exitController ) {
        this.exitController = exitController;
    }

    @Override
    public void show () {

        printStream.println(Messages.EXIT);

    }
}
