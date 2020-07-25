package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.controller.AnsweringController;

public class AnsweringView extends AbstractView{

    AnsweringController answeringController;

    public void setAnsweringController(AnsweringController answeringController) {
        this.answeringController = answeringController;
    }

    @Override
    public void show() {

        printStream.println("A pergunta tem de chegar aqui");

    }
}
