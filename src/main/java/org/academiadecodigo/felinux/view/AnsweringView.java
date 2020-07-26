package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.AnsweringController;

public class AnsweringView extends AbstractView{

    AnsweringController answeringController;

    public void setAnsweringController(AnsweringController answeringController) {
        this.answeringController = answeringController;
    }

    @Override
    public void show() {
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(Colors.BLUE + answeringController.getGameController().getQuestion() + Colors.NOCOLOR);
        scanner.setError("");
        String test = prompt.getUserInput(scanner);
        System.out.println(test);
        answeringController.validateAnswer(test);
    }
}
